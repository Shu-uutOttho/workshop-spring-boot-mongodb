package com.chaldeas.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.chaldeas.workshopmongo.domain.Post;
import com.chaldeas.workshopmongo.domain.User;
import com.chaldeas.workshopmongo.dto.AuthorDTO;
import com.chaldeas.workshopmongo.dto.CommentDTO;
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

		userRepository.saveAll(Arrays.asList(issei, emiyak, emiyaS, kotomine, sakura, toki, rin));

		Post post1 = new Post(null, sdf.parse("21/03/2013"), "Intankavel o bostil", "Graças a odin,Vou sair do Bostil",new AuthorDTO(rin));
		Post post2 = new Post(null, sdf.parse("14/08/2021"), "Finalmente", "Comprei o Ps5", new AuthorDTO(rin));

		
		CommentDTO c1 = new CommentDTO("Boa sorte no exterior, felicitações",sdf.parse("23/03/2013"),new AuthorDTO(toki));
		CommentDTO c2 = new CommentDTO("Eu ai um dia,to me preparando pra largar isso aqui",sdf.parse("23/03/2013"),new AuthorDTO(emiyaS));
		CommentDTO c3 = new CommentDTO("Falei que era só confiar na call que dava tudo certo",sdf.parse("23/03/2013"),new AuthorDTO(sakura));
		CommentDTO c4 = new CommentDTO("Se voce tivesse me dito antes, eu tinha te ajudado com a viagem e ate feito um guia pra você",sdf.parse("23/03/2013"),new AuthorDTO(kotomine));
		CommentDTO c5 = new CommentDTO("até que em fim percebeu o que eu estava te falando garota,ainda bem, espero te ver em breve",sdf.parse("23/03/2013"),new AuthorDTO(emiyak));
		
		CommentDTO c6 = new CommentDTO("Bora jogar fall guys minha linda",sdf.parse("14/08/2021"),new AuthorDTO(emiyaS));
		CommentDTO c7 = new CommentDTO("agora sim vai zerar os Monster Hunter todos",sdf.parse("14/08/2021"),new AuthorDTO(emiyak));
		CommentDTO c8 = new CommentDTO("um dia me convida pra jogar na sua casa? rsrs",sdf.parse("15/08/2021"),new AuthorDTO(sakura));
		CommentDTO c9 = new CommentDTO("se voce tivesse me dito antes, eu tinha te ajudado voce a por um SSD maneiro nele",sdf.parse("15/08/2021"),new AuthorDTO(kotomine));
		CommentDTO c10 = new CommentDTO("ai vamo jogar genshim, e se me ajuda a alcançar teu nivel de mundo, beleza?",sdf.parse("16/08/2021"),new AuthorDTO(issei));
		
		post1.getComments().addAll(Arrays.asList(c1,c2,c3,c4,c5));
		post2.getComments().addAll(Arrays.asList(c6,c7,c8,c9,c10));
		
		
		postRepository.saveAll(Arrays.asList(post1, post2));

		rin.getPosts().addAll(Arrays.asList(post1, post2));
		userRepository.save(rin);

	}

}
