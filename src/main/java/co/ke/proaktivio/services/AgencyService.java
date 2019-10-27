package co.ke.proaktivio.services;

import java.util.Optional;

import co.ke.proaktivio.models.domain.Agency;
import reactor.core.publisher.Mono;

public interface AgencyService {

	public Mono<Agency> save(Agency agency);
	public Mono<Agency> find(Optional<String> payBillNumber);
	public Mono<Void> delete(String id);
}
