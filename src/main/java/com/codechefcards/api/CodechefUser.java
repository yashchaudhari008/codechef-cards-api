package com.codechefcards.api;

public class CodechefUser {
	private String username;
	private String name;
	private boolean isActiveUser;
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

	public Boolean getIsActiveUser() {
		return this.isActiveUser;
	}

	public void setIsActiveUser(Boolean isActive) {
		this.isActiveUser = isActive;
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

	public void setGlobalRank(String globalRank) {
		try {
			this.globalRank = Long.valueOf(globalRank);
			setIsActiveUser(true);
		} catch (NumberFormatException e) {
			this.globalRank = null;
			setIsActiveUser(false);
		}
	}

	public Long getCountryRank() {
		return countryRank;
	}

	public void setCountryRank(String countryRank) {
		try {
			this.countryRank = Long.valueOf(countryRank);
		} catch (NumberFormatException e) {
			this.countryRank = null;
		}
	}

	public Long getProblemFullySolved() {
		return problemFullySolved;
	}

	public void setProblemFullySolved(String problemFullySolved) {
		try {
			this.problemFullySolved = Long.valueOf(problemFullySolved);
		} catch (NumberFormatException e) {
			this.problemFullySolved = 0l;
		}
	}

	public Long getProblemPartiallySolved() {
		return problemPartiallySolved;
	}

	public void setProblemPartiallySolved(String problemPartiallySolved) {
		try {
			this.problemPartiallySolved = Long.valueOf(problemPartiallySolved);
		} catch (NumberFormatException e) {
			this.problemPartiallySolved = 0l;
		}
		;
	}

	public CodechefUser() {
	}

	public CodechefUser(String username) {
		super();
		this.username = username;
	}

}
