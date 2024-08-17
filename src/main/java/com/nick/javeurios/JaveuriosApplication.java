package com.nick.javeurios;

import com.nick.javeurios.entity.MilitarEntity;
import com.nick.javeurios.entity.PostoGrad;
import com.nick.javeurios.entity.Subunidade;
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
		UUID randomId = UUID.randomUUID();

		PostoGrad posto = PostoGrad.PRIM_TEN;

//		militarRepository.save(new MilitarEntity(
//				randomId,
//				"1100101010",
//				"DAISUKE",
//				Subunidade.EM,
//				"11963961870"
//				));
	}
}
