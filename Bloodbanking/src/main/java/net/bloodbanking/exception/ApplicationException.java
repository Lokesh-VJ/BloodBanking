package net.bloodbanking.exception;

import java.util.ArrayList;
import java.util.List;

public class ApplicationException extends Exception {

	private static final long serialVersionUID = 7287740981822872554L;
	
	private List<ApplicationMessage> messages = null;
	
	public ApplicationException( List<ApplicationMessage> messages ) {
		this.setMessages(messages);
	}
	
	public ApplicationException(String key, Object[] parameters,Throwable e){
		super(e);
		this.addMessage(key, parameters);
	}
	
	public ApplicationException(String key, Object[] parameters){
		this.addMessage(key, parameters);
	}
	
	public ApplicationException(String key){
		this.addMessage(key, null);
	}

	public List<ApplicationMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<ApplicationMessage> messages) {
		this.messages = messages;
	}
	
	public void addMessage(String key, Object[] parameters){
		if(messages == null){
			messages = new ArrayList<ApplicationMessage>();
		}
		messages.add(new ApplicationMessage(key, parameters));
	}
	
	public void printErrors() {
		if( messages != null ) {
			for (ApplicationMessage message : messages) {
				System.err.println(message.getKey() +  ": " + 
						((message.getParameters() != null && message.getParameters().length > 0 ) ?
								message.getParameters()[0] : ""));
			}
		}
	}
	
	public boolean containsErrorCode( String errorCode ) {
		if( messages != null ) {
			for (ApplicationMessage message : messages) {
				if( message.getKey().equals(errorCode)) {
					return true;
				}
			}
		}
		return false;
	}
}
