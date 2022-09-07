package com.codechefcards.api;

public class CodechefUser {
	private String username;
	private String name;
	private Integer rating;
	private Integer highestRating;
	private Integer stars;
	private Long globalRank;
	private Long countryRank;
	private Long problemFullySolved;
	private Long problemPartiallySolved;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Integer getHighestRating() {
		return highestRating;
	}

	public void setHighestRating(Integer highestRating) {
		this.highestRating = highestRating;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	public Long getGlobalRank() {
		return globalRank;
	}

	public void setGlobalRank(Long globalRank) {
		this.globalRank = globalRank;
	}

	public Long getCountryRank() {
		return countryRank;
	}

	public void setCountryRank(Long countryRank) {
		this.countryRank = countryRank;
	}

	public Long getProblemFullySolved() {
		return problemFullySolved;
	}

	public void setProblemFullySolved(Long problemFullySolved) {
		this.problemFullySolved = problemFullySolved;
	}

	public Long getProblemPartiallySolved() {
		return problemPartiallySolved;
	}

	public void setProblemPartiallySolved(Long problemPartiallySolved) {
		this.problemPartiallySolved = problemPartiallySolved;
	}

	public CodechefUser() {
	}

	public CodechefUser(String username) {
		super();
		this.username = username;
	}

}
