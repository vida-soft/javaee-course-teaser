package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Author;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ArticleDAO {

    private EntityManager entityManager;

    public ArticleDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Article> getAllArticles() {
        TypedQuery<Article> articleQuery = entityManager.createNamedQuery("getAllArticles", Article.class);
        return articleQuery.getResultList();
    }

    public Optional<Article> findArticleById(Long id) {
        Optional<Article> article = Optional.ofNullable(entityManager.find(Article.class, id));
        article.ifPresent(a -> a.getComments().size());
        return article;
    }

    public List<Article> findArticlesByAuthor(Author author) {
        entityManager.merge(author);
        TypedQuery<Article> query = entityManager.createNamedQuery("findArticlesByAuthor", Article.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public Article addArticle(Article newArticle) {
        entityManager.persist(newArticle);
        return newArticle;
    }

}
