package model.entities;

public class Enquete {
	private String titulo;
	private String descricao;
	private String[] opcoes;
	
	public Enquete(String titulo, String descricao, String[] opcoes) {
		super();
		this.titulo = titulo;
		this.descricao = descricao;
		this.opcoes = opcoes;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String[] getOpcoes() {
		return opcoes;
	}
	
	public void setOpcoes(String[] opcoes) {
		this.opcoes = opcoes;
	}
	
	
}
