package com.nelioalves.curso_mc;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import com.nelioalves.curso_mc.domain.*;
import com.nelioalves.curso_mc.enums.EstadoPagamento;
import com.nelioalves.curso_mc.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nelioalves.curso_mc.enums.TipoCliente;

@SpringBootApplication
public class CursoMcApplication implements CommandLineRunner {
	


	
	public static void main(String[] args) {
		SpringApplication.run(CursoMcApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		

	}
}
