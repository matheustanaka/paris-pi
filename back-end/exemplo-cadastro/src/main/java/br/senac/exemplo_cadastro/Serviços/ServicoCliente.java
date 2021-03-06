package br.senac.exemplo_cadastro.Serviços;

import java.util.List;

import br.senac.exemplo_cadastro.DAO.DaoCliente;
import br.senac.exemplo_cadastro.Modelos.Cliente;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("cliente")
public class ServicoCliente {
	
	//Enviando Clientes
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Cliente cliente) {
		try {
			DaoCliente.inserirCliente(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Recebendo Clientes
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listar(){
		try {
			return DaoCliente.listar();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Pesquisando clientes pelo Nome
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("pesquisar")
	public List<Cliente> pesquisar (@QueryParam("nome") String nome){
		try {
			return DaoCliente.pesquisar(nome);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	//Atualizando os dados do cliente
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Cliente cliente) {
		try {
			DaoCliente.atualizar(cliente);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//Deletando clientes pelo ID
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int id) {
		try {
			DaoCliente.excluir(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
