package com.mustache.bbs.controller;


import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.html.Option;
import java.util.Optional;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
    // 스프링이 ArticleRepository 구현체를 DI 해줌
    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }


//    @GetMapping(value = "/new")
//    public String newArticleForm() {
//
//        return "articles/new";
//    }

    @GetMapping("/new")
    public String createPage() {
        return "articles/new";
    }

    @GetMapping("/{id}")
    public String selectSingle(@PathVariable Long id, Model model) {
        Optional<Article> optArticle = articleRepository.findById(id);

        if (!optArticle.isEmpty()) {
            // Optional.get() ---> Article
            model.addAttribute("article", optArticle.get());
            return "articles/show";
        } else {
            return "articles/error";
        }
    }

    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto form){
        log.info(form.toString());
        Article article = form.toEntity();
        return "";
    }

//    @PostMapping("")
//    public String add(ArticleDto articleDto){
//        log.info(articleDto.getTitle());
//        Article savedArticle = articleRepository.save(articleDto.toEntity());
//        log.info("generatedId:{}", savedArticle.getId());
//        return "";
//
//    }
}