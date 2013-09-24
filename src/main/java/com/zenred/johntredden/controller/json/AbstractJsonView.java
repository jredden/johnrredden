package com.zenred.johntredden.controller.json;

import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public abstract class AbstractJsonView implements View {
	
	public static final String JSON_ROOT = "root";
	protected XStream xstream = new XStream(new JettisonMappedXmlDriver()); 
	
	@SuppressWarnings("rawtypes")
	public AbstractJsonView(Class clazz){
		xstream.processAnnotations(clazz);
	}

	public String getContentType() {
		return "text/html; charset=UTF-8";
	}

	@SuppressWarnings("rawtypes")
	public void render(Map model, HttpServletRequest arg1,
			HttpServletResponse response) throws Exception {
		Object _root = model.get(AbstractJsonView.JSON_ROOT);
		PrintWriter writer = response.getWriter();
		String json = xstream.toXML(_root);
		System.out.println("json: " + json);
		writer.write(json);
	}

}
