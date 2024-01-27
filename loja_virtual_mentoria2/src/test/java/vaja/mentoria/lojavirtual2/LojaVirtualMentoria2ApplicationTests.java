package vaja.mentoria.lojavirtual2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import junit.framework.TestCase;
import vaja.mentoria.lojavirtual2.controller.AcessoController;
import vaja.mentoria.lojavirtual2.model.Acesso;
import vaja.mentoria.lojavirtual2.repository.AcessoRepository;

@SpringBootTest
class LojaVirtualMentoria2ApplicationTests extends TestCase {
	
	private AcessoController AcessoController;

	private Object Acesso;

	@Autowired
	Acesso savedAcesso = AcessoRepository.save(Acesso);

	@Test
	public void testcadastraAcesso() {
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_ADMIN");
		assertEquals(true, acesso.getId()==null);
		
		/*Gravou no banco de dados*/
		Acesso savedAcesso = AcessoRepository.save(acesso);
		
		assertEquals(true, acesso.getId() > 0);
		
		/*Validar dados salvos da forma correta*/
		assertEquals("ROLE_ADMIN", acesso.getDescricao());
		
		/*Teste de Carregamento*/
		
		Acesso acesso2 = AcessoRepository.findById(acesso.getId()).get();
		
		assertEquals(acesso.getId(), acesso2.getId());
	}

}
