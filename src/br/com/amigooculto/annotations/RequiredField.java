package br.com.amigooculto.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/***
 * <h1>Required Field</h1>
 * <br/>
 * <p>Annotation de validação de campo obrigatório</p>
 * <i>Retorna uma exceção caso o campo não esteja preenchido</i>
 * @author Bruno Lage
 *
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface RequiredField {
	String DisplayValue();
}
