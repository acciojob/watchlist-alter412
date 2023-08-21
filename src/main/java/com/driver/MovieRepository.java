package com.driver;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {

    HashMap<String,Movie> movie = new HashMap<>();

    HashMap<String,Director> director = new HashMap<>();

    HashMap<String, ArrayList<String>> pair = new HashMap<>();
    public void addMovie(Movie m) {
        if(!movie.containsKey(m.getName())){
            movie.put(m.getName(),m);
        }
    }

    public void addDirector(Director d) {
        if(!director.containsKey(d.getName())){
            director.put(d.getName(),d);
        }
    }

    public void addMovieDirectorPair(String movie, String director) {
        if(pair.containsKey(director)){
            ArrayList<String> temp = pair.get(director);
            if(!temp.contains(movie)){
                temp.add(movie);
            }
        }else{
            ArrayList<String> temp = new ArrayList<>();
            temp.add(movie);
            pair.put(director,temp);
        }
    }

    public Movie getMovieByName(String movie) {
        if(this.movie.containsKey(movie)){
            return this.movie.get(movie);
        }
        return null;
    }

    public Director getDirectorByName(String director) {
        if (this.director.containsKey((director))) {
            return this.director.get(director);
        }
        return null;
    }

    public List<String> getMoviesByDirectorName(String director) {
        if(pair.containsKey(director)){
            return pair.get(director);
        }
        return new ArrayList<>();
    }

    public List<String> findAllMovies() {
        List<String> l = new ArrayList<>();
        for(String s: movie.keySet()){
            l.add(s);
        }
        return l;
    }

    public void deleteDirectorByName(String director) {
        List<String> l=null ;
        if(pair.containsKey(director)){
            l=pair.get(director);
            pair.remove(director);
        }
        if(this.director.containsKey(director)){
            this.director.remove(director);
        }
        for(String s:l){
            if(movie.containsKey(s)){
                movie.remove(s);
            }
        }
    }

    public void deleteAllDirectors() {
        for(String s:pair.keySet()){
            deleteDirectorByName(s);
        }
        for(String s:director.keySet()){
            director.remove(s);
        }
    }
}
