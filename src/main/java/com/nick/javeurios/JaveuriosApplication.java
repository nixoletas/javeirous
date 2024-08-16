package com.nick.javeurios;

import com.nick.javeurios.entity.UserEntity;
import com.nick.javeurios.repository.UserRepository;
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
	private UserRepository userRepository;


	@Override
	public void run(String... args) throws Exception {
		UUID userId = UUID.randomUUID();
		userRepository.save(new UserEntity(userId, "1231231312", "Antena SEM DESCRICAO", "B Adm 14, 3 MAIO 24"));
	}
}
