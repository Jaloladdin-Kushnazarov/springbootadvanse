package org.example.springbootadvance.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.post.dto.CommentCreateDTO;
import org.example.springbootadvance.post.dto.CommentDto;
import org.example.springbootadvance.post.dto.PostCreateDto;
import org.example.springbootadvance.post.dto.PostDto;
import org.example.springbootadvance.resources.CommentClient;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiseImpl implements PostServise {

    private final PostRepository postRepository;
    private final CommentClient commentClient;


    @Override
    public PostDto getPost(@NonNull Integer id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Post not found by id: " + id));

        List<CommentDto> comments = commentClient.getAllCommentsByPostId(post.getId());

        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .commentDtos(comments)
                .build();
    }

    @Override
    public PostDto createPost(@NonNull PostCreateDto dto) {
        Post post = Post.builder()
                .title(dto.getTitle())
                .body(dto.getBody())
                .build();
        postRepository.save(post);
        return PostDto.builder()
                .id(post.getId())
                .title(post.getTitle())
                .body(post.getBody())
                .build();

    }

    @Override
    public void createComments(@NonNull List<CommentCreateDTO> dtos) {
        commentClient.saveAllCommentsByPostId(dtos);
    }
}
