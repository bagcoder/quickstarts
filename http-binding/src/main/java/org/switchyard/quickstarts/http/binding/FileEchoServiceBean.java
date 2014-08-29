package org.switchyard.quickstarts.http.binding;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.Context;

import org.apache.commons.io.IOUtils;
import org.switchyard.component.bean.Service;

@Service(FileEchoService.class)
public class FileEchoServiceBean implements FileEchoService {

	public void receiveBytes(@Context HttpServletRequest request) {
		HttpSession session = request.getSession(true);
        Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
                String key = (String) headerNames.nextElement();
                String value = request.getHeader(key);
                System.out.printf("Header %s; Value %s\n", key, value);
                if ("MSG".equalsIgnoreCase(key)) {
                	String msg = (String) session.getAttribute("MSG");
                	msg += " " + value;
                	System.out.println("MSG:" + msg);
                	session.setAttribute("MSG", msg);
                }
        }
		try {
			this.receiveBytesIS(request.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void receiveBytesIS(InputStream is) {
		System.out.println("receiveBytes(InputStream is)");
		
		StringWriter writer = new StringWriter();
		try {
			IOUtils.copy(is, writer);
			String inputData = writer.toString();
			System.out.println("inpuptData:" + inputData);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	


}
