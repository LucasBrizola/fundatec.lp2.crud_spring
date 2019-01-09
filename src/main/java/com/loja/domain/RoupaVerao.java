package com.loja.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@DiscriminatorValue("RoupaVerao")
@Entity
public class RoupaVerao extends Roupa{

	public RoupaVerao(@NotNull @NotEmpty int tipo, @NotNull @NotEmpty String tamanho,
			@NotNull @NotEmpty String modelo) {
		super(tipo, tamanho, modelo);
	}

}
