package br.edu.utfpr.td.tsi.webservice.excecoes.boletim;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BoletimNaoEncontradoExceptionHandler implements ExceptionMapper<BoletimNaoEncontradoException> {

	@Override
	public Response toResponse(BoletimNaoEncontradoException exception) {
		
		return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();

	}

}
