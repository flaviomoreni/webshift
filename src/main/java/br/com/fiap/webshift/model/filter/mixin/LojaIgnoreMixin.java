package br.com.fiap.webshift.model.filter.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.webshift.model.LojaModel;

public interface LojaIgnoreMixin {

	@JsonIgnore
	List<LojaModel> getLojas();
	
}
