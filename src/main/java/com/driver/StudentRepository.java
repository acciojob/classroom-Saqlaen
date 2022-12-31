package com.driver;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

@Repository
public class StudentRepository {
    
    private HashMap<String,Student> moviemap = new HashMap<>();
    private HashMap<String,Teacher> dirmap = new HashMap<>();
    private HashMap<String, List<String> > pair = new HashMap<>();

    public String addMovieRepo(Student m ){
        System.out.println( m.toString() );
        String name = m.getName();
        moviemap.put( name, m );
        return "success";
    }

    public String addDirRepo(Teacher d){
        System.out.println( d.toString() );
        String name = d.getName();
        dirmap.put( name , d );
        return "success";
    }
    
    public String addPairRepo( String movieName, String directorName ){
        List<String> li = null;
        if( moviemap.containsKey( movieName ) && dirmap.containsKey( directorName ) ){    
            if( pair.containsKey( directorName) ){
                li = pair.get(directorName);
                li.add( movieName );
                pair.put( directorName, li );
            }
            else{
                li = new ArrayList<>();
                li.add(movieName);
                pair.put(directorName, li);
            }
        }

        return "success";
    }
    
    public Student getMovieRepo(String name ){
        if( moviemap.containsKey(name)){
            return moviemap.get(name);
        }
        return null;
    }

    public Teacher getDirectorRepo( String name ){
        if( dirmap.containsKey(name)){
            return dirmap.get(name);
        }
        return null;
    }

    public List<String> getMovieList( String directorName ){
        if( pair.containsKey(directorName) ){
            return pair.get( directorName );
        }
        return new LinkedList<>();
    }

    public List<String> getAllMovieRepo(){
        List<String> movieList  = new LinkedList<>();
        for( String str : moviemap.keySet() ){
            movieList.add( str );
        }
        return movieList;
    }

    public String deleteDirWorkRepo(String name ){
        // get dir movies 
        if( pair.containsKey(name) ){
            List<String> dirMovies = pair.get(name);
            pair.remove(name);
            dirmap.remove( name );
            for( String m : dirMovies ){
                if( moviemap.containsKey( m ) ){
                    moviemap.remove( m );
                }
            }
        }
        // remove dir from the pair
        // remove dir from hashmap
        // remove all movies of dir from moviemap 
        return "success";
    }

    public String deleteAllMovieRelatedToDirector(){
        for( Map.Entry< String, List<String> > entry : pair.entrySet() ){
            String dirName = entry.getKey();
            List<String> list = entry.getValue();
            for( String name : list  ){
                if( moviemap.containsKey( name ) ){
                    moviemap.remove( name );
                }
            }
            pair.remove( dirName );
            if( dirmap.containsKey(dirName)){
                dirmap.remove( dirName );
            }
        }
        return "success";
    }
}
