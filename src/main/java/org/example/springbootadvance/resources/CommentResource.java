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

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentResource {

    private final RestTemplate restTemplate;

    @Value("${comments.url.postComments}")
    private String postCommentUrl;

    @Value("${comments.url.saveComments}")
    private String saveAllCommentsUrl;

    public void saveAll(@NonNull List<CommentCreateDTO> dtos) {
        HttpEntity<List<CommentCreateDTO>> httpEntity = new HttpEntity<>(dtos);
        restTemplate.exchange(saveAllCommentsUrl, HttpMethod.POST, httpEntity, Void.class);
    }

    public List<CommentDto> getAllComments(Integer postId) {
//        ResponseEntity<List> responseEntity = restTemplate.getForEntity(url, List.class, post.getId()); //Coments Listini to'liq olish uchun
//        List comments = responseEntity.getBody();


//        HttpHeaders headers = new HttpHeaders();
//        headers.setBearerAuth("token..... ");
//        headers.add("Content-Type", "application/json");
//        HttpEntity httpEntity = new HttpEntity(new Object(), headers);//bu requestni tariflab beruvchi object unga headeriga va bodysiga kerakli narsalar berib yuborilishi mumkin
        try {
            return restTemplate.exchange(
                            postCommentUrl,
                            HttpMethod.GET,
                            HttpEntity.EMPTY,
                            new ParameterizedTypeReference<List<CommentDto>>() {
                            },
                            postId)
                    .getBody();
        } catch (ResourceAccessException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }
}
