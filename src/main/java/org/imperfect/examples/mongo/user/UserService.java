// SPDX-License-Identifier: MIT
package org.imperfect.examples.mongo.user;

import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserService {

	private final ReactiveMongoTemplate template;

	public UserService(ReactiveMongoTemplate template) {
		this.template = template;
	}

	public Mono<User> findById(String id) {
		return template.findById(id, User.class);
	}

	public Flux<User> findAll() {
		return template.findAll(User.class);
	}

	public Mono<User> save(Mono<User> user) {
		return template.save(user);
	}

	public Mono<UpdateResult> activate() {
		Criteria filterCriteria = Criteria.where("eMail").ne(null);
		Update update = new Update();
		update.set("active", true);
		return template.updateMulti(Query.query(filterCriteria), update, User.class);
	}

	public void clear() {
		template.remove(new Query(), User.class).block();
	}
}
