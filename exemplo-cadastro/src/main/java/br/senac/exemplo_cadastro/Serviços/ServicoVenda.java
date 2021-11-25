package br.senac.exemplo_cadastro.Serviços;

import br.senac.exemplo_cadastro.DAO.DaoVenda;
import br.senac.exemplo_cadastro.Modelos.Venda;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
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
}
