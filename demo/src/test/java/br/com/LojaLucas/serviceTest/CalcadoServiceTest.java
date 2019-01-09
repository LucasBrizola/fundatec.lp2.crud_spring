package br.com.LojaLucas.serviceTest;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.LojaLucas.dto.CalcadoDTO;
import br.com.LojaLucas.service.CalcadoService;



@RunWith(value=SpringRunner.class)
@SpringBootTest
public class CalcadoServiceTest {

	@Autowired
	private CalcadoService calcadoService;
	
	@Test
	public void deveSalvarUmCalcado() {
		CalcadoDTO calcadoParaSalvar = new CalcadoDTO();
		calcadoParaSalvar.setTipo(3);
		calcadoParaSalvar.setModelo("tenis nike");
		calcadoParaSalvar.setTamanho(38);
		
		calcadoService.save(calcadoParaSalvar);
		CalcadoDTO calcadoSalvo = calcadoService.findByModelo("tenis nike");
		
		Assert.assertEquals(3, calcadoSalvo.getTipo());
		Assert.assertEquals("tenis nike", calcadoSalvo.getModelo());
		Assert.assertEquals(38, calcadoSalvo.getTamanho());
		
	}

}