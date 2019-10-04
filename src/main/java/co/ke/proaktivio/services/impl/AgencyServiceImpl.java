package co.ke.proaktivio.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.repositories.AgencyRepository;
import co.ke.proaktivio.services.AgencyService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;
	
	@Override
	public Mono<Agency> save(Agency agency) {
		return agencyRepository.save(agency);
	}
	@Override
	public Mono<Agency> findByPayBillNumber(String payBillNumber) {
		return agencyRepository.findByPayBillNumber(payBillNumber);
	}
	@Override
	public Flux<Agency> findAll() {
		return agencyRepository.findAll();
	}
	@Override
	public Mono<Void> deleteById(String id) {
		return agencyRepository.deleteById(id);
	}
}
