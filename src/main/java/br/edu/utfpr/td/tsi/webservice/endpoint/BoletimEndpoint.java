package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.regras.IRegrasBoletim;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("boletim")
@Component
public class BoletimEndpoint {

	@Autowired
	private IRegrasBoletim regrasBoletim;

	@QueryParam("identificador")
	private String identificador;

	@QueryParam("cidade")
	private String cidade;

	@QueryParam("periodo")
	private String periodo;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorId(BoletimFurtoVeiculo b) throws ParseException {
		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();
		bd = regrasBoletim.buscarBoletim(identificador, cidade, periodo);

		return Response.ok(bd).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletim(@Valid BoletimFurtoVeiculo b) {

		regrasBoletim.cadastrar(b);

		return Response.ok(b).build();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarBoletim(@Valid BoletimFurtoVeiculo b) {

		regrasBoletim.alterar(b, identificador);

		return Response.ok(b).build();
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response removerBoletim() {

		if (regrasBoletim.deletar(identificador)) {
			return Response.ok().build();
		} else {
			return Response.status(Response.Status.BAD_REQUEST).build();
		}

	}

}
