package co.ke.proaktivio.services;

import java.util.Optional;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.models.pojos.Response;
import reactor.core.publisher.Mono;

public interface AgencyService {

	public Mono<Response> save(Agency agency);
	public Mono<Response> find(Optional<String> payBillNumber);
//	public Flux<Agency> findAll();
	public Mono<Response> deleteById(String id);
}
