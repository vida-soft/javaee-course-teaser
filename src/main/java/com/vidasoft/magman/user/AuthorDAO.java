package com.vidasoft.magman.user;

import com.vidasoft.magman.model.Author;

import javax.persistence.EntityManager;

public class AuthorDAO {

    private EntityManager entityManager;

    public AuthorDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Author addAuthor(Author author) {
        entityManager.persist(author);
        return author;
    }
}
