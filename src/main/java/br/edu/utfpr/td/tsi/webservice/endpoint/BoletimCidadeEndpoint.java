package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.regras.IRegrasBoletim;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim-cidade-endpoint")
@Component
public class BoletimCidadeEndpoint {

	@Autowired
	private IRegrasBoletim regrasBoletim;
	
	@QueryParam("cidade")
	private String cidade;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCidade() throws ParseException {

		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();
		bd = regrasBoletim.buscarPorCidade(cidade);

		return Response.ok(bd).build();

	}

}
