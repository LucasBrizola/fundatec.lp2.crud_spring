package br.com.LojaLucas.serviceTest;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.LojaLucas.dto.RoupaInvernoDTO;
import br.com.LojaLucas.service.RoupaInvernoService;

@RunWith(value=SpringRunner.class)
@SpringBootTest
public class RoupaInvernoServiceTest {

	@Autowired
	private RoupaInvernoService roupaInvernoService;
	
	@Test
	public void deveSalvarUmaRoupaInverno() {
		RoupaInvernoDTO roupaInvernoParaSalvar = new RoupaInvernoDTO();
		roupaInvernoParaSalvar.setTipo(2);
		roupaInvernoParaSalvar.setTamanho("P");
		roupaInvernoParaSalvar.setModelo("blusao adidas");

		roupaInvernoService.save(roupaInvernoParaSalvar);
		RoupaInvernoDTO roupaInvernoSalva = roupaInvernoService.findByModelo("blusao adidas");

		Assert.assertEquals(2, roupaInvernoSalva.getTipo());
		Assert.assertEquals("P", roupaInvernoSalva.getTamanho());
		Assert.assertEquals("blusao adidas", roupaInvernoSalva.getModelo());
	}
	
}