package com.cloud.autoreadme.controller;

import com.cloud.autoreadme.dtos.ChatGptResponse;
import com.cloud.autoreadme.dtos.ProjectInfoDto;
import com.cloud.autoreadme.service.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "read.md 생성 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/project")
public class ProjectController {
    private final ProjectService projectService;

    @Operation(summary = "GPT Question API", description = "Project Info를 받아 Prompting 결과를 토대로 질문 요청")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OPEN AI API 정상 호출")
    })
    @PostMapping(value = "/ask")
    public ResponseEntity<ChatGptResponse> question(@RequestBody ProjectInfoDto projectInfoDto){
        ChatGptResponse chatGptResponse = projectService.getChatGptResponse(projectInfoDto);
        return new ResponseEntity<>(chatGptResponse, HttpStatus.OK);
    }
}
