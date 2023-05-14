package br.edu.utfpr.td.tsi.webservice;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.endpoint.BoletimEndpoint;
import br.edu.utfpr.td.tsi.webservice.endpoint.VeiculoEndpoint;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("webservice")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {

		this.register(BoletimEndpoint.class);
		this.register(VeiculoEndpoint.class);
	}

}
