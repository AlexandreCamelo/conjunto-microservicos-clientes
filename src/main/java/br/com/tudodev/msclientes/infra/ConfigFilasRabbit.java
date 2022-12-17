package br.com.tudodev.msclientes.infra;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigFilasRabbit {

	@Value("${rabbitmq.filas.email}")
	private String filaEnvioEmail;

	@Bean
	public Queue filaEmail() {
		return new Queue(filaEnvioEmail, true);
	}

}
