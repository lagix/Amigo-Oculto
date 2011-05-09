package br.com.amigooculto.validations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import br.com.amigooculto.annotations.RequiredField;

public class Validate {
	
	
	public Validate(Object obj) throws Exception
	{
		ValidateFields(obj);
		
	//	ValidateMethods(obj);
	}
	
	private void ValidateFields(Object obj) throws Exception
	{
		Class c = obj.getClass();
		
		for (Field f : c.getDeclaredFields())
		{
			for(Annotation a: f.getAnnotations())
			{
				
				if (a instanceof RequiredField)
				{
					f.setAccessible(true);
				
					RequiredField rf = (RequiredField) a;
					
					RequiredFieldValidate.Validate(f.get(obj), rf.DisplayValue());
					
					f.setAccessible(false);
				}
			}
		}
	}
	
	private void ValidateMethods(Object obj) throws Exception
	{
		Class c = obj.getClass();
		
		for (Method m: c.getMethods())
		{
			for(Annotation a: m.getAnnotations())
			{
				throw new Exception("Not implemented yet.");
			}
		}
	}

}
