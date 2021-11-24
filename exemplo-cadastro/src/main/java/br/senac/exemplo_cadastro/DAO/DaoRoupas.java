package br.senac.exemplo_cadastro.DAO;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.senac.exemplo_cadastro.BancoDeDados.DB;
import br.senac.exemplo_cadastro.Modelos.Cliente;
import br.senac.exemplo_cadastro.Modelos.Roupa;

public class DaoRoupas {
	//Recebendo as roupas (GET)
		public static List<Roupa> listarRoupas() throws Exception {
			String sql = "SELECT * FROM roupas";
			
			List<Roupa> resultados = new ArrayList<Roupa>();
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					Roupa roupas = new Roupa ();
					
					roupas.setRoupaId(rs.getInt("ID"));
					roupas.setMarca(rs.getString("Marca"));
					roupas.setQuantidade(rs.getInt("Quantidade"));
					roupas.setTamanho(rs.getString("Tamanho"));
					roupas.setTipoRoupa(rs.getString("Tipo"));
					roupas.setTipoRoupa(rs.getString("Estoque"));
					roupas.setPreco(rs.getFloat("Preco"));
					
					resultados.add(roupas);
					
				}
			}
			
			return resultados;
		}
	
	//Inserindo Roupas (POST)
	public static void inserirRoupas(Roupa roupas) throws Exception {
		
		String sql = "INSERT INTO roupas (Tipo, Marca, Tamanho, Quantidade, estoque, Preco) VALUES (?, ?, ?, ?, ?, ?)" ;
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, roupas.getTipoRoupa());
			ps.setString(2, roupas.getMarca());
			ps.setString(3, roupas.getTamanho());
			ps.setInt(4, roupas.getQuantidade());
			ps.setInt(5, roupas.getEstoque());
			ps.setFloat(6, roupas.getPreco());
			
			ps.execute();
			
		}
	}
	//Atualizando os dados da roupa (UPDATE)
	public static void atualizarRoupas(Roupa roupas) throws Exception{
		
		String sql = "UPDATE roupas SET Tipo = ?, Marca = ?, Tamanho = ?, Quantidade = ?, Preco = ?, estoque = ?, WHERE ID = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, roupas.getTipoRoupa());
			ps.setString(2, roupas.getMarca());
			ps.setString(3, roupas.getTamanho());
			ps.setInt(4, roupas.getQuantidade());
			ps.setFloat(5, roupas.getPreco());
			ps.setInt(6, roupas.getEstoque());
			ps.setInt(7, roupas.getRoupaId());
			
			
			ps.execute();
		}
	}
	
	//Deletando as Roupas pelo ID (DELETE)
	public static void excluirRoupas(int id) throws Exception {
		
		String sql = "DELETE FROM roupas WHERE ID = ?" ;
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setInt(1, id);
			
			ps.execute();
			
		}
	}
	
	
}
