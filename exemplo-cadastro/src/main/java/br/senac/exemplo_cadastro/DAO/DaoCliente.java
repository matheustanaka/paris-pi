package br.senac.exemplo_cadastro.DAO;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.senac.exemplo_cadastro.BancoDeDados.DB;
import br.senac.exemplo_cadastro.Modelos.Cliente;

public class DaoCliente {
	
	public static void inserirCliente (Cliente cliente) throws Exception{
		
		String sql = "INSERT INTO cliente (nome, cpf, email, senha) VALUES (?, ?, ?, ?)";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getSenha());
			
			ps.execute();
			
		}
	}
	
	public static List<Cliente> listar() throws Exception {
		String sql = "SELECT * FROM cliente";
		
		List<Cliente> resultados = new ArrayList<Cliente>();
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente ();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				
				resultados.add(cliente);
				
			}
		}
		
		return resultados;
	}
	
	public static void excluir(int id) throws Exception{
			
			String sql = "DELETE FROM cliente WHERE id = ?";
			
			try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
				ps.setInt(1, id);
				ps.execute();
				
			}
		}
	
	public static void atualizar(Cliente cliente) throws Exception{
		
		String sql = "UPDATE cliente SET nome = ?, cpf = ?, email = ?, senha = ? WHERE id = ?";
		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getCpf());
			ps.setString(3, cliente.getEmail());
			ps.setString(4, cliente.getSenha());
			ps.setInt(5, cliente.getId());
			
			ps.execute();
		}
	}
	
	public static List<Cliente> pesquisar(String nome) throws Exception{
		
		String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
		
		List<Cliente> resultados = new ArrayList<Cliente>();

		
		try (PreparedStatement ps = DB.connect().prepareStatement(sql)) {
			ps.setString(1, "%" + nome + "%");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Cliente cliente = new Cliente ();
				
				cliente.setId(rs.getInt("id"));
				cliente.setNome(rs.getString("nome"));
				cliente.setCpf(rs.getString("cpf"));
				cliente.setEmail(rs.getString("email"));
				cliente.setSenha(rs.getString("senha"));
				
				resultados.add(cliente);
				
			}
		}
		return resultados;
	}
}
