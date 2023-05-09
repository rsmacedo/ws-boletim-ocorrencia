package br.edu.utfpr.td.tsi.webservice.endpoint;

import java.text.ParseException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.utfpr.td.tsi.webservice.modelo.BoletimFurtoVeiculo;
import br.edu.utfpr.td.tsi.webservice.regras.RegrasBoletim;
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

@Path("endpoint")
@Component
public class Endpoint {

	@Autowired
	private RegrasBoletim regrasBoletim;

	@QueryParam("identificador")
	private String identificador;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarTexto() throws ParseException {

		// busquei no banco de dados uma informacao
		/*
		 * Parte p = new Parte("Rafael", "raffah@gmail.com", "44998195112", "vitima");
		 * Endereco e = new Endereco("Rua Carlos", 261, "Jardim Tocantins", "Toledo",
		 * "PR"); Emplacamento placa = new Emplacamento("AOX", "PR", "Toledo"); Veiculo
		 * v = new Veiculo(2016, "preto", "Honda", "moto", placa); LocalDate dia =
		 * LocalDate.of(2023, Month.MAY, 8); DateTimeFormatter formatador =
		 * DateTimeFormatter.ofPattern("dd/MM/yyyy"); String valorFormatado =
		 * dia.format(formatador); BoletimFurtoVeiculo b = new BoletimFurtoVeiculo("01",
		 * dia, "tarde", p, e, v); Date data = new Date(); BoletimFurtoVeiculo b = new
		 * BoletimFurtoVeiculo("01", data, "tarde", p, e, v);
		 */
		ArrayList<BoletimFurtoVeiculo> bd = new ArrayList<>();
		bd = regrasBoletim.listarTodos();

		return Response.ok(bd).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response cadastrarBoletim(BoletimFurtoVeiculo b) {

		regrasBoletim.cadastrar(b);

		return Response.ok("Recurso Web criado com sucesso: \n" + b).build();

	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response alterarBoletim(BoletimFurtoVeiculo b) {

		regrasBoletim.alterar(b, identificador);

		return Response.ok("Recurso Web alterado com sucesso: \n" + b).build();
	}

	@DELETE
	@Produces(MediaType.TEXT_PLAIN)
	public Response removerBoletim() {

		regrasBoletim.deletar(identificador);

		return Response.ok("Boletim removido com sucesso\n").build();
	}

}
