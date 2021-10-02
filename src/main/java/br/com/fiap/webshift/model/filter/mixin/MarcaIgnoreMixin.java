package br.com.fiap.webshift.model.filter.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.webshift.model.MarcaModel;

public interface MarcaIgnoreMixin {

	@JsonIgnore
	MarcaModel getMarca();
	
}
