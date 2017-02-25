package net.bloodbanking.enums;

import java.util.HashMap;
import java.util.Map;

public class ReferenceTypeEnum {

	private static Map<Integer, String> referenceTypeMap = new HashMap<Integer, String>();
	
	public static final ReferenceTypeEnum USER = new ReferenceTypeEnum( 1 , "User" );
	
	public static final ReferenceTypeEnum ENQUIRY = new ReferenceTypeEnum( 2 , "Enquiry" );
	
	private Integer code;
	
	private String text;
	
	public static Map<Integer, String> getReferenceTypeMap() {
		return referenceTypeMap;
	}
	
	public ReferenceTypeEnum( Integer code, String text ) {
		this.code = code;
		this.text = text;
		String exisitngValue = referenceTypeMap.put( code, text );
		if( exisitngValue != null ) {
			throw new IllegalArgumentException("The code " + code + " already exists in ReferenceTypeEEnum");
		}
	}

	public Integer getCode() {
		return code;
	}

	public String getText() {
		return text;
	}

}
