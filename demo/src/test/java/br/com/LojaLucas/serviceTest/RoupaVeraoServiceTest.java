package br.com.LojaLucas.serviceTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.LojaLucas.dto.RoupaVeraoDTO;
import br.com.LojaLucas.service.RoupaVeraoService;

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class RoupaVeraoServiceTest {

	@Autowired
	private RoupaVeraoService roupaVeraoService;
	
	
	@Test
	public void deveSalvarUmaRoupaVerao() {
		RoupaVeraoDTO roupaVeraoParaSalvar = new RoupaVeraoDTO();
		roupaVeraoParaSalvar.setTipo(1);
		roupaVeraoParaSalvar.setTamanho("M");
		roupaVeraoParaSalvar.setModelo("camiseta adidas");

		roupaVeraoService.save(roupaVeraoParaSalvar);
		RoupaVeraoDTO roupaVeraoSalva = roupaVeraoService.findByModelo("camiseta adidas");

		Assert.assertEquals(1, roupaVeraoSalva.getTipo());
		Assert.assertEquals("M", roupaVeraoSalva.getTamanho());
		Assert.assertEquals("camiseta adidas", roupaVeraoSalva.getModelo());
		
	}
		
}
