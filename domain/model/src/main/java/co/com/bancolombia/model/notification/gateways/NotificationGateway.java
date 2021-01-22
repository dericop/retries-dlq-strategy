package co.com.bancolombia.model.notification.gateways;

import reactor.core.publisher.Mono;

public interface NotificationGateway {

    Mono<Void> sendNotification(String message);
}
