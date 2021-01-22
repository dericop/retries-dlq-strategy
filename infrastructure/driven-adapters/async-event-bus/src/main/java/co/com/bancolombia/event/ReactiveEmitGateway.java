package co.com.bancolombia.event;

import co.com.bancolombia.model.event.gateways.gateways.EventGateway;
import jdk.nashorn.internal.runtime.logging.Logger;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.graalvm.compiler.lir.StandardOp;
import org.reactivecommons.api.domain.DomainEvent;
import org.reactivecommons.api.domain.DomainEventBus;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Log
@RequiredArgsConstructor
@Component
@EnableDirectAsyncGateway
public class ReactiveEmitGateway implements EventGateway {

    public final DomainEventBus domainEventBus;

    @Override
    public Mono<Void> emitEvent(String message) {
        DomainEvent<String> domainEvent = new DomainEvent<>("event.notification", UUID.randomUUID().toString(), message);
        return Mono.from(domainEventBus.emit(domainEvent));
    }
}
