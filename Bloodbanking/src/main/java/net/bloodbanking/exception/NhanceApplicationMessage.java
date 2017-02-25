package net.bloodbanking.exception;

import java.io.Serializable;

public class NhanceApplicationMessage implements Serializable{
	
	private static final long serialVersionUID = 8329518251567604229L;
	
	private String key;
	
	private Object[] parameters;
	
	public NhanceApplicationMessage(String key, Object... parameters){
		
		this.key = key;
		this.parameters = parameters;
	}
	
	public NhanceApplicationMessage(String key){
		this(key, (Object[])null);
	}
	
	public String getKey() {
		return key;
	}
	
	public void setKey(String key) {
		this.key = key;
	}
	
	public Object[] getParameters() {
		return parameters;
	}
	
	public void setParameters(Object[] parameters) {
		this.parameters = parameters;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ApplicationMessage [\n");
		if (key != null)
			builder.append("key=").append(key).append(",\n ");
		builder.append("\n]");
		return builder.toString();
	}
	
}
