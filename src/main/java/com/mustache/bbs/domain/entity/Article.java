package com.mustache.bbs.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // @Entity 와 @id 는 세트, id가 꼭 필요함 , Primary Key를 의미함
public class Article {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String contents;

    public Article(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}
