package com.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class WelcomeTag extends TagSupport {
	     
	    public int doStartTag() throws JspException {
	        try {
	            JspWriter out = pageContext.getOut();
	            out.print("Welcome User!");
	            
	        } catch(IOException ioe) {
	            ioe.printStackTrace();
	        }       
	        return SKIP_BODY;
	    }
	    
	    
	   
}
