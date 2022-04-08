// SPDX-License-Identifier: MIT
package org.imperfect.examples.mongo.user;

import com.mongodb.client.result.UpdateResult;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/users")
public class UserController {

	private final UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping("/{id}")
	public Mono<User> fetchUsers(String id) {
		return service.findById(id);
	}

	@GetMapping
	public Flux<User> fetchUsers() {
		return service.findAll();
	}

	@PostMapping
	public Mono<String> addUser(Mono<User> user) {
		return service.save(user).map(User::getId);
	}

	@PutMapping
	public Mono<UpdateResult> updateUsers() {
		return service.activate();
	}
}
