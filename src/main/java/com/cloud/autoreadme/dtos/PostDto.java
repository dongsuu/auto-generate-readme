package com.cloud.autoreadme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostDto {
    private String projectName;
    private String question;
    private String answer;
}
