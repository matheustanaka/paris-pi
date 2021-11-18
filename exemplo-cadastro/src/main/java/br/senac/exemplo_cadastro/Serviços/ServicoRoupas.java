package br.senac.exemplo_cadastro.Serviços;

import jakarta.ws.rs.Path;

import java.util.List;

import br.senac.exemplo_cadastro.DAO.DaoCliente;
import br.senac.exemplo_cadastro.DAO.DaoRoupas;
import br.senac.exemplo_cadastro.Modelos.Cliente;
import br.senac.exemplo_cadastro.Modelos.Roupas;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("roupas")
public class ServicoRoupas {
	//Inserindo Roupas
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void inserirRoupas(Roupas roupa, @QueryParam("id") int id) {
		try {
			DaoRoupas.inserirRoupas(roupa, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Deletando Roupas
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluirRoupas(@QueryParam("id") int id) {
		try {
			DaoRoupas.excluirRoupas(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//Recebendo Roupas
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Roupas> listarRoupas(){
		try {
			return DaoRoupas.listarRoupas();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}
