package com.vidasoft.magman.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Article {

    private String title;
    private String content;
    private Author author;
    private LocalDate publishDate;
    private List<Comment> comments = new ArrayList<>();

    public Article() {
    }

    public Article(String title, String content, Author author, LocalDate publishDate) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.publishDate = publishDate;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public void addComment(Comment newComment) {
        this.comments.add(newComment);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(title, article.title) &&
                Objects.equals(content, article.content) &&
                Objects.equals(author, article.author) &&
                Objects.equals(publishDate, article.publishDate) &&
                Objects.equals(comments, article.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, content, author, publishDate, comments);
    }

    @Override
    public String toString() {
        String displayContent = content;
        if (content.length() > 30) {
            displayContent = content.substring(0, 29);
        }
        return "Article{" +
                "title='" + title + '\'' +
                ", content='" + displayContent + '\'' +
                ", author=" + author.getUserName() +
                ", publishDate=" + publishDate +
                ", comments=" + comments +
                '}';
    }
}
