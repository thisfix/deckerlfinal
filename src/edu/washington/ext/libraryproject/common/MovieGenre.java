/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.common;


/**
 * The Enum MovieGenre.
 *
 * @author luke
 */
public enum MovieGenre {
	
    /** The action. */
    ACTION("action"), 
    
    /** The adventure. */
    ADVENTURE("adventure"), 
    
    /** The comedy. */
    COMEDY("comedy"), 
    
    /** The crime. */
    CRIME("crime"), 
    
    /** The documentary. */
    DOCUMENTARY("documentary"), 
    
    /** The drama. */
    DRAMA("drama"), 
    
    /** The family. */
    FAMILY("family");
    
    /** The movie genre type. */
    private String movieGenreType;


    /**
     * Instantiates a new movie genre.
     *
     * @param movieGenreType the movie genre type
     */
    MovieGenre(final String movieGenreType) {
        this.movieGenreType = movieGenreType;
    }

    /**
     * Gets the movie genre type.
     *
     * @return the movie genre type
     */
    public String getMovieGenreType() {
        return movieGenreType;
    }
}
