package br.edu.utfpr.td.tsi.webservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.endpoint.BoletimCidadeEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.BoletimPeriodoEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.Endpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.ListaBoletinsEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.VeiculoCorEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.VeiculoPlacaEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.VeiculoTipoEndpoint;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("webservice")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		this.register(Endpoint.class);
		this.register(ListaBoletinsEndpoint.class);
		this.register(BoletimCidadeEndpoint.class);
		this.register(BoletimPeriodoEndpoint.class);
		this.register(VeiculoPlacaEndpoint.class);
		this.register(VeiculoCorEndpoint.class);
		this.register(VeiculoTipoEndpoint.class);

	}

}
