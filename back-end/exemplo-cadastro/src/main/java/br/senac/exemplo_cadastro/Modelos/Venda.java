package br.senac.exemplo_cadastro.Modelos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Venda {
	private Integer id_venda;
	private Integer numeroVenda;
	private LocalDate dataVenda;
	private List<ItemVenda> itensVendidos = new ArrayList<ItemVenda>();
	private Cliente cliente = new Cliente ();
	private Pagamento pagamento = new Pagamento();
	private Roupa roupa = new Roupa();
	
	public List<ItemVenda> getItensVendidos() {
		return itensVendidos;
	}
	public void setItensVendidos(List<ItemVenda> itensVendidos) {
		this.itensVendidos = itensVendidos;
	}

	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	public Integer getNumeroVenda() {
		return numeroVenda;
	}
	public void setNumeroVenda(Integer numeroVenda) {
		this.numeroVenda = numeroVenda;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public Pagamento getPagamento() {
		return pagamento;
	}
	public void setPagamento(Pagamento pagamento) {
		this.pagamento = pagamento;
	}
	public Integer getId_venda() {
		return id_venda;
	}
	public void setId_venda(Integer id_venda) {
		this.id_venda = id_venda;
	}
	public Roupa getRoupa() {
		return roupa;
	}
	public void setRoupa(Roupa roupa) {
		this.roupa = roupa;
	}
	
}
