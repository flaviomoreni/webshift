package br.com.fiap.webshift.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.fiap.webshift.repository.LojaRepository;

@Controller
@RequestMapping("/loja")
public class LojaController {

	
	//@Autowired
	//public LojaRepository lojaRepository;
	
	
	@GetMapping("/")
	public String list() {
		//lojaRepository.findAll();
		return "Lojas";
	}
	
}
