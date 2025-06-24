package org.example.springbootadvance.post.dto;

import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Integer id;

    private String title;

    private String body;

    private List<CommentDto> commentDtos;

}
