package com.nick.javeurios;

import com.nick.javeurios.enums.PostoGrad;
import com.nick.javeurios.repository.CargaRepository;
import com.nick.javeurios.repository.MilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.UUID;

@SpringBootApplication
public class JaveuriosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JaveuriosApplication.class, args);
	}

	@Autowired
	private CargaRepository userRepository;
	@Autowired
	private MilitarRepository militarRepository;

	@Override
	public void run(String... args) throws Exception {

	}
}
