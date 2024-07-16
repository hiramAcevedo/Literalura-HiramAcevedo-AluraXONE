package com.hiramwoki.literalura_hiramAcevedo;

import com.hiramwoki.literalura_hiramAcevedo.principal.Principal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class LiteraluraHiramAcevedoApplication implements CommandLineRunner {


	private final Principal principal;

	@Autowired
	public LiteraluraHiramAcevedoApplication(Principal principal) {
		this.principal = principal;
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraHiramAcevedoApplication.class, args);
	}


	@Override
	public void run(String... args) {
		principal.ejecutar();
	}

}
