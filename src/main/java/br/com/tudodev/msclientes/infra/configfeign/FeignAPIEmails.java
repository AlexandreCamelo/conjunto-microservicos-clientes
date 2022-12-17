package br.com.tudodev.msclientes.infra.configfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.tudodev.msclientes.dominio.EmailEnviar;


@FeignClient(value="diehardmsemail", path="/email")
public interface FeignAPIEmails {
	
	@PostMapping("/enviar")
	public ResponseEntity<EmailEnviar> enviar(
			@RequestBody EmailEnviar emailEnviar);
	
	
}
