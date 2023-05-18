package br.edu.utfpr.td.tsi.webservice.excecoes.veiculo;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class VeiculoNaoEncontradoExceptionHandler implements ExceptionMapper<VeiculoNaoEncontradoException> {

	@Override
	public Response toResponse(VeiculoNaoEncontradoException exception) {

		return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();

	}

}
