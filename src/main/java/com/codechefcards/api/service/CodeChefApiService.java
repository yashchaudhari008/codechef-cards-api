package com.codechefcards.api.service;

import com.codechefcards.api.model.CodeChefUser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Service;

@Service
public class CodeChefApiService {

    public CodeChefUser getDetails(String userName) throws JsonProcessingException {
        String CONNECTION_URL = String.format("https://www.codechef.com/users/%s", userName);
        CodeChefUser user = new CodeChefUser();
        user.setUsername(null);
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
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
                    Long.valueOf(doc.getElementsByClass("rating-ranks")
                            .first()
                            .getElementsByTag("a")
                            .first()
                            .text()));

            // COUNTRY RANK
            user.setCountryRank(
                    Long.valueOf(doc.getElementsByClass("rating-ranks")
                            .first()
                            .getElementsByTag("a")
                            .last()
                            .text()));

            // PROBLEM FULLY SOLVED
            user.setProblemFullySolved(
                    Long.valueOf(doc.getElementsByClass("problems-solved")
                            .first()
                            .getElementsByTag("h5")
                            .first()
                            .ownText()
                            .replaceAll("[^0-9]", "")));

            // PROBLEM PARTIALLY SOLVED
            user.setProblemPartiallySolved(
                    Long.valueOf(doc.getElementsByClass("problems-solved")
                            .first()
                            .getElementsByTag("h5")
                            .get(1)
                            .ownText()
                            .replaceAll("[^0-9]", "")));

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
            return null;
        }
        user.setUsername(userName);
        return user;
    }
}
