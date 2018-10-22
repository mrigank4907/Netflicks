/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import entity.Movies;
import javax.persistence.Query;

@Named(value = "movies")
@RequestScoped
public class MoviesBean {

    //persistence for product
    @PersistenceContext(unitName = "Netflicks")
    private EntityManager em;
    @Resource
    private javax.transaction.UserTransaction usertrn;

    //attributes
    private String movieName;
    private int movieId;
    private int rating;
    private String description;
    private String review;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    public UserTransaction getUsertrn() {
        return usertrn;
    }

    public void setUsertrn(UserTransaction usertrn) {
        this.usertrn = usertrn;
    }

    public String getMovieName() {
        return movieName;
    }

    public void persist(Object object) {
        try {
            usertrn.begin();
            em.persist(object);
            usertrn.commit();
        } catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", e);
            throw new RuntimeException(e);
        }
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }
    //Method to get All movies

    public List<Movies> getAllMovies() {
        Query query = em.createNamedQuery("Movies.findAll");
        // return query result
        System.out.print(query.getResultList());
        return query.getResultList();

    }
}
