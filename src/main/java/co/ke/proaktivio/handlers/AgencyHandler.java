package co.ke.proaktivio.handlers;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.models.pojos.ResultModel;
import co.ke.proaktivio.services.AgencyService;
import reactor.core.publisher.Mono;

@Component
public class AgencyHandler {
	@Autowired
	private AgencyService agencyService;

	public Mono<ServerResponse> find(ServerRequest request) {
		final Optional<String> paybillNumber = request.queryParam("payBillNumber");

		return agencyService.find(paybillNumber).flatMap(agency -> Mono.just(Collections.singletonList(agency)))
				.flatMap(
						result -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
								.body(Mono.just(ResultModel.builder().isSuccess(false).status(HttpStatus.OK.value())
										.message("success").data(result).build()), ResultModel.class))
				.onErrorResume(e -> {
					if (e instanceof NumberFormatException)
						return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON)
								.body(Mono.just(ResultModel.builder().isSuccess(false)
										.status(HttpStatus.BAD_REQUEST.value()).message(e.getMessage()).build()),
										ResultModel.class);
					return ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR)
							.contentType(MediaType.APPLICATION_JSON)
							.body(Mono.just(ResultModel.builder().isSuccess(false)
									.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message(e.getMessage()).build()),
									ResultModel.class);
				});
	}

	public Mono<ServerResponse> save(ServerRequest request) {
		Mono<ResultModel> response = request.bodyToMono(Agency.class).flatMap(agency -> agencyService.save(agency))
				.flatMap(agency -> Mono.just(Collections.singletonList(agency)))
				.flatMap(result -> Mono.just(ResultModel.builder().isSuccess(true).status(HttpStatus.OK.value())
						.message("success").data(result).build()))
				.onErrorResume(e -> Mono.just(ResultModel.builder().isSuccess(true)
						.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("failure").build()));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(BodyInserters.fromPublisher(response, ResultModel.class));

	}

	public Mono<ServerResponse> delete(ServerRequest request) {
		final String id = request.pathVariable("id");
		final Mono<ResultModel> response = agencyService.delete(id)
				.flatMap(v -> Mono.just(
						ResultModel.builder().isSuccess(true).status(HttpStatus.OK.value()).message("success").build()))
				.onErrorResume(e -> Mono.just(ResultModel.builder().isSuccess(true)
						.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).message("failure").build()));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(response, ResultModel.class);
	}

}
