/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.common;


/**
 * The Enum MusicGenre.
 *
 * @author luke
 */
public enum MusicGenre {
	
    /** The pop. */
    POP("pop"), 
    
    /** The dance. */
    DANCE("dance"), 
    
    /** The hiphop. */
    HIPHOP("hiphop"), 
    
    /** The rap. */
    RAP("rap"), 
    
    /** The rock. */
    ROCK("rock"), 
    
    /** The alternative. */
    ALTERNATIVE("alternative"), 
    
    /** The hardrock. */
    HARDROCK("hardrock"), 
    
    /** The folk. */
    FOLK("folk"), 
    
    /** The country. */
    COUNTRY("country");
    
    /** The music genre type. */
    private String musicGenreType;


    /**
     * Instantiates a new music genre.
     *
     * @param musicGenreType the music genre type
     */
    MusicGenre(final String musicGenreType) {
        this.musicGenreType = musicGenreType;
    }

    /**
     * Gets the music genre type.
     *
     * @return the music genre type
     */
    public String getMusicGenreType() {
        return musicGenreType;
    }
}
