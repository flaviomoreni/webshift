package br.com.fiap.webshift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.webshift.model.LojaModel;
import br.com.fiap.webshift.repository.LojaRepository;

@Controller
@RequestMapping("/loja")
public class LojaController {

	
	@Autowired
	public LojaRepository lojaRepository;
	
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<LojaModel> findById(@PathVariable("id") int id) {
		if ( lojaRepository.existsById(id) ) {
			LojaModel model = lojaRepository.getById(id);
			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
