package org.koushik.javabrains.messenger.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.koushik.javabrains.messenger.model.ErrorMessage;

//for registering in jersey use @Provider
//@Provider
public class GenericExceptionMapper implements ExceptionMapper<Throwable> {

	@Override
	public Response toResponse(Throwable ex) {
		ErrorMessage em = new ErrorMessage(ex.getMessage(), 500, "http://codemaster.org/badurl");
		return Response.status(Status.INTERNAL_SERVER_ERROR).entity(em).build();
	}

}
