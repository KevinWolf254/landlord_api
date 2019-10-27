package co.ke.proaktivio.routers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import co.ke.proaktivio.handlers.AgencyHandler;

@Configuration
public class AgencyRouter {
	@Bean
	public RouterFunction<ServerResponse> route(AgencyHandler handler) {
		return RouterFunctions.route()
				.path("/agency", builder -> builder
								.GET("", handler::find)
								.POST("", RequestPredicates.accept(MediaType.APPLICATION_JSON), handler::save)
								.DELETE("/{id}", handler::delete))
				.build();
	}
}
