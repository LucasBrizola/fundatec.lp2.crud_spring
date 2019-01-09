package br.com.LojaLucas.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "calcado")
public class Calcado extends BaseDominio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int tipo;

	@NotNull
	@NotEmpty
	private String modelo;

	private int tamanho;

	public Calcado(int id, int tipo, String modelo, int tamanho) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.modelo = modelo;
		this.tamanho = tamanho;
	}

	public Calcado(int tipo, String modelo, int tamanho) {
		super();
		this.tipo = tipo;
		this.modelo = modelo;
		this.tamanho = tamanho;
	}

	public int getId() {
		return id;
	}

	public int getTipo() {
		return tipo;
	}

	public String getModelo() {
		return modelo;
	}

	public int getTamanho() {
		return tamanho;
	}

}
