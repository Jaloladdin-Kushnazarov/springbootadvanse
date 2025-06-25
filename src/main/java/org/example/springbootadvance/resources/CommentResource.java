package org.example.springbootadvance.resources;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.post.dto.CommentCreateDTO;
import org.example.springbootadvance.post.dto.CommentDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {

    private final WebClient webClient;

    @Value("${comments.url.postComments}")
    private String postCommentUrl;

    @Value("${comments.url.saveComments}")
    private String saveAllCommentsUrl;

    public void saveAll(@NonNull List<CommentCreateDTO> dtos) {
        webClient.post()
                .uri(saveAllCommentsUrl)
                .body(BodyInserters.fromValue(dtos))
                .retrieve()
                .bodyToMono(Void.class)
                .block() ;
    }

    public List<CommentDto> getAllComments(Integer postId) {
        return webClient.get()
                .uri(postCommentUrl, postId)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<CommentDto>>() {})
                .block() ;
    }
}
