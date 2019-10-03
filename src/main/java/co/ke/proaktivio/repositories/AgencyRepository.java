package co.ke.proaktivio.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import co.ke.proaktivio.models.domain.Agency;

public interface AgencyRepository extends  ReactiveMongoRepository<Agency, String>{

}
