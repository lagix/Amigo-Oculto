package br.com.amigooculto.validations;

public final class RequiredFieldValidate {

	public final static void Validate(Object obj,String displayName) 
	{
		String strObj = (String)obj;
		
		if (strObj.length() == 0) 
		{	
			throw new NullPointerException(displayName+" não informado.");
		}	
	}
	
}
