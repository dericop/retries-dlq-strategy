package co.com.bancolombia.model.event.gateways;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Subscription implements Serializable {
	private int id;
	private String name;
	private String enterprise;

	public static final String COMMAND_NAME = "subscriptions.subscribe";
}
