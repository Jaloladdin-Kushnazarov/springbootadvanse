package org.example.springbootadvance.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {

     private final PostServise postServise;

    @GetMapping("/{id}")
    public ResponseEntity<Post> findById(@PathVariable Integer id) throws Exception {
        return ResponseEntity.ok(postServise.getPost(id));
    }


}
