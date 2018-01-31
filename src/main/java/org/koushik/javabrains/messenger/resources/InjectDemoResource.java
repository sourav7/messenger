package org.koushik.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {
	@GET
	@Path("annotations")
	public String getParameterUsingAnnotations(@MatrixParam("param") String matrixParam,
			@HeaderParam("authSessionId") String header, @CookieParam("name") String cookie) {

		/*
		 * There is another query param called form param @FormParam This is not widely
		 * used
		 */
		return "Matrix param: " + matrixParam + " Header param : " + header + " Cookie param : " + cookie;

	}

	@GET
	@Path("context")
	public String getParameterUsingContext(@Context UriInfo uriInfo) {
		
		return uriInfo.getAbsolutePath().toString();
	}
}
