package co.com.bancolombia.restservice;

import co.com.bancolombia.model.event.gateways.Subscription;
import co.com.bancolombia.model.event.gateways.gateways.SubscriptionGateway;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;

@Component
public class APISubscription implements SubscriptionGateway {

	@Override
	public Mono<Void> subscribeEnterpriseAsync(Subscription subsc) {
		// simulate http request
		return Mono.error(new Error("He fallado, lo siento!!"));
	}
}
