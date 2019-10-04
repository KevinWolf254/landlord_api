package co.ke.proaktivio.configs.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.ke.proaktivio.configs.handlers.AgencyHandler;


@Configuration
public class AgencyRouter {
	@Bean
    public RouterFunction<ServerResponse> route(AgencyHandler handler) {
		return RouterFunctions
				.route(RequestPredicates.GET("/agency"), handler::findAll)
				.andRoute(RequestPredicates.GET("/agency"), handler::findByPaybillNumber)
				.andRoute(RequestPredicates.POST("/agency"), handler::save);
	}
}
