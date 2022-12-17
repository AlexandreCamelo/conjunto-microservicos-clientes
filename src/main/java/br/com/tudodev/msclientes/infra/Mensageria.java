package br.com.tudodev.msclientes.infra;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.tudodev.msclientes.dominio.EmailEnviar;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Component
@Data
@Slf4j
public class Mensageria {
	
	@Autowired
	private final RabbitTemplate rabbitTemplate;
	@Autowired
	private final Queue filaEmissaoCartao;
	@Autowired
	private final Queue filaEmail;
	
	
	public void enviarEmail(EmailEnviar emailEnviar) {
		String payloadParaMensageria = converteEmailEnviarParaString(emailEnviar);
		
		if(payloadParaMensageria != null && payloadParaMensageria.length() > 0) {
			rabbitTemplate.convertAndSend(filaEmail.getName(), payloadParaMensageria);	
		}else {
			log.error("Não foi possível enviar email pelo serviço de mensageria. Não foi possível converter a entidade 'EmailEnviar'");
		}
		
		
	}
	
	
	
	
	private String converteEmailEnviarParaString(EmailEnviar emailEnviar) {
		try {
			ObjectMapper mapeador = new ObjectMapper();
			String jsonRetorno;
			jsonRetorno = mapeador.writeValueAsString(emailEnviar);
			return jsonRetorno;
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return "";
		}
		
	}
	
	
	
	
	
}


