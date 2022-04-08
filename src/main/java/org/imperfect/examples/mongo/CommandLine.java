// SPDX-License-Identifier: MIT
package org.imperfect.examples.mongo;

import org.imperfect.examples.mongo.user.User;
import org.imperfect.examples.mongo.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Arrays;

@Configuration
public class CommandLine implements CommandLineRunner {

	private final UserService service;

	public CommandLine(UserService service) {
		this.service = service;
	}

	@Override
	public void run(String... args) {
		service.clear();

		Arrays.asList(
				User.builder().Name("Kiss Pista").eMail("kiss.pista@test.com").build(),
				User.builder().Name("Agy Alap").build(),
				User.builder().Name("Aranyos Anna").build(),
				User.builder().Name("Fura Ferenc").eMail("fura.ferenc@test.com").build(),
				User.builder().Name("Kovács Károly").eMail("kovacs.karoly@test.com").build(),
				User.builder().Name("Helyes Henrietta").build(),
				User.builder().Name("Tóth Jóska").eMail("toth.joska@test.com").build()
		).forEach(user -> service.save(Mono.just(user)).block());
	}
}
