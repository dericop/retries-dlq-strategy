package co.com.bancolombia.model.event.gateways.gateways;

import reactor.core.publisher.Mono;

public interface EventGateway {

    Mono<Void> emitEvent(String message);
}
