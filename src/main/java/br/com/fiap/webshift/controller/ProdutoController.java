package br.com.fiap.webshift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.webshift.model.CategoriaModel;
import br.com.fiap.webshift.model.ProdutoModel;
import br.com.fiap.webshift.model.UsuarioModel;
import br.com.fiap.webshift.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAll(){
		List<ProdutoModel> lista = produtoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> findById(@PathVariable("id") int id){
		if ( produtoRepository.existsById(id) ) {
			ProdutoModel model = produtoRepository.findById(id).get();
			
			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
