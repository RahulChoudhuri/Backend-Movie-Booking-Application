package com.example.MovieTicket.MovieBooking.controller;

import com.example.MovieTicket.MovieBooking.Model.Movie;
import com.example.MovieTicket.MovieBooking.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ticket")
public class Controller {

    @Autowired
    MovieService movieService;

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieService.getAllMovies();
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieInfoById(@PathVariable String id){
        return movieService.getMovieById(id);
    }


    @PostMapping("/movie")
    public void addMovieInfo(@Valid @RequestBody Movie movie, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            throw new RuntimeException("Request not valid");

        }
        movieService.createMovie(movie);
    }

    @DeleteMapping("/movie/{id}")
    public void deleteMovieById(@PathVariable String id){
        movieService.deleteMovieById(id);
    }

    @PutMapping("/update/{id}")
    public void updateMovieById(@PathVariable String id,@RequestBody Movie movie){
        movieService.updateMovieById(id,movie);
    }

}
