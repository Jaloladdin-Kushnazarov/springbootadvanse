package org.example.springbootadvance.post;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    private String postId;

    private String title;

    private String body;

    private Integer userId;


}
