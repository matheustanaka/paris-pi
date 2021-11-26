package br.senac.exemplo_cadastro.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import br.senac.exemplo_cadastro.BancoDeDados.DB;
import br.senac.exemplo_cadastro.Modelos.ItemVenda;
import br.senac.exemplo_cadastro.Modelos.Venda;

public class DaoVenda {
   public static void fazerVenda(Venda venda) throws Exception {
	   String sql = "INSERT INTO venda (numero_venda, data_venda, id_cliente, id_pagamento) VALUES (?, ?, ?, ?)";
   
   
	   try (PreparedStatement ps = DB.connect().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
		   	
		   ps.setInt(1, venda.getNumeroVenda());
		   ps.setDate(2, Date.valueOf(venda.getDataVenda()));
		   ps.setInt(3, venda.getCliente().getId());
		   ps.setInt(4, venda.getPagamento().getId_pagamento());
		   
		   ps.execute();
		   
		   ResultSet rsKeys = ps.getGeneratedKeys();
		   if(rsKeys.next()) {
			   int idGerado = rsKeys.getInt(1);
			   
			   inserirRoupasVendidas(idGerado, venda.getItensVendidos());
			   atualizarEstoque(venda.getItensVendidos());
		   }
	   }
   }
   
   private static void inserirRoupasVendidas(int idVenda, List<ItemVenda> itensVenda) throws Exception {
	   String sql = "INSERT INTO venda_roupa (id_venda, id_roupa, quantidade_vendida, preco_vendido) VALUES (?, ?, ?, ?)";
	   
	   for (int i = 0; i < itensVenda.size(); i++) {
		   ItemVenda itemVendido = itensVenda.get(i);
		   
		   try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			   
			   ps.setInt(1, idVenda);
			   ps.setInt(2, itemVendido.getRoupa().getId());
			   ps.setInt(3, itemVendido.getQuantidadeVendida());
			   ps.setFloat(4, itemVendido.getPrecoVendido());
			   
			   ps.execute();
		   }
	   }
   }
   
   private static void atualizarEstoque(List<ItemVenda> itensVendidos) throws Exception {
	   String sql = "UPDATE roupa SET estoque = estoque - ? WHERE id_roupa = ?";
	   
	   for(int i = 0; i<itensVendidos.size(); i++) {
		   ItemVenda itemVendido = itensVendidos.get(i);
		   
		   try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			   ps.setInt(1, itemVendido.getQuantidadeVendida());
			   ps.setInt(2, itemVendido.getRoupa().getId());
			   
			   ps.execute();
		   }
	   }
   }
}
