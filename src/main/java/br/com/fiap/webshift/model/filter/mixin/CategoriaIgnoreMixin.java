package br.com.fiap.webshift.model.filter.mixin;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.webshift.model.CategoriaModel;

public interface CategoriaIgnoreMixin {

	@JsonIgnore
	CategoriaModel getCategoria();
	
}
