package com.cloud.autoreadme.service;

import com.cloud.autoreadme.domain.Project;
import com.cloud.autoreadme.dtos.ChatGptResponse;
import com.cloud.autoreadme.dtos.ProjectInfoDto;
import com.cloud.autoreadme.repository.ProjectRepository;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ChatgptService chatGptService;

    public ChatGptResponse getChatGptResponse(ProjectInfoDto projectInfoDto){
        String githubLink = projectInfoDto.getGithubLink();
        String projectName = projectInfoDto.getName();
        String projectInfo = projectInfoDto.getProjectInfo();
        String membersInfo = projectInfoDto.getMemberInfo();
        String techInfo = projectInfoDto.getTechInfo();

        String prompt = "Please generate me a github read.md file. Here's some information." +
                "github link is " + githubLink + ", You must analysis this github link repository and add read.md file functions about projects. " +
                "projectName is " + projectName + ", " +
                "this project is " + projectInfo + ", " +
                "project's members are " + membersInfo + ", " +
                "and used techniques are " + techInfo + ".";

        try {
            // Ask to ChatGpt
            String responseMessage = chatGptService.sendMessage(prompt);

            return new ChatGptResponse(responseMessage);
        } catch (Exception exception){
            throw new RuntimeException("Request Error");
        }
    }
}
