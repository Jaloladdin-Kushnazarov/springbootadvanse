package org.example.springbootadvance.post;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.springbootadvance.resources.CommentResource;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class PostServiseImpl implements PostServise {

    private final CommentResource commentResource;


    @Override
    public Post getPost(@NonNull Integer id) throws Exception {
       return commentResource.getPost(id);
    }
}
