package br.senac.exemplo_cadastro.Modelos;

import java.time.LocalDate;
import java.util.List;

public class Venda {
	private int id;
	private LocalDate dataVenda;
	private List<ItemVenda> itensVendidos;
	
	public List<ItemVenda> getItensVendidos() {
		return itensVendidos;
	}
	public void setItensVendidos(List<ItemVenda> itensVendidos) {
		this.itensVendidos = itensVendidos;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataVenda() {
		return dataVenda;
	}
	public void setDataVenda(LocalDate dataVenda) {
		this.dataVenda = dataVenda;
	}
	
}
