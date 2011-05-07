package br.com.amigooculto.business;

import java.util.ArrayList;
import java.util.List;

import br.com.amigooculto.annotations.RequiredField;
import br.com.amigooculto.enums.TypeField;

public class Amigo {
		
	@RequiredField(DisplayValue = "Nome")
	private String nome = null;
	
	@RequiredField(DisplayValue = "Telefone")
	private String telefone = null;
	
	@RequiredField(DisplayValue = "E-Mail")
	private String email = null;
	private String twitter = null;
	private String facebook = null;
	private String orkut = null;
	private List<Presentes> presentes = null;
	
	public Amigo(){
		setPresentes(new ArrayList<Presentes>());
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getTelefone() {
		return this.telefone;
	}
	
	public void setEMail(String email) {
		this.email = email;
	}
	
	public String getEMail() {
		return this.email;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setOrkut(String orkut) {
		this.orkut = orkut;
	}

	public String getOrkut() {
		return orkut;
	}

	public void setPresentes(List<Presentes> presentes) {
		this.presentes = presentes;
	}

	public List<Presentes> getPresentes() {
		return presentes;
	}
}
