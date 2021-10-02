package br.com.fiap.webshift.model.filter.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.fiap.webshift.model.CategoriaModel;
import br.com.fiap.webshift.model.LojaModel;
import br.com.fiap.webshift.model.MarcaModel;


public interface ProdutoIgnoreRelacionamentoMixin {

	@JsonIgnore
	List<LojaModel> getLojas();
	
	@JsonIgnore
	List<MarcaModel> getMarca();

	@JsonIgnore
	List<CategoriaModel> getCategoria();
	
}
