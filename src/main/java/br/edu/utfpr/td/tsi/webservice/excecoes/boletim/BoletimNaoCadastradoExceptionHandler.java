package br.edu.utfpr.td.tsi.webservice.excecoes.boletim;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;

public class BoletimNaoCadastradoExceptionHandler implements ExceptionMapper<BoletimNaoCadastradoException> {

	@Override
	public Response toResponse(BoletimNaoCadastradoException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();

	}

}
