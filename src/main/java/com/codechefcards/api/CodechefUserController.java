package com.codechefcards.api;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.HashMap;

import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class CodechefUserController {

	private class APIResponse {
		CodechefUser data;
		String status;

		public CodechefUser getData() {
			return data;
		}

		public void setData(CodechefUser data) {
			this.data = data;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public APIResponse(CodechefUser data, String status) {
			this.data = data;
			this.status = status;
		}

	}

	@GetMapping("/")
	public String defaultOutput() {
		return "REST API Running";
	}

	@CrossOrigin
	@GetMapping("/{data}")
	public APIResponse output(@PathVariable(required = true, name = "data") String username) {
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
							.first()
							.getElementsByTag("span")
							.size());

			// GLOBAL RANK
			user.setGlobalRank(
					doc.getElementsByClass("rating-ranks")
							.first()
							.getElementsByTag("a")
							.first()
							.text());

			// COUNTRY RANK
			user.setCountryRank(
					doc.getElementsByClass("rating-ranks")
							.first()
							.getElementsByTag("a")
							.last()
							.text());

			// PROBLEM FULLY SOLVED
			user.setProblemFullySolved(
					doc.getElementsByClass("problems-solved")
							.first()
							.getElementsByTag("h5")
							.first()
							.ownText()
							.replaceAll("[^0-9]", ""));

			// PROBLEM PARTIALLY SOLVED
			user.setProblemPartiallySolved(
					doc.getElementsByClass("problems-solved")
							.first()
							.getElementsByTag("h5")
							.get(1)
							.ownText()
							.replaceAll("[^0-9]", ""));

			user.setContestParticipated(
					Integer.valueOf(
							doc.getElementsByClass("contest-participated-count")
									.first()
									.getElementsByTag("b")
									.first()
									.ownText()));

			// COUNTRY
			user.setCountry(
					userDetailsContainer
							.getElementsByClass("user-details")
							.first()
							.getElementsByClass("user-country-name")
							.first()
							.ownText());

		} catch (Exception e) {
			return new APIResponse(null, "error");
		}
		return new APIResponse(user, "success");
	}

}
