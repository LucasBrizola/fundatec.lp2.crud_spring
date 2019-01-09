package br.com.LojaLucas.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@DiscriminatorValue("RoupaInverno")
@Entity
public class RoupaInverno extends Roupa{

	 public RoupaInverno(@NotNull @NotEmpty int tipo, @NotNull @NotEmpty String tamanho,
			@NotNull @NotEmpty String modelo) {
		 
		super(tipo, tamanho, modelo);
	}
	 
}
