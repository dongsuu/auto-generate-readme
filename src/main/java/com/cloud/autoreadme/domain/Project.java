package com.cloud.autoreadme.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    private String githubLink;
    private String name;
    private String projectInfo;
    private String techInfo;
    private String memberInfo;

    @Builder
    public Project(String githubLink, String name, String projectInfo, String techInfo, String memberInfo){
        this.githubLink = githubLink;
        this.name = name;
        this.projectInfo = projectInfo;
        this.techInfo = techInfo;
        this.memberInfo = memberInfo;
    }

}
