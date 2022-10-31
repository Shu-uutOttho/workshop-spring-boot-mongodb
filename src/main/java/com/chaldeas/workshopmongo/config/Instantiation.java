package com.chaldeas.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.chaldeas.workshopmongo.domain.User;
import com.chaldeas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		userRepository.deleteAll();

		User emiyaS = new User(null, "Emiya Shirou", "emiya@gmail.com");
		User emiyak = new User(null, "Emiya kiritsugu", "kerry@gmail.com");
		User kotomine = new User(null, "Kotomine Kirei", "priest@gmail.com");
		User issei = new User(null, "Issei Ryoudo", "ryou@gmail.com");
		User sakura = new User(null, "Matou Sakura", "sakura@gmail.com");
		User rin = new User(null, "Tohsaka Rin", "rin@gmail.com");
		User toki = new User(null, "Tohsaka tokiomi", "toki@gmail.com");

		userRepository.saveAll(Arrays.asList(issei, emiyak, emiyaS, kotomine, sakura, toki, rin));
	}

}
