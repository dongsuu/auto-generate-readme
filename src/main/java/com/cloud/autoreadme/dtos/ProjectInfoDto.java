package com.cloud.autoreadme.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectInfoDto {
    private String githubLink;
    private String name;
    private String projectInfo;
    private String techInfo;
    private String memberInfo;
}
