package org.example.springbootadvance.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.springbootadvance.post.dto.CommentCreateDTO;
import org.example.springbootadvance.post.dto.PostCreateDto;
import org.example.springbootadvance.post.dto.PostDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

    private final PostRepository postRepository;
    private final PostServise postServise;

    @GetMapping("/{id}")
    public ResponseEntity<PostDto> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(postServise.getPost(id));
    }


    @PostMapping
    public ResponseEntity<PostDto> save(@RequestBody PostCreateDto dto) {
        return ResponseEntity.ok(postServise.createPost(dto));
    }

    @PostMapping("/comment")
    public ResponseEntity<Void> createComments(@RequestBody List<CommentCreateDTO> dto) {
        postServise.createComments(dto);
        return ResponseEntity.noContent().build();
    }

}
