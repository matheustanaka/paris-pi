package br.senac.exemplo_cadastro.Modelos;

public class ItemVenda {
	private Roupa roupa;
	private int quantidadeVendida;
	private float preco;
	
	public Roupa getRoupa() {
		return roupa;
	}
	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}
	public int getQuantidadeVendida() {
		return quantidadeVendida;
	}
	public void setQuantidadeVendida(int quantidadeVendida) {
		this.quantidadeVendida = quantidadeVendida;
	}
	public float getPreco() {
		return preco;
	}
	public void setPreco(float preco) {
		this.preco = preco;
	}
	
}
