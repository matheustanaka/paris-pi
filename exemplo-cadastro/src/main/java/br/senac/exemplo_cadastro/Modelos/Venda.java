package br.senac.exemplo_cadastro.Modelos;

import java.time.LocalDate;
import java.util.List;

public class Venda {
	private Integer id;
	private Integer numeroVenda;
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
	public Integer getNumeroVenda() {
		return numeroVenda;
	}
	public void setNumeroVenda(Integer numeroVenda) {
		this.numeroVenda = numeroVenda;
	}
	
}
