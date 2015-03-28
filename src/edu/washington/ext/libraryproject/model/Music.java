package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import edu.washington.ext.libraryproject.common.MediaType;
import edu.washington.ext.libraryproject.common.MusicGenre;

import java.util.Date;




/**
 * The Class Music.
 */
public class Music extends AbstractLibraryItem  {
    
    /** The media type. */
    private MediaType mediaType = null;
    
    /** The artist. */
    private String artist = null;
    
    /** The genre. */
    private MusicGenre genre = null;

    /**
     * Instantiates a new music.
     *
     * @param title the title
     * @param author the author
     * @param publisher the publisher
     * @param publishedDate the published date
     * @param mediaType the media type
     * @param artist the artist
     * @param genre the genre
     */
    public Music(String title, String author, String publisher,
                 Date publishedDate, MediaType mediaType,
                 String artist, MusicGenre genre) {
        super(title, author, publisher, publishedDate);
        this.mediaType = mediaType;
        this.artist = artist;
        this.genre = genre;
    }

    /**
     * Gets the media type.
     *
     * @return the mediaType
     */
    public MediaType getMediaType() {
        return mediaType;
    }

    /**
     * Gets the artist.
     *
     * @return the artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Gets the genre.
     *
     * @return the genre
     */
    public MusicGenre getGenre() {
        return genre;
    }
    
}

