// SPDX-License-Identifier: MIT
package org.imperfect.examples.mongo.user;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Document
public class User {

	@Id
	private final String id;
	private final String Name;
	private final String eMail;
	private final boolean active;
}
