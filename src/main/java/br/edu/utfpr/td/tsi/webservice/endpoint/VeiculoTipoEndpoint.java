package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasBoletim;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasVeiculo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("veiculo-tipo-endpoint")
@Component
public class VeiculoTipoEndpoint {
	
	@Autowired
	private RegrasVeiculo regrasVeiculo;
	
	@QueryParam("tipo")
	private String tipo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorTipo() throws ParseException {
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos = regrasVeiculo.buscarPorTipo(tipo);

		return Response.ok(veiculos).build();

	}

}
