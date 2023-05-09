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

@Path("veiculo-cor-endpoint")
@Component
public class VeiculoCorEndpoint {
	
	@Autowired
	private RegrasVeiculo regrasVeiculo;
	
	@QueryParam("cor")
	private String cor;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCor() throws ParseException {
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos = regrasVeiculo.buscarPorCor(cor);

		return Response.ok(veiculos).build();

	}

}
