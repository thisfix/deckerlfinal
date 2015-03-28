package edu.washington.ext.libraryproject.model;

import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import edu.washington.ext.libraryproject.common.MediaType;
import edu.washington.ext.libraryproject.common.MovieGenre;

import java.util.Date;


/**
 * The Class Video.
 */
public class Video extends AbstractLibraryItem {
    
    /** The media type. */
    private MediaType mediaType = null;
    
    /** The genre. */
    private MovieGenre genre = null;
    
    /** The director. */
    private String director = null;
    
    /** The producer. */
    private String producer = null;
    
    /**
     * Instantiates a new video.
     *
     * @param title the title
     * @param author the author
     * @param publisher the publisher
     * @param publishedDate the published date
     * @param mediaType the media type
     * @param director the director
     * @param producer the producer
     * @param genre the genre
     */
    public Video(String title, String author, 
                 String publisher, Date publishedDate,
                 MediaType mediaType,
                 String director, String producer,
                 MovieGenre genre) {
        super(title, author, publisher, publishedDate);
        this.director = director;
        this.producer = producer;
        this.mediaType = mediaType;
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
     * Gets the genre.
     *
     * @return the genre
     */
    public MovieGenre getGenre() {
        return genre;
    }

    /**
     * Gets the director.
     *
     * @return the director
     */
    public String getDirector() {
        return director;
    }

    /**
     * Sets the director.
     *
     * @param director the director to set
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Gets the producer.
     *
     * @return the producer
     */
    public String getProducer() {
        return producer;
    }
}

