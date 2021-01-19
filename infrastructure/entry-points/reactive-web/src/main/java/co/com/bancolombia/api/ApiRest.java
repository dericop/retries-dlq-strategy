package co.com.bancolombia.api;

import co.com.bancolombia.model.event.gateways.Subscription;
import co.com.bancolombia.usecase.SubscriptionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/api", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
@AllArgsConstructor
public class ApiRest {
    private final SubscriptionUseCase useCase;

    @PostMapping(path = "/subscribe")
    public Mono<Void> subscribe(@RequestBody SubscriptionDTO subscriptionDTO) {
        Subscription subs = Subscription.builder()
                .id(subscriptionDTO.getId())
                .name(subscriptionDTO.getName())
                .enterprise(subscriptionDTO.getEnterprise())
                .build();
        return useCase.subscribe(subs);
    }
}
