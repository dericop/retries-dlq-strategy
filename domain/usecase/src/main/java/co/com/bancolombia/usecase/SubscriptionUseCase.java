package co.com.bancolombia.usecase;

import co.com.bancolombia.model.event.gateways.gateways.CommandGateway;
import co.com.bancolombia.model.event.gateways.Subscription;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SubscriptionUseCase {
	private final CommandGateway gateway;

	public Mono<Void> subscribe(Subscription subs){
		return gateway.emitCommand(subs);
	}
}
