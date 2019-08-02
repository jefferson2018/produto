package com.example.produtos.service;

import com.example.produtos.model.Produto;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ParseCSV {
	
	public List<Produto> convertCsv() {
		Reader reader;
		Produto pp = new Produto();
		List<Produto> pps = new ArrayList<Produto>();
		try {
			reader = Files.newBufferedReader(Paths.get("C:\\Users\\jefferson.neto\\Documents\\products.csv"));
			  CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
		        List<String[]> produtos = csvReader.readAll();
		        for (String[] produto : produtos) {
		        	pp = new Produto(Long.parseLong(produto[0]),  produto[1], produto[2]);
		        	pps.add(pp);
		        }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		return pps;
	  }
	
	public String generateCsvFile(Produto produto){
		   List<Produto> produtos = convertCsv();
		   produto.setId(produtos.get(produtos.size() -1).getId() + 1);
		   produtos.add(produto);
	       Writer writer;
			try {
				writer = Files.newBufferedWriter(Paths.get("C:\\Users\\jefferson.neto\\Documents\\products.csv"));
				StatefulBeanToCsv<Produto> beanToCsv = new StatefulBeanToCsvBuilder<Produto>(writer).build();
		        try {
					beanToCsv.write(produtos);
				} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException e) {
					e.printStackTrace();
				}
		        writer.flush();
		        writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return "sucesso";

	 }
}