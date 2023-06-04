package com.cloud.autoreadme.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    private String question;
    private String answer;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @Builder
    public Post(String question, String answer, Project project){
        this.question = question;
        this.answer = answer;
        this.project = project;
    }

    public void updatePost(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

}
