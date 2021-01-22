package co.com.bancolombia.config;

import co.com.bancolombia.model.event.gateways.gateways.CommandGateway;
import co.com.bancolombia.model.event.gateways.gateways.DiscardGateway;
import co.com.bancolombia.model.event.gateways.gateways.EventGateway;
import co.com.bancolombia.model.event.gateways.gateways.SubscriptionGateway;
import co.com.bancolombia.model.notification.gateways.NotificationGateway;
import co.com.bancolombia.usecase.AsyncSubcriptionUseCase;
import co.com.bancolombia.usecase.DiscardSubscriptionUseCase;
import co.com.bancolombia.usecase.NotificationUseCase;
import co.com.bancolombia.usecase.SubscriptionUseCase;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

	@Bean
	public SubscriptionUseCase createSubUsecase(CommandGateway gateway){
		return new SubscriptionUseCase(gateway);
	}

	@Bean
	public AsyncSubcriptionUseCase createAsyncUseCase(SubscriptionGateway gateway, EventGateway eventGateway){
		return new AsyncSubcriptionUseCase(gateway, eventGateway);
	}

	@Bean
	public DiscardSubscriptionUseCase createDiscardSubscription(DiscardGateway gateway){
		return new DiscardSubscriptionUseCase(gateway);
	}

	@Bean
	public NotificationUseCase createNotificationUseCase(NotificationGateway notificationGateway){
		return new NotificationUseCase(notificationGateway);
	}
}
