package br.edu.utfpr.td.tsi.webservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.endpoint.BoletimEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.VeiculoEndpoint;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoAlteradoExceptionHandler;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoCadastradoExceptionHandler;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoEncontradoExceptionHandler;
import br.edu.utfpr.td.tsi.webservice.excecoes.boletim.BoletimNaoExcluidoExceptionHandler;
import br.edu.utfpr.td.tsi.webservice.excecoes.veiculo.VeiculoNaoEncontradoExceptionHandler;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("webservice")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		this.register(BoletimEndpoint.class);
		this.register(VeiculoEndpoint.class);
		this.register(BoletimNaoEncontradoExceptionHandler.class);
		this.register(VeiculoNaoEncontradoExceptionHandler.class);
		this.register(BoletimNaoExcluidoExceptionHandler.class);
		this.register(BoletimNaoAlteradoExceptionHandler.class);
		this.register(BoletimNaoCadastradoExceptionHandler.class);
	}

}
