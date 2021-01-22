package co.com.bancolombia.usecase;

import co.com.bancolombia.model.event.gateways.Subscription;
import co.com.bancolombia.model.event.gateways.gateways.EventGateway;
import co.com.bancolombia.model.event.gateways.gateways.SubscriptionGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class AsyncSubcriptionUseCase {
    private final SubscriptionGateway subGateway;
    private final EventGateway eventGateway;


    public Mono<Void> subscribeEnterprise(Subscription subsc) {
        return subGateway.subscribeEnterpriseAsync(subsc)
				.then(eventGateway.emitEvent("Success Message!!!!!"));
    }
}
