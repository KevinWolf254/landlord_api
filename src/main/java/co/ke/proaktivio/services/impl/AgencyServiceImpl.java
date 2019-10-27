package co.ke.proaktivio.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.repositories.AgencyRepository;
import co.ke.proaktivio.services.AgencyService;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;

	@Override
	public Mono<Agency> save(Agency agency) {
		return agencyRepository.save(agency)
				.doOnError(e -> log.error("Error :: " + e.getClass() + " :: Message :: " + e.getMessage()))
				.onErrorResume(e -> Mono.error(e));
	}

	@Override
	public Mono<Agency> find(Optional<String> payBillNumber) {
		if(payBillNumber.isPresent()) {
			
			return Mono.just(payBillNumber)
					.map(r -> Integer.parseInt(r.get()))
					.flatMap(result -> agencyRepository.findByPayBillNumber(result))
					.switchIfEmpty(Mono.empty())
					.doOnError(e -> log.error("Error :: " + e.getClass() + " :: Message :: " + e.getMessage()))
					.onErrorResume(e -> Mono.error(e));
		}
		return Mono.empty();
	}

	@Override
	public Mono<Void> delete(String id) {
		return agencyRepository.deleteById(id)
				.doOnError(e -> log.error("Error :: " + e.getClass() + " :: Message :: " + e.getMessage()))
				.onErrorResume(e -> Mono.error(e));
	}

}
