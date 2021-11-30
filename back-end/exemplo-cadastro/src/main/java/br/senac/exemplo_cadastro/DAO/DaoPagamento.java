package br.senac.exemplo_cadastro.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senac.exemplo_cadastro.BancoDeDados.DB;
import br.senac.exemplo_cadastro.Modelos.Pagamento;

public class DaoPagamento {
	public static void inserirPagamento (Pagamento pagamento) throws Exception{
		
		String sql = "INSERT INTO pagamento (tipoPagamento) VALUES (?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, pagamento.getTipoPagamento());
			
			ps.execute();
			
		}
	}
	
	public static List<Pagamento> listarPagamento() throws Exception {
		String sql = "SELECT * FROM pagamento";
		
		List<Pagamento> resultados = new ArrayList<Pagamento>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Pagamento pagamento = new Pagamento ();
				
				pagamento.setId_pagamento(rs.getInt("id_pagamento"));
				pagamento.setTipoPagamento(rs.getString("tipoPagamento"));
				
				resultados.add(pagamento);
				
			}
		}
		
		return resultados;
	}
	
	public static void excluirPagamento(int id) throws Exception{
			
			String sql = "DELETE FROM pagamento WHERE id_pagamento = ?";
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
				ps.setInt(1, id);
				ps.execute();
				
			}
		}
	
	public static void atualizarPagamento(Pagamento pagamento) throws Exception{
		
		String sql = "UPDATE pagamento SET tipoPagamento = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, pagamento.getTipoPagamento());
			
			ps.execute();
		}
	}
	
	public static List<Pagamento> pesquisarPagamento(String tipoPagamento) throws Exception{
		
		String sql = "SELECT * FROM pagamento WHERE tipoPagamento LIKE ?";
		
		List<Pagamento> resultados = new ArrayList<Pagamento>();

		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, "%" + tipoPagamento + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Pagamento pagamento_list = new Pagamento ();
				
				pagamento_list.setId_pagamento(rs.getInt("id_pagamento"));
				pagamento_list.setTipoPagamento(rs.getString("tipoPagamento"));

				
				resultados.add(pagamento_list);
				
			}
		}
		return resultados;
	}
}
