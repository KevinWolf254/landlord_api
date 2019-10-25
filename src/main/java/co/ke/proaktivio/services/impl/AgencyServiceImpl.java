package co.ke.proaktivio.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import co.ke.proaktivio.models.domain.Agency;
import co.ke.proaktivio.models.pojos.Response;
import co.ke.proaktivio.repositories.AgencyRepository;
import co.ke.proaktivio.services.AgencyService;
import reactor.core.publisher.Mono;

public class AgencyServiceImpl implements AgencyService {

	@Autowired
	private AgencyRepository agencyRepository;

	@Override
	public Mono<Response> save(Agency agency) {
		return agencyRepository.save(agency).flatMap(result -> {
			final List<Object> agencies = new ArrayList<Object>();
			agencies.add(result);

			final Response response = new Response();
			response.setMessage("Agency saved successfully");
			response.setData(agencies);
			response.setStatus(HttpStatus.OK);
			response.setSuccess(true);

			return Mono.just(response);
		});
	}

	@Override
	public Mono<Response> find(Optional<String> payBillNumber) {
		if (payBillNumber.isPresent())
			return agencyRepository.findByPayBillNumber(payBillNumber.get()).flatMap(result -> {
				final List<Object> agencies = new ArrayList<Object>();
				agencies.add(result);

				final Response response = new Response();
				response.setMessage("Agency found");
				response.setData(agencies);
				response.setStatus(HttpStatus.OK);
				response.setSuccess(true);

				return Mono.just(response);
			});
		return Mono.empty();
	}

//	@Override
//	public Flux<Agency> findAll() {
//		return agencyRepository.findAll();
//	}
	@Override
	public Mono<Response> deleteById(String id) {
		return agencyRepository.deleteById(id).flatMap(v -> {
			final Response response = new Response();
			response.setMessage("Agency deleted successfully");
			response.setStatus(HttpStatus.OK);
			response.setSuccess(true);
			return Mono.just(response);
		});
	}
}
