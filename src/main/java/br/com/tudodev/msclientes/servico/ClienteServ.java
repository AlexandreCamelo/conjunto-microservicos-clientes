package br.com.tudodev.msclientes.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.tudodev.msclientes.dominio.EmailEnviar;
import br.com.tudodev.msclientes.infra.Mensageria;
import br.com.tudodev.msclientes.infra.configfeign.FeignAPIEmails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClienteServ {

	private final Mensageria mensageria;

	@Autowired
	FeignAPIEmails feignAPIEmails;

	public ResponseEntity<EmailEnviar> enviarEmail(EmailEnviar emailEnviar) {
		log.info("Enviando email pelo feign...");
		return feignAPIEmails.enviar(emailEnviar);
	}

	public void enviarEmailMensageria(EmailEnviar emailEnviar) {
		log.info("Enviando email por mensageria...");
		mensageria.enviarEmail(emailEnviar);
	}
}
