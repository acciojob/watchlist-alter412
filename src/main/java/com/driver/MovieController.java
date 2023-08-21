package com.driver;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    MovieService ms;

    @PostMapping("/add-movie")
    public ResponseEntity<String> addMovie(@RequestBody Movie m){
        ms.addMovie(m);
        return new ResponseEntity<>("Movie added successfully", HttpStatus.OK);
    }

    @PostMapping("/add-director")
    public ResponseEntity<String> addDirector(@RequestBody Director d){
        ms.addDirector(d);
        return new ResponseEntity<>("Director added successfully",HttpStatus.OK);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity<String> addMovieDirectorPair(@RequestParam("m") String movie,@RequestParam("d") String director){
        ms.addMovieDirectorPair(movie,director);
        return new ResponseEntity<>("Director and Movie paired successfully",HttpStatus.OK);
    }

    @GetMapping("/get-movie-by-name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable("name") String movie){
        Movie m = ms.getMovieByName(movie);
        return new ResponseEntity<>(m,HttpStatus.OK);
    }

    @GetMapping("/get-director-by-name/{name}")
    public ResponseEntity<Director> getDirectorByName(@PathVariable("name") String director){
        Director d = ms.getDirectorByName(director);
        return new ResponseEntity<>(d,HttpStatus.OK);
    }

    @GetMapping("/get-movies-by-director-name/{director}")
    public ResponseEntity<List<String>> getMoviesByDirectorName(@PathVariable("director") String director){
        List<String> l = ms.getMoviesByDirectorName(director);
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    @GetMapping("/get-all-movies")
    public ResponseEntity<List<String>> findAllMovies(){
        List<String> l = ms.findAllMovies();
        return new ResponseEntity<>(l,HttpStatus.OK);
    }

    @DeleteMapping("/delete-director-by-name")
    public ResponseEntity<String> deleteDirectorByName(@RequestParam("d") String director){
        ms.deleteDirectorByName(director);
        return new ResponseEntity<>("Director Records deleted successfully",HttpStatus.OK);
    }

    @DeleteMapping("/delete-all-directors")
    public ResponseEntity<String> deleteAllDirectors(){
        ms.deleteAllDirectors();
        return new ResponseEntity<>("All Directors records deleted successfully",HttpStatus.OK);
    }
}
