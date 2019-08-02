package com.example.produtos.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.produtos.model.Produto;

@Service
public class ProdutoService {
	

	public List<Produto> findAllProdutos() {
		System.out.println("oiii");
		List<Produto> produtos = new ArrayList<>();
		ParseCSV parseCsv = new ParseCSV();
		produtos = parseCsv.convertCsv();
		return produtos;
	}

	public Produto findOneById(Long id) {
		int index =0;
		List<Produto> produtos = new ArrayList<>();
		ParseCSV parseCsv = new ParseCSV();
		produtos = parseCsv.convertCsv();
		
		while(id != produtos.get(index).getId()) {
			index ++;
		}
		return produtos.get(index);
	}

	public String saveProduto(Produto produto) {
		ParseCSV parseCsv = new ParseCSV();
		return parseCsv.generateCsvFile(produto);
	}

}
