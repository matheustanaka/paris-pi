package br.senac.exemplo_cadastro.Serviços;

import java.util.ArrayList;
import java.util.List;

import br.senac.exemplo_cadastro.DAO.DaoCliente;
import br.senac.exemplo_cadastro.DAO.DaoPagamento;
import br.senac.exemplo_cadastro.Modelos.Cliente;
import br.senac.exemplo_cadastro.Modelos.Pagamento;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("pagamento")
public class ServicoPagamento {
	
		private static List<Pagamento> lista = new ArrayList<Pagamento>();
		
		//Inserindo Pagamento
		@POST
		@Consumes(MediaType.APPLICATION_JSON)
		public void inserirPagamento(Pagamento pagamento) {
			try {
				DaoPagamento.inserirPagamento(pagamento);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//Recebendo Pagamentos
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public List<Pagamento> listarPagamento(){
			try {
				return DaoPagamento.listarPagamento();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		//Pesquisando pagamento pelo tipo de pagamento
		@GET
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.APPLICATION_JSON)
		@Path("pesquisar")
		public List<Pagamento> pesquisar (@QueryParam("tipoPagamento") String tipoPagamento){
			try {
				return DaoPagamento.pesquisarPagamento(tipoPagamento);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			return null;
		}
		
		//Atualizando os dados de Pagamento
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		public void atualizar(Pagamento pagamento) {
			try {
				DaoPagamento.atualizarPagamento(pagamento);
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

