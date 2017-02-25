package net.bloodbanking.exception;

import java.util.ArrayList;
import java.util.List;

public class NhanceApplicationException extends Exception {

	private static final long serialVersionUID = 7287740981822872554L;
	
	private List<NhanceApplicationMessage> messages = null;
	
	public NhanceApplicationException( List<NhanceApplicationMessage> messages ) {
		this.setMessages(messages);
	}
	
	public NhanceApplicationException(String key, Object[] parameters,Throwable e){
		super(e);
		this.addMessage(key, parameters);
	}
	
	public NhanceApplicationException(String key, Object[] parameters){
		this.addMessage(key, parameters);
	}
	
	public NhanceApplicationException(String key){
		this.addMessage(key, null);
	}

	public List<NhanceApplicationMessage> getMessages() {
		return messages;
	}

	public void setMessages(List<NhanceApplicationMessage> messages) {
		this.messages = messages;
	}
	
	public void addMessage(String key, Object[] parameters){
		if(messages == null){
			messages = new ArrayList<NhanceApplicationMessage>();
		}
		messages.add(new NhanceApplicationMessage(key, parameters));
	}
	
	public void printErrors() {
		if( messages != null ) {
			for (NhanceApplicationMessage message : messages) {
				System.err.println(message.getKey() +  ": " + 
						((message.getParameters() != null && message.getParameters().length > 0 ) ?
								message.getParameters()[0] : ""));
			}
		}
	}
	
	public boolean containsErrorCode( String errorCode ) {
		if( messages != null ) {
			for (NhanceApplicationMessage message : messages) {
				if( message.getKey().equals(errorCode)) {
					return true;
				}
			}
		}
		return false;
	}
}
