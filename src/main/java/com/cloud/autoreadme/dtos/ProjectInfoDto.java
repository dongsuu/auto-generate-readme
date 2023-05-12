package com.cloud.autoreadme.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProjectInfoDto {
    private String githubLink;
    private String name;
    private String projectInfo;
    private String techInfo;
    private String memberInfo;
}
