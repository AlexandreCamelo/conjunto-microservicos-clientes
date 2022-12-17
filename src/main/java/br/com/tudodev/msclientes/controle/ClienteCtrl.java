package br.com.tudodev.msclientes.controle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tudodev.msclientes.dominio.EmailEnviar;
import br.com.tudodev.msclientes.servico.ClienteServ;

@RestController
@RequestMapping("clientes")
public class ClienteCtrl {

	@Autowired
	ClienteServ servico;
	
	@PostMapping("/enviarEmail")
	public ResponseEntity<EmailEnviar> enviarEmail(
			@RequestBody EmailEnviar emailEnviar) {
		return servico.enviarEmail(emailEnviar);
	}

	@PostMapping("/enviarEmailMensageria")
	public void enviarEmailMensageria(@RequestBody EmailEnviar emailEnviar) {
		servico.enviarEmailMensageria(emailEnviar);
	}

}
