package com.cloud.autoreadme.controller;

import com.cloud.autoreadme.dtos.PostDto;
import com.cloud.autoreadme.dtos.PostRequest;
import com.cloud.autoreadme.service.PostService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "게시글 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @Operation(summary = "게시글 작성 API", description = "question, answer, projectId를 받아 게시글 작성한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 작성 성공")
    })
    @PostMapping("/new")
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest){
        postService.createPost(postRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "게시글 수정 API", description = "question, answer를 RequestBody, PostId는 PathVariable로 받아 게시글 수정한다.")
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 수정 성공")
    })
    @PostMapping("/update/{postId}")
    public ResponseEntity<Void> updatePost(@RequestBody PostRequest postRequest, @PathVariable("postId") Long postId){
        postService.updatePost(postRequest, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "전체 게시글 조회 API", description = "모든 게시글을 조회한다. projectName, question, answer를 반환")
    @ApiResponses({
            @ApiResponse(code = 200, message = "게시글 전체 조회 성공")
    })
    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> findAllPosts(){
        List<PostDto> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
