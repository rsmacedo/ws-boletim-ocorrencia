package br.edu.utfpr.td.tsi.webservice.excecoes.boletim;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BoletimNaoExcluidoExceptionHandler implements ExceptionMapper<BoletimNaoExcluidoException> {

	@Override
	public Response toResponse(BoletimNaoExcluidoException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();

	}

}
