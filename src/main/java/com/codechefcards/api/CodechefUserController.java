package com.codechefcards.api;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CodechefUserController {
	@GetMapping("/{data}")
	public List<Object> output(@PathVariable(required = true, name = "data") String username) {
		String CONNECTION_URL = String.format("https://www.codechef.com/users/%s", username);
		CodechefUser user = new CodechefUser(username);
		try {
			Document doc = Jsoup.connect(CONNECTION_URL).get();

			Element userDetailsContainer = doc.getElementsByClass("user-details-container").first();

			// NAME
			user.setName(
					userDetailsContainer
							.getElementsByTag("header")
							.first()
							.getElementsByIndexEquals(1)
							.text());

			// RATING
			user.setRating(
					Integer.valueOf(
							doc.getElementsByClass("rating-number")
									.first()
									.ownText()
									.replaceAll("[^0-9]", "")));

			// HIGHEST RATING
			user.setHighestRating(
					Integer.valueOf(
							doc.getElementsByClass("rating-header")
									.first()
									.getElementsByTag("small")
									.first()
									.ownText()
									.replaceAll("[^0-9]", "")));

			// STARS
			user.setStars(
					doc.getElementsByClass("rating-star")
							.size());

		} catch (Exception e) {
			return List.of(e.toString());
		}
		return List.of(user);
	}

}
