package br.senac.exemplo_cadastro;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("cliente")
public class ServicoCliente {

	private static List<Cliente> lista = new ArrayList<Cliente>();
	
	//Enviando Clientes
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Cliente cliente) {
		lista.add(cliente);
	}
	
	//Recebendo Clientes
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listar(){
		return lista;
	}
}
