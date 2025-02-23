package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Model.Movie;

import java.util.List;

public interface MovieServiceInterface {
    public void createMovie(Movie move);
    public List<Movie> getAllMovies();
    public Movie getMovieById(String id);
    public void deleteMovieById(String id);
    public void updateMovieById(String id,Movie movie);

}
