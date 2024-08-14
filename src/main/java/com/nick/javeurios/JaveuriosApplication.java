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
	}
}
