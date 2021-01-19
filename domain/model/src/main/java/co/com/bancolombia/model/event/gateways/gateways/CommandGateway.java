package co.com.bancolombia.model.event.gateways.gateways;

import co.com.bancolombia.model.event.gateways.Subscription;
import reactor.core.publisher.Mono;

/**
 * Interfaz propia del dominio para emitir eventos completamente definidos por las necesidades del dominio
 * El tipo Event se puede enriquecer en la medida que sea necesario.
 */
public interface CommandGateway {
    Mono<Void> emitCommand(Subscription event);
}
