package com.br.springboot.springboot;

import org.springframework.boot.SpringApplication;

import java.util.Arrays;

import com.br.springboot.springboot.entities.Categoria;
import com.br.springboot.springboot.entities.Produto;
import com.br.springboot.springboot.repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootApplication implements CommandLineRunner {
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);			
	}

	@Override
	public void run(String... args) throws Exception{

		Categoria cat1 = new Categoria("Eletronics");
		Categoria cat2 = new Categoria("Books");

		Produto p1 = new Produto("TV", 2000.00, cat1);
		Produto p2 = new Produto("DOMAIN", 5000.00, cat1);

		Produto p3 = new Produto("SANSUMG", 25500.00, cat2);
		Produto p4 = new Produto("AOC", 2500.00, cat2);

		cat1.getProduto().addAll(Arrays.asList(p1, p2));
		cat2.getProduto().addAll(Arrays.asList(p3, p4));

		categoriaRepository.save(cat1);
		categoriaRepository.save(cat2);

		produtoRepository.save(p1);
		produtoRepository.save(p2);
		produtoRepository.save(p3);
		produtoRepository.save(p4);
	}
}
