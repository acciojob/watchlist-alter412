package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository mr;
    public void addMovie(Movie m) {
        mr.addMovie(m);
    }

    public void addDirector(Director d) {
        mr.addDirector(d);
    }

    public void addMovieDirectorPair(String movie, String director) {
        mr.addMovieDirectorPair(movie,director);
    }

    public Movie getMovieByName(String movie) {
        return mr.getMovieByName(movie);
    }

    public Director getDirectorByName(String director) {
        return mr.getDirectorByName(director);
    }

    public List<String> getMoviesByDirectorName(String director) {
        return mr.getMoviesByDirectorName(director);
    }

    public List<String> findAllMovies() {
        return mr.findAllMovies();
    }

    public void deleteDirectorByName(String director) {
        mr.deleteDirectorByName(director);
    }

    public void deleteAllDirectors() {
        mr.deleteAllDirectors();
    }
}
