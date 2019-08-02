package com.example.produtos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.produtos.model.Produto;
import com.example.produtos.service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {

	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping(value = "/produtos", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> findProduto(){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(produtoService.findAllProdutos()), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value = "/produto/{id}", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> findProdutoById(@PathVariable Long id){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(produtoService.findOneById(id)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping(value = "/produto/add", produces = "application/json; charset=UTF-8")
	public ResponseEntity<String> saveProduto(@RequestBody Produto produto){
		try {
			return new ResponseEntity<String>(new ObjectMapper().writeValueAsString(produtoService.saveProduto(produto)), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
