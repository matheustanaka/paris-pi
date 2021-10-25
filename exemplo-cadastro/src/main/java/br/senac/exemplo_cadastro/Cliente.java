package br.senac.exemplo_cadastro;

public class Cliente {
	private int id;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	
	//Getters
	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public String getEmail() {
		return email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	//Setters
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
