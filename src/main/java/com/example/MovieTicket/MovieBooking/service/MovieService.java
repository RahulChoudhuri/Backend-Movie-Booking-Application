package com.example.MovieTicket.MovieBooking.service;

import com.example.MovieTicket.MovieBooking.Exceptions.IdAlreadyExist;
import com.example.MovieTicket.MovieBooking.Exceptions.IdNotFound;
import com.example.MovieTicket.MovieBooking.Model.Movie;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class MovieService implements MovieServiceInterface{
    List<Movie> movieList =new ArrayList<>();
    Map<String,Movie> movieMap =new HashMap<>();
    @Override
    public void createMovie(Movie newMovie) {
        if(movieMap.containsKey(newMovie.getId())){
            throw new IdAlreadyExist("This id already exist !!!"+newMovie.getId());
        }
        movieList.add(newMovie);
        movieMap.put(newMovie.getId(),newMovie);
    }

    public List<Movie> getAllMovies(){

        return this.movieList;    }

    @Override
    public Movie getMovieById(String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFound("invalid id !!! "+id);
        }
        return movieMap.get(id);
    }

    @Override
    public void deleteMovieById(String id) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFound("invalid id !!! "+id);
        }
        Movie movie = getMovieById(id);
        movieList.remove(movie);
        movieMap.remove(id);
    }

    @Override
    public void updateMovieById(String id, Movie movie) {
        if(ObjectUtils.isEmpty(movieMap.get(id))){
            throw new IdNotFound("invalid id !!! "+id);
        }
        Movie existingMovie = getMovieById(id);
        movieList.remove(existingMovie);
        movieList.add(movie);
        movieMap.put(id,movie);
    }
}
