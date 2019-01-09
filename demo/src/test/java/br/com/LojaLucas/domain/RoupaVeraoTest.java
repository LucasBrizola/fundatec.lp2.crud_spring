package br.com.LojaLucas.domain;


import org.junit.Assert;
import org.junit.Test;

import br.com.LojaLucas.domain.RoupaVerao;


public class RoupaVeraoTest {

	@Test
	public void deveCriarUmaRoupaVeraoValida() {
		RoupaVerao biquini = new RoupaVerao( 1, "M","biquini");
		
				
		Assert.assertEquals(1, biquini.getTipo());
		Assert.assertEquals("M", biquini.getTamanho());
		Assert.assertEquals("biquini", biquini.getModelo());

	}
}
