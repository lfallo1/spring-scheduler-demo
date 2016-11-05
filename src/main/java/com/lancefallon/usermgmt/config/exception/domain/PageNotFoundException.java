package com.lancefallon.usermgmt.config.exception.domain;

public class PageNotFoundException extends AbstractException {
    private static final long serialVersionUID = 1L;
    
    private CustomErrorMessage error;
    
    public PageNotFoundException(){
    	CustomErrorMessage error = new CustomErrorMessage("404", "Page not found");
        this.error = error; 
    }
    
    public CustomErrorMessage getError(){
        return this.error;
    }
}
