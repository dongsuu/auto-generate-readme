package com.cloud.autoreadme.controller;

import com.cloud.autoreadme.dtos.ChatGptResponse;
import com.cloud.autoreadme.dtos.ProjectInfoDto;
import com.cloud.autoreadme.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @PostMapping(value = "/ask")
    public ResponseEntity<ChatGptResponse> question(@RequestBody ProjectInfoDto projectInfoDto){
        ChatGptResponse chatGptResponse = projectService.getChatGptResponse(projectInfoDto);
        return new ResponseEntity<>(chatGptResponse, HttpStatus.OK);
    }
}
