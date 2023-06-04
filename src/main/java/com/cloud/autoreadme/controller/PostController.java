package com.cloud.autoreadme.controller;

import com.cloud.autoreadme.dtos.PostDto;
import com.cloud.autoreadme.dtos.PostRequest;
import com.cloud.autoreadme.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/new")
    public ResponseEntity<Void> createPost(@RequestBody PostRequest postRequest){
        postService.createPost(postRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/update/{postId}")
    public ResponseEntity<Void> updatePost(@RequestBody PostRequest postRequest, @PathVariable("postId") Long postId){
        postService.updatePost(postRequest, postId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PostDto>> findAllPosts(){
        List<PostDto> posts = postService.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
