package co.com.bancolombia.model.event.gateways.gateways;

import co.com.bancolombia.model.event.gateways.Subscription;
import reactor.core.publisher.Mono;

public interface SubscriptionGateway {
	Mono<Void> subscribeEnterpriseAsync(Subscription subsc);
}
