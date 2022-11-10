package com.mustache.bbs.domain.entity;

import com.mustache.bbs.domain.dto.ArticleDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity // @Entity 와 @id 는 세트, id가 꼭 필요함 , Primary Key를 의미함
@Table(name = "article2")
@NoArgsConstructor
@Getter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID를 직접 생성하지 않고 자동으로 생성하도록 한 경우에 붙임
    //private Long id;
    private String title;
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
