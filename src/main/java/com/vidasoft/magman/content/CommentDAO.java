package com.vidasoft.magman.content;

import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Comment;

import javax.persistence.EntityManager;
import java.util.Optional;

public class CommentDAO {

    private ArticleDAO articleDAO;
    private EntityManager entityManager;

    public CommentDAO(ArticleDAO articleDAO, EntityManager entityManager) {
        this.articleDAO = articleDAO;
        this.entityManager = entityManager;
    }

    public Comment addCommentToArticle(Long articleId, Comment comment) {
        Optional<Article> article = articleDAO.findArticleById(articleId);
        article.ifPresent(a -> doAddComment(a, comment));
        return comment;
    }

    private void doAddComment(Article a, Comment comment) {
        entityManager.persist(comment);
        a.addComment(comment);
    }
}
