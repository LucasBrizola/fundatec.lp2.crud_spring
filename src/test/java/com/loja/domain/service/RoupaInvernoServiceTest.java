package com.loja.domain.service;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.loja.dto.RoupaInvernoDTO;
import com.loja.service.RoupaInvernoService;

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
		RoupaInvernoDTO roupaInvernoSalva = roupaInvernoService.findByModelo(roupaInvernoParaSalvar.getModelo());

		Assert.assertEquals(2, roupaInvernoSalva.getTipo());
		Assert.assertEquals("P", roupaInvernoSalva.getTamanho());
		Assert.assertEquals("blusao adidas", roupaInvernoSalva.getModelo());
	}
	
}