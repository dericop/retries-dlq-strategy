package co.com.bancolombia.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
public class SubscriptionDTO {
	private int id;
	private String name;
	private String enterprise;
}
