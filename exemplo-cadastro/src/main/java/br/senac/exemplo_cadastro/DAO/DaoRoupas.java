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
	//Recebendo as roupas (GET)
		public static List<Roupas> listarRoupas() throws Exception {
			String sql = "SELECT * FROM roupas";
			
			List<Roupas> resultados = new ArrayList<Roupas>();
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Roupas roupas = new Roupas ();
					
					roupas.setRoupaId(rs.getInt("roupa_id"));
					roupas.setMarca(rs.getString("marca"));
					roupas.setQuantidade(rs.getInt("quantidade"));
					roupas.setTamanho(rs.getString("tamanho"));
					roupas.setTipoRoupa(rs.getString("tipo_roupa"));
					
					resultados.add(roupas);
					
				}
			}
			
			return resultados;
		}
	
	//Inserindo Roupas (POST)
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
	//Deletando as Roupas pelo ID (DELETE)
	public static void excluirRoupas(int id) throws Exception {
		
		String sql = "DELETE FROM roupas WHERE roupa_id = ?" ;
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ps.execute();
			
		}
	}
	
	
}
