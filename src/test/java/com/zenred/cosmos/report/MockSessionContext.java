package com.zenred.cosmos.report;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Enumeration;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

@SuppressWarnings("unused")
public class MockSessionContext {
	
	static ServletContext servletContext = new ServletContext() {
		
		@Override
		public void setAttribute(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeAttribute(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void log(String arg0, Throwable arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void log(Exception arg0, String arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void log(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public Enumeration getServlets() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Enumeration getServletNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getServletContextName() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Servlet getServlet(String arg0) throws ServletException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getServerInfo() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Set getResourcePaths(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public InputStream getResourceAsStream(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public URL getResource(String arg0) throws MalformedURLException {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public RequestDispatcher getRequestDispatcher(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getRealPath(String arg0) {
			// does nothing to path
			return "";
		}
		
		@Override
		public RequestDispatcher getNamedDispatcher(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getMinorVersion() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public String getMimeType(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getMajorVersion() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Enumeration getInitParameterNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public String getInitParameter(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ServletContext getContext(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Enumeration getAttributeNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getAttribute(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
	};
	HttpSession httpSession = new HttpSession() {
		
		@Override
		public void setMaxInactiveInterval(int arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void setAttribute(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeValue(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeAttribute(String arg0) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void putValue(String arg0, Object arg1) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isNew() {
			// TODO Auto-generated method stub
			return false;
		}
		
		@Override
		public void invalidate() {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public String[] getValueNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getValue(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public HttpSessionContext getSessionContext() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public ServletContext getServletContext() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public int getMaxInactiveInterval() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public long getLastAccessedTime() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public long getCreationTime() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		@Override
		public Enumeration getAttributeNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
		@Override
		public Object getAttribute(String arg0) {
			// TODO Auto-generated method stub
			return null;
		}
	};

}
