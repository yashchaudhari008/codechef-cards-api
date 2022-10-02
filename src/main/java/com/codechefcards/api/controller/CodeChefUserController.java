package com.codechefcards.api.controller;

import com.codechefcards.api.model.ApiResponse;
import com.codechefcards.api.model.CodeChefUser;
import com.codechefcards.api.service.CodeChefApiService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class CodeChefUserController {

    @Autowired
    CodeChefApiService codeChefApiService;

    @Autowired
    ObjectMapper mapper;

    @GetMapping("/api/status")
    public String defaultOutput() {
        return "REST API Running";
    }

    @CrossOrigin
    @GetMapping(value = "/{data}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> output(@PathVariable(required = true, name = "data") String username) throws JsonProcessingException {
        ResponseEntity<?> responseEntity = null;
        CodeChefUser userResponse = codeChefApiService.getDetails(username);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(Objects.isNull(userResponse) ? null : userResponse);
        apiResponse.setStatus(Objects.isNull(userResponse) ? "error" : "success");
        responseEntity = new ResponseEntity<>(mapper.writeValueAsString(apiResponse), HttpStatus.OK);
        return responseEntity;
    }

}
