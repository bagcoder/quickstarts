package org.switchyard.quickstarts.http.binding;

import javax.servlet.http.HttpServletRequest;

public interface FileEchoService {
	public void receiveBytes(HttpServletRequest request);	

}
