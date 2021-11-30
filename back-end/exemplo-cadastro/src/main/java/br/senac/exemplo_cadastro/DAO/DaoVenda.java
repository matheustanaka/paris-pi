package br.senac.exemplo_cadastro.DAO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.senac.exemplo_cadastro.BancoDeDados.DB;
import br.senac.exemplo_cadastro.Modelos.Cliente;
import br.senac.exemplo_cadastro.Modelos.ItemVenda;
import br.senac.exemplo_cadastro.Modelos.Roupa;
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
   
   public static List<Venda> gerarRelatorio(LocalDate dataInicial, LocalDate dataFinal) throws Exception{
	   String sql = "SELECT v.numero_venda, v.data_venda, c.nome nome_cliente, r.Tipo, r.Marca, r.Preco, vr.preco_vendido, vr.quantidade_vendida FROM venda v "
	   		+ "INNER JOIN cliente c ON v.id_cliente = c.id_cliente "
	   		+ "INNER JOIN venda_roupa vr ON v.id_venda = vr.id_venda "
	   		+ "INNER JOIN roupa r ON vr.id_roupa = r.id_roupa "
	   		+ "WHERE v.data_venda >= ? AND v.data_venda <= ?";
	   
	   List<Venda> resultados = new ArrayList<Venda>();
	   
	   try(PreparedStatement ps = DB.connect().prepareStatement(sql)) {
		   ps.setDate(1, Date.valueOf(dataInicial));
		   ps.setDate(2, Date.valueOf(dataFinal));
		   
		   ResultSet rs = ps.executeQuery();
		   
		   Venda venda = null;
		   
		   while(rs.next()) {
			   Integer numeroVenda = rs.getInt("numero_venda");
			   if(venda == null || venda.getNumeroVenda() != numeroVenda) {
				   venda = new Venda();
				   
				   venda.setNumeroVenda(numeroVenda);
				   venda.setDataVenda(rs.getDate("data_venda").toLocalDate());
				   
				   Cliente cliente = new Cliente();
				   cliente.setNome(rs.getString("nome_cliente"));
				   
				   venda.setCliente(cliente);
				   resultados.add(venda);
			   }		   
			   
			   Roupa roupa = new Roupa();
			   roupa.setTipoRoupa(rs.getString("Tipo"));
			   roupa.setMarca(rs.getString("Marca"));
			   roupa.setPreco(rs.getFloat("Preco"));
			   
			   ItemVenda itemVenda = new ItemVenda();
			   itemVenda.setPrecoVendido(rs.getFloat("preco_vendido"));
			   itemVenda.setQuantidadeVendida(rs.getInt("quantidade_vendida"));
			   
			   itemVenda.setRoupa(roupa);
			   
			   venda.getItensVendidos().add(itemVenda);
			   
	   }
   }
	   return resultados;
}
}
