package br.senac.exemplo_cadastro;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
	
	public static Connection connect() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		return DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/banco", 
				"root", 
				"root123");
	}
	
	public static void main(String[]args) throws Exception {
		connect();
		System.out.println("CONECTADO");
	}
	
}
