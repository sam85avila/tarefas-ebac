package com.samuel.EbacSpringBoot;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.samuel.domain.Produto;
import com.samuel.repository.IProdutoRepository;

@SpringBootApplication
@Configuration
@EnableJpaRepositories(basePackages = "com.samuel.repository")
@EntityScan("com.samuel.*")  
@ComponentScan(basePackages = "com.samuel")
public class EbacSpringBootApplication implements CommandLineRunner{
	
	private static final Logger log = LoggerFactory.getLogger(EbacSpringBootApplication.class);
	
	@Autowired
	private IProdutoRepository repository;
	
		
	public static void main(String[] args) {
		SpringApplication.run(EbacSpringBootApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("StartApplication...");
		Produto produto = createProduto();
		repository.save(produto);
	}

	private Produto createProduto() {
		return Produto.builder()
				.nome("RedMi Note 11 Pro")
				.descricao("SmartPhone Xiaomi")
				.marca("Xiaomi")
				.valor(BigDecimal.valueOf(2599.99))
				.build();
				
	}

}
