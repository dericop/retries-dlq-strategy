package co.com.bancolombia.dynamodbfallback;

import co.com.bancolombia.model.event.gateways.Subscription;
import co.com.bancolombia.model.event.gateways.gateways.DiscardGateway;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;

@Component
public class DynamoFallback implements DiscardGateway {
	@Override
	public Mono<Void> discardSubscription(Subscription subs) {
		// dynamodb logic to save subscription
		System.out.println("Mensaje descartado, procesando en DynamoDB");
		return Mono.empty();
	}
}
