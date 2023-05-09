package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasBoletim;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim-periodo-endpoint")
@Component
public class BoletimPeriodoEndpoint {

	@Autowired
	private RegrasBoletim regrasBoletim;
	
	@QueryParam("periodo")
	private String periodo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCidade() throws ParseException {

		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();
		bd = regrasBoletim.buscarPorPeriodo(periodo);

		return Response.ok(bd).build();

	}

}
