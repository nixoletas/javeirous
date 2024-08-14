package com.nick.javeurios;

import com.nick.javeurios.entity.UserEntity;
import com.nick.javeurios.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JaveuriosApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JaveuriosApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		userRepository.save(new UserEntity(1L, "Nick"));
		userRepository.save(new UserEntity(2L, "Pedro"));
		userRepository.save(new UserEntity(3L, "Paulo"));
	}
}
