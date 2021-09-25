package br.com.fiap.webshift.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.fiap.webshift.model.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Integer>  {

	
	@Override
	@Query(value="SELECT p FROM ProdutoModel p LEFT JOIN FETCH p.marca LEFT JOIN FETCH p.categoria")
	public List<ProdutoModel> findAll();
	
}
