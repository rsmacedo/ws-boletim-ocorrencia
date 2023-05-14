package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.Veiculo;
import br.edu.utfpr.td.tsi.webservice.regras.IRegrasVeiculo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("veiculo")
@Component
public class VeiculoEndpoint {
	
	@Autowired
	private IRegrasVeiculo regrasVeiculo;
	
	@QueryParam("placa")
	private String placa;
	
	@QueryParam("cor")
	private String cor;
	
	@QueryParam("tipo")
	private String tipo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCor() throws ParseException {
		ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
		veiculos = regrasVeiculo.buscarVeiculo(placa, cor, tipo);
		return Response.ok(veiculos).build();

	}

}
