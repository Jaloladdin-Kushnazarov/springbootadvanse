package org.example.springbootadvance.post;

import lombok.NonNull;
import org.example.springbootadvance.post.dto.CommentCreateDTO;
import org.example.springbootadvance.post.dto.PostCreateDto;
import org.example.springbootadvance.post.dto.PostDto;

import java.util.List;

public interface PostServise {

    PostDto getPost(@NonNull Integer id);

    PostDto createPost(PostCreateDto postCreateDto);

    void createComments(@NonNull List<CommentCreateDTO> dto);
}
