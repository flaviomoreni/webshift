package br.com.fiap.webshift.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.fiap.webshift.model.LojaModel;
import br.com.fiap.webshift.model.MarcaModel;
import br.com.fiap.webshift.model.ProdutoModel;
import br.com.fiap.webshift.model.filter.mixin.ProdutoIgnoreRelacionamentoMixin;
import br.com.fiap.webshift.model.filter.mixin.ProdutosIgnoreMixin;
import br.com.fiap.webshift.repository.ProdutoRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	/*
	@GetMapping
	public ResponseEntity<List<ProdutoModel>> findAll(){
		List<ProdutoModel> lista = produtoRepository.findAll();
		return ResponseEntity.ok(lista);
	}
	*/
	
	@GetMapping
	public ResponseEntity<JsonNode> findAll() throws JsonMappingException, JsonProcessingException{
		List<ProdutoModel> lista = produtoRepository.findAll();
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(LojaModel.class, ProdutosIgnoreMixin.class); 
		mapper.addMixIn(MarcaModel.class, ProdutosIgnoreMixin.class);
		
		return ResponseEntity.ok( mapper.readTree( mapper.writeValueAsString(lista) ) );
	}
	
	
	@GetMapping("/novos")
	public ResponseEntity<JsonNode> findAllByDataDesc() throws JsonMappingException, JsonProcessingException{
		List<ProdutoModel> lista = produtoRepository.findAll( Sort.by( Sort.Direction.DESC  , "dataLancamento" ) );
		
		return responseProdutos(lista);
	}
	
	
	@GetMapping("/precoAsc")
	public ResponseEntity<JsonNode> findAllPrecoAsc() throws JsonMappingException, JsonProcessingException{
		List<ProdutoModel> lista = produtoRepository.findAll( Sort.by( Sort.Direction.ASC  , "preco" ) );
		
		return responseProdutos(lista);
	}
	
	@GetMapping("/precoDesc")
	public ResponseEntity<JsonNode> findAllPrecoDesc() throws JsonMappingException, JsonProcessingException{
		List<ProdutoModel> lista = produtoRepository.findAll( Sort.by( Sort.Direction.DESC  , "preco" ) );
		
		return responseProdutos(lista);
	}
	
	
	@GetMapping("/nome")
	public ResponseEntity<JsonNode> findByNome(@RequestParam("nome") String nome) throws JsonMappingException, JsonProcessingException{
		List<ProdutoModel> lista = produtoRepository.findByNomeContains(nome);
		
		return responseProdutos(lista);
	}


	private ResponseEntity<JsonNode> responseProdutos(List<ProdutoModel> lista)
			throws JsonProcessingException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.addMixIn(ProdutoModel.class, ProdutoIgnoreRelacionamentoMixin.class); 
		
		return ResponseEntity.ok( mapper.readTree( mapper.writeValueAsString(lista) ) );
	}
	
	@GetMapping("/marcas")
	public ResponseEntity<JsonNode> findByMarcas(@RequestParam("idMarca") int[] idMarca) throws JsonMappingException, JsonProcessingException{
		
		Set<MarcaModel> marcas = new HashSet<>();
		for (int item: idMarca) {
			marcas.add( new MarcaModel(item, "") );
		}
		
		List<ProdutoModel> lista = produtoRepository.findByMarcaIn(marcas);
		
		return responseProdutos(lista);
	}
	
	
	
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<JsonNode> findById(@PathVariable("id") int id) throws JsonMappingException, JsonProcessingException {
		if ( produtoRepository.existsById(id) ) {
			ProdutoModel model = produtoRepository.findById(id).get();
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.addMixIn(LojaModel.class, ProdutosIgnoreMixin.class); 
			mapper.addMixIn(MarcaModel.class, ProdutosIgnoreMixin.class);
			
			return ResponseEntity.ok( mapper.readTree( mapper.writeValueAsString(model) ) );
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
}
