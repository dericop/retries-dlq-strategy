package co.com.bancolombia.usecase;

import co.com.bancolombia.model.event.gateways.Subscription;
import co.com.bancolombia.model.event.gateways.gateways.DiscardGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DiscardSubscriptionUseCase {

	private final DiscardGateway discardGateway;

	public Mono<Void> notifyDiscard(Subscription subs){
		return discardGateway.discardSubscription(subs);
	}	
}
