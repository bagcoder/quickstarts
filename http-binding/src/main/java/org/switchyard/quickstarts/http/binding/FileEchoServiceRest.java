package org.switchyard.quickstarts.http.binding;

import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/b")
public interface FileEchoServiceRest {
	@POST
	@Path("/")
	public void receiveBytesIS(InputStream is);

	/**
	*/
	@POST
	@Path("/d")
	public void receiveBytes(@Context HttpServletRequest request);
	
}

