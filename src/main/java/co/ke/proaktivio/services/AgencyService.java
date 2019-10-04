package co.ke.proaktivio.services;

import co.ke.proaktivio.models.domain.Agency;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AgencyService {

	public Mono<Agency> save(Agency agency);
	public Mono<Agency> findByPayBillNumber(String payBillNumber);
	public Flux<Agency> findAll();
	public Mono<Void> deleteById(String id);
}
