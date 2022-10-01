package com.codechefcards.api.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;

@NoArgsConstructor
@Data
public class CodeChefUser {
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
    private Integer contestParticipated;
    private String country;
}
