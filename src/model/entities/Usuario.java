package model.entities;

import java.util.List;

public class Usuario {
	private String email;
	private String usuario;
	private String senha;
	private List<Enquete> enquetesCriadas;
	private List<Enquete> enquetesParticipadas;
	
	public Usuario(String email, String usuario, String senha) {
		super();
		this.email = email;
		this.usuario = usuario;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Enquete> getEnquetesCriadas() {
		return enquetesCriadas;
	}

	public List<Enquete> getEnqueteParticipada() {
		return enquetesParticipadas;
	}

	public void adicionarEnqueteCriada(Enquete enquete) throws Exception {
		if(this.enquetesCriadas.size() >= 5) {
			throw new Exception("Não é possível adicionar mais enquetes, quantidade máxima = 5");
		}else {
			this.enquetesCriadas.add(enquete);
		}
	}
	
	public void adicionarEnqueteParticipada(Enquete enquete) throws Exception {
		if(this.enquetesParticipadas.size() >= 5) {
			throw new Exception("Não é possível adicionar mais enquetes, quantidade máxima = 5");
		}else {
			this.enquetesParticipadas.add(enquete);
		}
	}
	
	public void removerEnqueteCriada(Enquete enquete) throws Exception {
		if(this.enquetesCriadas.size() == 0) {
			throw new Exception("O usuário não possui nenhuma enquete.");
		}else {
			this.enquetesCriadas.remove(enquete);
		}
	}
	
	public void removerEnqueteParticipada(Enquete enquete) throws Exception {
		if(this.enquetesParticipadas.size() == 0) {
			throw new Exception("O usuário não possui nenhuma enquete.");
		}else {
			this.enquetesParticipadas.remove(enquete);
		}
	}
}
