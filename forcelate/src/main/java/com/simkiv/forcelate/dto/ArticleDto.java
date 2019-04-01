package com.simkiv.forcelate.dto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ArticleDto {
    private long id;
    private String text;
    private long authorId;
    private String color;
}
