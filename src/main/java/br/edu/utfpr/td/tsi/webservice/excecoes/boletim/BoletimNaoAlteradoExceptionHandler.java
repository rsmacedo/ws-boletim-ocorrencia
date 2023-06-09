package br.edu.utfpr.td.tsi.webservice.excecoes.boletim;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BoletimNaoAlteradoExceptionHandler implements ExceptionMapper<BoletimNaoAlteradoException> {

	@Override
	public Response toResponse(BoletimNaoAlteradoException exception) {
		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();

	}

}
