package co.com.bancolombia.usecase;

import co.com.bancolombia.model.notification.gateways.NotificationGateway;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class NotificationUseCase {

    private final NotificationGateway notificationGateway;

    public Mono<Void> sendNotification(String message) {
        return notificationGateway.sendNotification(message);
    }


}
