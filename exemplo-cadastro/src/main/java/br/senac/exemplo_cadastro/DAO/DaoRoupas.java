package br.senac.exemplo_cadastro.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.exemplo_cadastro.BancoDeDados.DB;
import br.senac.exemplo_cadastro.Modelos.Cliente;
import br.senac.exemplo_cadastro.Modelos.Roupas;

public class DaoRoupas {
	
	public static List<Roupas> listRoupasById(int id) throws Exception{

		String sql = "SELECT r.roupa_id, "
				+ "	   cli.id, "
				+ "	   r.tipo_roupa, "
				+ "	   r.marca, "
				+ "	   r.tamanho, "
				+ "	   r.quantidade "
				+ "FROM roupas r "
				+ "JOIN cliente cli ON r.id = cli.id "
				+ "WHERE cli.id = ?";
		
		List<Roupas> resultado = new ArrayList<Roupas>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Roupas roupas = new Roupas();
				
				roupas.setRoupaId(rs.getInt("roupa_id"));
				roupas.setMarca(rs.getString("marca"));
				roupas.setQuantidade(rs.getInt("quantidade"));
				roupas.setTamanho(rs.getString("tamanho"));
				roupas.setTipoRoupa(rs.getString("tipo_roupa"));
				
				resultado.add(roupas);
				
			}
			
			return resultado;
		}
		
	}
	
	public static void inserirRoupas(Roupas roupas, int id) throws Exception {
		
		String sql = "INSERT INTO roupas (tipo_roupa, marca, tamanho, quantidade, id) VALUES (?, ?, ?, ?, ?)" ;
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, roupas.getTipoRoupa());
			ps.setString(2, roupas.getMarca());
			ps.setString(3, roupas.getTamanho());
			ps.setInt(4, roupas.getQuantidade());
			ps.setInt(5, id);
			
			ps.execute();
			
		}
	}
	
	public static void excluirRoupas(int id) throws Exception {
		
		String sql = "DELETE FROM roupas WHERE roupa_id = ?" ;
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ps.execute();
			
		}
	}

}
