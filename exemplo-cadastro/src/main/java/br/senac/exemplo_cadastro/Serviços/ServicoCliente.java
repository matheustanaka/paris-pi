package br.senac.exemplo_cadastro.Serviços;

import java.util.ArrayList;
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

	private static List<Cliente> lista = new ArrayList<Cliente>();
	
	//Enviando Clientes
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserir(Cliente cliente) {
		try {
			DaoCliente.inserirCliente(cliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
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
			// TODO Auto-generated catch block
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
		List<Cliente> resultados = new ArrayList<Cliente>();
		
		for (int i = 0; i < lista.size(); i++) {
			Cliente cliente = lista.get(i);
			//verificando se possui o mesmo nome que o parametro definido
			if(cliente.getNome().equals(nome)) {
				resultados.add(cliente);
			}
		}
		return resultados;
	}
	
	//Atualizando os dados do cliente
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void atualizar(Cliente cliente) {
		for(int i = 0; i < lista.size(); i++) {
			Cliente cliBusca = lista.get(i);
			
			//Se o ID da busca for igual ao ID do Cliente
			//Ele retorna o cliente baseado no ID e pede para atualizar os dados (nome e cpf).
			if(cliBusca.getId() == cliente.getId()) {
				cliBusca.setNome(cliente.getNome());
				cliBusca.setCpf(cliente.getCpf());
				cliBusca.setEmail(cliente.getEmail());
				cliBusca.setSenha(cliente.getSenha());
				break;
			}
		}
	}
	
	//Deletando clientes pelo ID
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(@QueryParam("id") int id) {
		int pos = -1;
		int contador = 0;
		
		boolean encontrado = false;
		while(contador < lista.size() && !encontrado) {
			Cliente cliente = lista.get(contador);
			if(cliente.getId() == id) {
				pos = contador;
				encontrado = true;
			}
			contador++;
		}
		
		if(pos >= 0) {
			lista.remove(pos);
		}
	}
	
	
}
