package co.ke.proaktivio.configs.handlers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.models.pojos.Response;
import co.ke.proaktivio.services.AgencyService;
import reactor.core.publisher.Mono;

@Component
public class AgencyHandler {
	@Autowired
	private AgencyService agencyService;
	
	public Mono<ServerResponse> find(ServerRequest request) {
		final Optional<String> paybillNumber = request.queryParam("payBillNumber");
		
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(agencyService.find(paybillNumber), Response.class);
	}
	
	public Mono<ServerResponse> save(ServerRequest request) {
		final Mono<Response> result = request
				.bodyToMono(Agency.class)
				.flatMap(agency -> agencyService.save(agency));
		
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(result, Response.class))
				.log();
	}
	
//	public Mono<ServerResponse> findAll(ServerRequest request) {
//		return ServerResponse
//				.ok() 
//				.contentType(MediaType.APPLICATION_JSON)
//				.body(agencyService.findAll(), Agency.class);
//	}
	
	public Mono<ServerResponse> delete(ServerRequest request) {
		final String id = request.pathVariable("id");
		return ServerResponse
				.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(agencyService.deleteById(id), Response.class);
	}
}
