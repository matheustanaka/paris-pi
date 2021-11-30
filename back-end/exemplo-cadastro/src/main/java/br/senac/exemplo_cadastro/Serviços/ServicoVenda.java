package br.senac.exemplo_cadastro.Serviços;

import java.time.LocalDate;
import java.util.List;

import br.senac.exemplo_cadastro.DAO.DaoVenda;
import br.senac.exemplo_cadastro.Modelos.Venda;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("venda")
public class ServicoVenda {
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void fazerVenda(Venda venda) {
		try {
			DaoVenda.fazerVenda(venda);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Venda> gerarRelatorio(@QueryParam("dataInicial") String dataInicial,
			@QueryParam("dataFinal") String dataFinal) {
		try {
			return DaoVenda.gerarRelatorio(LocalDate.parse(dataInicial), LocalDate.parse(dataFinal));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
