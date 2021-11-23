package br.senac.exemplo_cadastro.Modelos;

import java.time.LocalDate;
import java.util.List;

public class Venda {
	private Integer id;
	private Integer numero_venda;
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
	public Integer getNumero_venda() {
		return numero_venda;
	}
	public void setNumero_venda(Integer numero_venda) {
		this.numero_venda = numero_venda;
	}
	
}
