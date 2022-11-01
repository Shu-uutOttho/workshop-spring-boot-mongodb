package com.chaldeas.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.chaldeas.workshopmongo.domain.Post;
import com.chaldeas.workshopmongo.domain.User;
import com.chaldeas.workshopmongo.repository.PostRepository;
import com.chaldeas.workshopmongo.repository.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		userRepository.deleteAll();
		postRepository.deleteAll();

		User emiyaS = new User(null, "Emiya Shirou", "emiya@gmail.com");
		User emiyak = new User(null, "Emiya kiritsugu", "kerry@gmail.com");
		User kotomine = new User(null, "Kotomine Kirei", "priest@gmail.com");
		User issei = new User(null, "Issei Ryoudo", "ryou@gmail.com");
		User sakura = new User(null, "Matou Sakura", "sakura@gmail.com");
		User rin = new User(null, "Tohsaka Rin", "rin@gmail.com");
		User toki = new User(null, "Tohsaka tokiomi", "toki@gmail.com");

		Post post1 = new Post(null, sdf.parse("21/03/2013"), "Intankavel o bostil", "Graças a odin,Vou sair do Bostil",
				rin);
		Post post2 = new Post(null, sdf.parse("23/03/2013"), "Graças a odin", "Boa sorte no exterior, felicitações",
				toki);
		Post post3 = new Post(null, sdf.parse("24/03/2013"), "Ai sim meu consagrado",
				"Eu ai um dia,to me preparando pra largar isso aqui", emiyaS);

		Post post4 = new Post(null, sdf.parse("24/03/2013"), "Parabéns",
				"Falei que era só confiar na call que dava tudo certo", sakura);
		userRepository.saveAll(Arrays.asList(issei, emiyak, emiyaS, kotomine, sakura, toki, rin));
		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4));
	}

}
