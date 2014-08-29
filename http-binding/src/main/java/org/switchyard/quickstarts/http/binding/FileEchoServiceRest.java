package org.switchyard.quickstarts.http.binding;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/b")
public interface FileEchoServiceRest {

	@POST
	@Path("/d")
	public void receiveBytes(@Context HttpServletRequest request);

}
