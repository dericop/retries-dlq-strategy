package co.com.bancolombia.event;

import java.util.UUID;

import co.com.bancolombia.model.event.gateways.gateways.CommandGateway;
import co.com.bancolombia.model.event.gateways.Subscription;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.reactivecommons.api.domain.Command;
import org.reactivecommons.async.api.DirectAsyncGateway;
import org.reactivecommons.async.impl.config.annotations.EnableDirectAsyncGateway;
import reactor.core.publisher.Mono;

import org.springframework.stereotype.Component;

@Log
@Component
@EnableDirectAsyncGateway
@RequiredArgsConstructor
public class ReactiveEventsGateway implements CommandGateway {

    private final DirectAsyncGateway asyncGateway;
    private static final String TARGET = "retries-dlq-strategy"; // comentario del nombre

    @Override
    public Mono<Void> emitCommand(Subscription subs) {   // send
        String uuid = UUID.randomUUID().toString();
        return asyncGateway.sendCommand(new Command<>("subscriptions.subscribe", uuid, subs), TARGET);
    }
}
