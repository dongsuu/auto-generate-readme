package com.cloud.autoreadme.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PostRequest {
    private String question;
    private String answer;
    private Long projectId;
}
