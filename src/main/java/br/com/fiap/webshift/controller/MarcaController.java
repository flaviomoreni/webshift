package br.com.fiap.webshift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.webshift.model.MarcaModel;
import br.com.fiap.webshift.repository.MarcaRepository;

@RestController
@RequestMapping("/marca")
public class MarcaController {

	@Autowired
	private MarcaRepository marcaRepository;
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<MarcaModel> findById(@PathVariable("id") int id){
		if ( marcaRepository.existsById(id) ) {
			MarcaModel model = marcaRepository.findById(id).get();
			
			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
