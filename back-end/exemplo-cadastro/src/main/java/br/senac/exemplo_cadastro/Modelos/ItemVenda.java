package br.senac.exemplo_cadastro.Modelos;

public class ItemVenda {
	private Roupa roupa = new Roupa();
	private int quantidadeVendida;
	private float precoVendido;
	private Pagamento pagamento = new Pagamento();
	
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
	public float getPrecoVendido() {
		return precoVendido;
	}
	public void setPrecoVendido(float precoVendido) {
		this.precoVendido = precoVendido;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	
}
