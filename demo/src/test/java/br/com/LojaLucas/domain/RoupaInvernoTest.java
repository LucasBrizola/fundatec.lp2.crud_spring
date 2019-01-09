package br.com.LojaLucas.domain;

import org.junit.Assert;
import org.junit.Test;

import br.com.LojaLucas.domain.RoupaInverno;


public class RoupaInvernoTest {

	@Test
	public void deveCriarUmaRoupaValida() {
		RoupaInverno sarwell = new RoupaInverno(2, "GG","Calca");
		
				
		Assert.assertEquals(2, sarwell.getTipo());
		Assert.assertEquals("GG", sarwell.getTamanho());
		Assert.assertEquals("Calca", sarwell.getModelo());

	}
}