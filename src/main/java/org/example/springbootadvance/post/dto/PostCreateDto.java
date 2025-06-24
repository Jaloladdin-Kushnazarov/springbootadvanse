package org.example.springbootadvance.post.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.Value;
import org.example.springbootadvance.post.Post;

import java.io.Serializable;

/**
 * DTO for {@link Post}
 */


@Value
@Getter
@Setter
public class PostCreateDto implements Serializable {
    String title;
    String body;
}