package br.senac.exemplo_cadastro.Modelos;

public class Roupas {
	
	private int roupaId;
	private String tipoRoupa;
	private String marca;
	private String tamanho;
	private int quantidade;
	
	
	
	public int getRoupaId() {
		return roupaId;
	}
	public void setRoupaId(int roupaId) {
		this.roupaId = roupaId;
	}
	public String getTipoRoupa() {
		return tipoRoupa;
	}
	public void setTipoRoupa(String tipoRoupa) {
		this.tipoRoupa = tipoRoupa;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

}
