package co.com.bancolombia.eventsubscriptions;

import co.com.bancolombia.model.event.gateways.Subscription;
import co.com.bancolombia.usecase.AsyncSubcriptionUseCase;
import co.com.bancolombia.usecase.DiscardSubscriptionUseCase;
import co.com.bancolombia.usecase.NotificationUseCase;
import lombok.RequiredArgsConstructor;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.async.api.HandlerRegistry;
import org.reactivecommons.async.impl.config.annotations.EnableMessageListeners;
import reactor.core.publisher.Mono;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import static org.reactivecommons.async.api.HandlerRegistry.*;

@EnableMessageListeners
@Configuration
@RequiredArgsConstructor
public class ListenersConfig {

	private final AsyncSubcriptionUseCase subsUseCase;
	private final DiscardSubscriptionUseCase discardUseCase;
	private final NotificationUseCase notificationUseCase;

	@Bean
	public HandlerRegistry handleEventSubscriptions() {
		return register()
				.handleCommand(Subscription.COMMAND_NAME, this::handleSubscription, Subscription.class)
				.listenEvent(Subscription.COMMAND_NAME+".dlq", this::handleDiscard,  Subscription.class)
				.listenEvent("event.notification", this::sendNotification, String.class);
	}

	private Mono<Void> sendNotification(DomainEvent<String> message) {
		return notificationUseCase.sendNotification(message.getData());
	}

	private <T> Mono<Void> handleSubscription(Command<Subscription> command) {
		return subsUseCase.subscribeEnterprise(command.getData());
	}

	private <T> Mono<Void> handleDiscard(DomainEvent<Subscription> subsEvent) {
		return discardUseCase.notifyDiscard(subsEvent.getData());
	}
}
