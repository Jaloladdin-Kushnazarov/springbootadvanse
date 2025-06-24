package org.example.springbootadvance.post;

import lombok.*;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Integer id;

    private String title;

    private String body;

    private Integer userId;

}
