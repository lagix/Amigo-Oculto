package br.com.amigooculto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Sorteio {
	private List<Amigo> amigos = null;
	private List<Amigo> amigosOrigem = null;
	private Boolean repeat = false; 
	private boolean deParaAmigoSorteado;
	private int inc = 0;
	
	public Sorteio() {
		novaLista();
	}
	
	public void addAmigo(Amigo amigo) {
		amigos.add(amigo);
	}
	
	public void repetirAmigo(Boolean repetir) {
		this.repeat=repetir;
	}
	
	public void sortearPorSMS() {
		this.deParaAmigoSorteado = true;
		copyLista();
		repetirAmigo(true);
	}
	
	public void sortearPorEMail() {
		this.deParaAmigoSorteado = true;
		copyLista();
		repetirAmigo(true);
	}
	
	public void sortearNaTela() {
		this.deParaAmigoSorteado = false;
	}
	
	public Amigo sortear() {
		Amigo amigoSorteado = null;
	
		if (isSortAvaliable()) {
			Random sorteio = new Random();
			int posicaoAmigo = sorteio.nextInt(amigos.size());
		
			amigoSorteado = amigos.get(posicaoAmigo); 
			
			if (!repeat) {
				amigos.remove(posicaoAmigo);
			}
			
			return amigoSorteado;
		}
		else {
			return null;
		}
	}
	
	
	public List<Amigo> sortearSMSEMail() {
		List<Amigo> amigosSorteado = new ArrayList<Amigo>();
		
		if (isSortAvaliable()) {
			Amigo amigoOrigem = amigosOrigem.get(inc);
			
			//Adicionando o amigo origem na lista
			amigosSorteado.add(amigoOrigem);
		
			Amigo amigoSorteado = sortear(); 
			while(amigoOrigem.getNome()==amigoSorteado.getNome()) {
				amigoSorteado = sortear();
			}
			
			//Adicionando o amigo sorteado
			amigosSorteado.add(amigoSorteado);
			
			inc++;
			
			removerAmigoSoretado(amigoSorteado);
		}
		return amigosSorteado;
	}
	
	private void removerAmigoSoretado(Amigo amigo) {
		amigos.remove(amigo);
	}
	
	public boolean isSortAvaliable()
	{
		if (amigos.size()>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void clearList() {
		amigos = null;
		novaLista();
	}
	
	public void novaLista() {
		amigos = new ArrayList<Amigo>();
	}
	
	public Amigo getAmigo(int posicao) {
		return amigosOrigem.get(posicao);
	}
	
	public int getTotalAmigos(){
		return amigosOrigem.size();
	}
	
	private void copyLista() {
		int pos = 0;
		
		this.amigosOrigem = new ArrayList<Amigo>();
		
		while (this.amigosOrigem.size()!=this.amigos.size()) {
			this.amigosOrigem.add(this.amigos.get(pos));
			pos++;
		}
	}
}
