package com.cloud.autoreadme.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Project {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String projectInfo;
    private String techInfo;
    private String memberInfo;

    @Builder
    public Project(String name, String projectInfo, String techInfo, String memberInfo){
        this.name = name;
        this.projectInfo = projectInfo;
        this.techInfo = techInfo;
        this.memberInfo = memberInfo;
    }

}
