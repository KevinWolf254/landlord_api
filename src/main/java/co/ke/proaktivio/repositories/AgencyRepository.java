package co.ke.proaktivio.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.ke.proaktivio.models.domain.Agency;
import reactor.core.publisher.Mono;

public interface AgencyRepository extends  ReactiveMongoRepository<Agency, String>{
	public Mono<Agency> findByPayBillNumber(String payBillNumber);
}
