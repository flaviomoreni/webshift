package br.com.fiap.webshift.model.filter.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.webshift.model.ProdutoModel;

public interface ProdutosIgnoreMixin {

	
	@JsonIgnore
	List<ProdutoModel> getProdutos();
	
}
