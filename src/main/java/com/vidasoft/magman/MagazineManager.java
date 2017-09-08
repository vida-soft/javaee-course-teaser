package com.vidasoft.magman;

import com.vidasoft.magman.user.AuthorDAO;
import com.vidasoft.magman.content.ArticleDAO;
import com.vidasoft.magman.content.CommentDAO;
import com.vidasoft.magman.model.Article;
import com.vidasoft.magman.model.Author;
import com.vidasoft.magman.model.Comment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class MagazineManager {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("magazine-manager");

        /* Add a couple of authors */
        System.out.println("Add authors:");
        EntityManager entityManager = emf.createEntityManager();
        AuthorDAO authorDAO = new AuthorDAO(entityManager);
        entityManager.getTransaction().begin();
        Author johnSmith = authorDAO.addAuthor(new Author("john", "smith", "John",
                "Smith", "john.smit@vida-soft.com", true, 2000));
        Author paulaChester = authorDAO.addAuthor(new Author("paula", "chester", "Paula",
                "Chester","paula.chester@vida-soft.com", false, 750));
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("=============================================");

        /* Add some articles */
        entityManager = emf.createEntityManager();
        System.out.println("Add articles:");
        entityManager.getTransaction().begin();
        ArticleDAO articleDAO = new ArticleDAO(entityManager);
        Article article1 = articleDAO.addArticle(new Article("Bulgarian JUGs 2015",
                "2015 is over and 2016 is a week old now. However, I can’t forget the past year, which happened to be the most active one for the Bulgarian JUG, where I happen to be one of the co-leads. And what a year it was! We had everything: seminar talks with local and foreign speakers, hands on labs, Adopt OpenJDK and Adopt a JSR hackathons, a code retreat and a big international conference. In this blog post I will briefly go through all the events that kept our community busy in 2015.",
                johnSmith, LocalDate.of(2016, Month.JANUARY, 6)));
        articleDAO.addArticle(new Article("Primitives in Generics",
                "In the Bulgarian JUG we had an event dedicated to trying out the OpenJDK Valhalla project’s achievements in the area of using primitive parameters of generics. Our colleague and blogger Mihail Stoynov already wrote about our workshop. I decided, though, to go in a little bit more details and explain the various aspects of the feature.",
                johnSmith, LocalDate.of(2015, Month.MARCH, 6)));
        articleDAO.addArticle(new Article("Top antipatterns to inspire and motivate your team",
                "I tried to make a short review of  some of the best soft skills antipatterns that I have met. The idea is not about mocking or not only about it.  Such epic failures of the art of managing people should be considered very carefully because of their importance in the process of building capable development team or at least finding the right place to work and devote to.",
                paulaChester, LocalDate.of(2013, Month.MARCH, 16)));
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("=============================================");

        /* Add comments to one of the articles */
        entityManager = emf.createEntityManager();
        System.out.println("Add comment to an article:");
        entityManager.getTransaction().begin();
        CommentDAO commentDAO = new CommentDAO(new ArticleDAO(entityManager), entityManager);
        commentDAO.addCommentToArticle(article1.getId(), new Comment("Great job, everyone!",
                paulaChester, LocalDateTime.of(2016, Month.APRIL, 11, 12, 34)));
        commentDAO.addCommentToArticle(article1.getId(), new Comment("Thank you, Paula!",
                johnSmith, LocalDateTime.of(2016, Month.APRIL, 11, 14, 55)));
        entityManager.getTransaction().commit();
        entityManager.close();

        System.out.println("=============================================");

        /* List all articles */
        entityManager = emf.createEntityManager();
        articleDAO = new ArticleDAO(entityManager);
        System.out.println("All articles:");
        articleDAO.getAllArticles().forEach(System.out::println);
        entityManager.close();

        System.out.println("=============================================");

        /* Find article by ID */
        entityManager = emf.createEntityManager();
        articleDAO = new ArticleDAO(entityManager);
        System.out.println("Article with ID " + article1.getId() + ":");
        articleDAO.findArticleById(article1.getId()).ifPresent(MagazineManager::printArticleWithComments);
        entityManager.close();

        System.out.println("=============================================");

        /* Find all articles of author */
        entityManager = emf.createEntityManager();
        articleDAO = new ArticleDAO(entityManager);
        System.out.println("Article with author " + johnSmith.getUserName() + ":");
        articleDAO.findArticlesByAuthor(johnSmith).forEach(System.out::println);
        entityManager.close();

        System.out.println("=============================================");

        /* Find all articles of author */
        entityManager = emf.createEntityManager();
        articleDAO = new ArticleDAO(entityManager);
        System.out.println("Find non-existing article:");
        System.out.println("Article with ID 99999 present: " + articleDAO.findArticleById(99999L).isPresent());
        entityManager.close();

        emf.close();
    }

    private static void printArticleWithComments(Article a) {
        System.out.println(a);
        System.out.println(a.getComments());
    }

}
