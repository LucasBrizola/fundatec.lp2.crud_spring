package com.loja.domain.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.loja.dto.RoupaVeraoDTO;
import com.loja.service.RoupaVeraoService;

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
		RoupaVeraoDTO roupaVeraoSalva = roupaVeraoService.findByModelo(roupaVeraoParaSalvar.getModelo());

		Assert.assertEquals(1, roupaVeraoSalva.getTipo());
		Assert.assertEquals("M", roupaVeraoSalva.getTamanho());
		Assert.assertEquals("camiseta adidas", roupaVeraoSalva.getModelo());
		
	}
		
}
