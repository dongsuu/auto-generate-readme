package com.cloud.autoreadme.service;

import com.cloud.autoreadme.domain.Post;
import com.cloud.autoreadme.domain.Project;
import com.cloud.autoreadme.dtos.PostDto;
import com.cloud.autoreadme.dtos.PostRequest;
import com.cloud.autoreadme.repository.PostRepository;
import com.cloud.autoreadme.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {
    private final PostRepository postRepository;
    private final ProjectRepository projectRepository;
    
    @Transactional
    public void createPost(PostRequest postRequest){
        Project project = projectRepository.findById(postRequest.getProjectId())
                .orElseThrow(RuntimeException::new);

        Post post = Post.builder()
                .question(postRequest.getQuestion())
                .answer(postRequest.getAnswer())
                .project(project)
                .build();
        
        postRepository.save(post);
    }
    
    @Transactional
    public void updatePost(PostRequest postRequest, Long postId){
        Post findPost = postRepository.findById(postId)
                .orElseThrow(RuntimeException::new);
        
        findPost.updatePost(postRequest.getQuestion(), postRequest.getAnswer());
        
    }

    public List<PostDto> findAll(){
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(p -> new PostDto(p.getProject().getName(), p.getQuestion(), p.getAnswer()))
                .collect(Collectors.toList());

    }


}
