package br.com.fiap.webshift.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.fiap.webshift.model.UsuarioModel;
import br.com.fiap.webshift.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@CrossOrigin
	@GetMapping
	public ResponseEntity<List<UsuarioModel>> findAll() {
		List<UsuarioModel> lista = usuarioRepository.findAll(); 
		return ResponseEntity.ok(lista);
	}
	
	@CrossOrigin
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioModel> findById(@PathVariable("id") int id){
		if ( usuarioRepository.existsById(id) ) {
			UsuarioModel model = usuarioRepository.findById(id).get();
			return ResponseEntity.ok(model);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{email}/{senha}")
	public ResponseEntity<UsuarioModel> findByLogin(
			@PathVariable("email")String email, 
			@PathVariable("senha")String senha) {
		
		UsuarioModel model = usuarioRepository.findByEmailAndSenha(email, senha);
		
		if ( model == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(model);
		}
		
	}
	
	
	@GetMapping("/idade/{idade}")
	public ResponseEntity<Long> getTotalByIdade(@PathVariable("idade") int idade){
		Long quantidade = usuarioRepository.getTotalByIdade(idade);
		return ResponseEntity.ok(quantidade);
	}
	
	
	@CrossOrigin
	@PostMapping
	public ResponseEntity save(@RequestBody UsuarioModel usuarioModel) {
		
		usuarioRepository.save( usuarioModel );
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest().path("/{id}")
				.buildAndExpand(usuarioModel.getId()).toUri();
		
		return ResponseEntity.created(location).build();
	}
	
	
	@CrossOrigin
	@PutMapping("/{id}")
	public ResponseEntity update(@PathVariable("id") int codigoUsuario, @RequestBody UsuarioModel usuarioModel) {
		
		if ( usuarioRepository.existsById(codigoUsuario)  ) {
			usuarioModel.setId(codigoUsuario);
			usuarioRepository.save( usuarioModel );
			
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@CrossOrigin
	@DeleteMapping("/{id}")
	public ResponseEntity delete(@PathVariable("id") int id) {
		usuarioRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	
	
}
