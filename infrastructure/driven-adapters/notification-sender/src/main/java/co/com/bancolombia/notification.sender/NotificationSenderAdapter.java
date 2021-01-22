package co.com.bancolombia.notification.sender;

import co.com.bancolombia.model.notification.gateways.NotificationGateway;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@NoArgsConstructor
public class NotificationSenderAdapter implements NotificationGateway {

    @Override
    public Mono<Void> sendNotification(String message) {
        System.out.println("Enviando Notificación " + message);
        return Mono.empty();
    }
}
