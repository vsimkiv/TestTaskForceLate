package com.simkiv.forcelate.entity;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude
    private Long id;

    @Column(name = "text")
    private String text;

    @Column(name = "color")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}
