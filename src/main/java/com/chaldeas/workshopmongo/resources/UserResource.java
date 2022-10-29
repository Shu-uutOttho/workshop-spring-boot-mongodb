package com.chaldeas.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chaldeas.workshopmongo.domain.User;

@RestController
@RequestMapping(value="/users")
public class UserResource {

	@GetMapping
	public ResponseEntity<List<User>> findAll() {
		User emiya = new User("1", "Emiya Shirou", "seigi@gmail.com");
		User rin = new User("2", "Tohsaka Rin", "tohsaka@hotmail.com");
		User sakura = new User("3", "Matou Sakura", "Sakura@hotmail.com");
		List<User> list = new ArrayList<>();
		list.addAll(Arrays.asList(emiya, rin, sakura));
		return ResponseEntity.ok().body(list);
	}
}
