package co.ke.proaktivio.services;

import java.util.Optional;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.models.pojos.ResultModel;
import reactor.core.publisher.Mono;

public interface AgencyService {

//	public Mono<ResultModel> save(Agency agency);
//	public Mono<ResultModel> find(Optional<String> payBillNumber);
//	public Mono<ResultModel> deleteById(String id);
	public Mono<Agency> save(Agency agency);
	public Mono<Agency> find(Optional<String> payBillNumber);
	public Mono<Void> delete(String id);
}
