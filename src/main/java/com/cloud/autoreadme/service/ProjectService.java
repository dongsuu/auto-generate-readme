package com.cloud.autoreadme.service;

import com.cloud.autoreadme.domain.Project;
import com.cloud.autoreadme.dtos.ChatGptResponse;
import com.cloud.autoreadme.dtos.ProjectInfoDto;
import com.cloud.autoreadme.repository.ProjectRepository;
import io.github.flashvayne.chatgpt.service.ChatgptService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ChatgptService chatGptService;

    public ChatGptResponse getChatGptResponse(ProjectInfoDto projectInfoDto){
        String githubLink = projectInfoDto.getGithubLink();
        String projectName = projectInfoDto.getName();
        String projectInfo = projectInfoDto.getProjectInfo();
        String membersInfo = projectInfoDto.getMemberInfo();
        String techInfo = projectInfoDto.getTechInfo();

        String prompt = getPromptResult(projectInfoDto);

        try {
            // Ask to ChatGpt
            String responseMessage = chatGptService.sendMessage(prompt);

            return new ChatGptResponse(responseMessage);
        } catch (Exception exception){
            log.error(exception.getMessage());
            log.error(exception.getCause().getMessage());
            throw new RuntimeException("Request Error");
        }
    }

    private String getPromptResult(ProjectInfoDto projectInfoDto){
        return "You are going to make a README.md file for user. You will receive the GitHub link of the project and some information about the project. You should make a well-written README based on the information you got.\n" +
                "Below is an example that you can refer to.\n" +
                "---------------------\n" +
                "github link: https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX\n" +
                "project name: Project-MEGABOX\n" +
                "brief project introduction: MEGA BOX를 참고하여 만든 영화 예매 사이트\n" +
                "tech stack: Java 8, JDK 1.8.0, IDE : STS 3.9, Framework : Springboot(2.x), Database : Oracle DB(11xe), ORM : Mybatis\n" +
                "members: 이윤재(팀장) - 영화 예매, 업로드, Database Script 제작, 통합 및 형상관리\n" +
                "채현우(팀원) - 로그인, 회원가입, ID찾기, PW찾기, 마이 페이지,메인 페이지, 통합 및 형상관리, PPT제작, 발표\n" +
                "이종원(팀원) - 메인 페이지, 메인 CSS\n" +
                "전성덕(팀원) - 1대1 문의 게시판(CRUD), 공지사항 게시판(CRUD)\n" +
                "김창훈(팀원) - 1대1 문의 게시판(CRUD), 공지사항 게시판(CRUD)\n" +
                "김성재(팀원) - 로그인, 회원가입, ID찾기, PW찾기\n" +
                "\n" +
                "created README example: https://github.com/chaehyuenwoo/SpringBoot-Project-MEGABOX/blob/main/README.md\n" +
                "---------------------\n" +
                "Now you are going to start! Please add icons and functions of Application.\n" +
                "\n" +
                "github link: " + projectInfoDto.getGithubLink() + "\n" +
                "project name: " + projectInfoDto.getName() + "\n" +
                "brief project introduction: " + projectInfoDto.getProjectInfo() + "\n" +
                "tech stack: " + projectInfoDto.getTechInfo() + "\n" +
                "members: " + projectInfoDto.getMemberInfo() + "\n\n";
    }
}
