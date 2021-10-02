package br.com.fiap.webshift.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.webshift.model.MarcaModel;
import br.com.fiap.webshift.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer>  {

	
	@Override
	@Query(value="SELECT p FROM ProdutoModel p LEFT JOIN FETCH p.marca LEFT JOIN FETCH p.categoria")
	public List<ProdutoModel> findAll();
	
	public List<ProdutoModel> findByNomeContains(String nome);
	
	public List<ProdutoModel> findByDescricaoContains(String texto);
	
	public List<ProdutoModel> findByMarcaIn(Set<MarcaModel> marcas);
	
	
}
