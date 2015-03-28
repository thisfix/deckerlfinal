/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.common;

/**
 * The Enum MediaType.
 *
 * @author luke
 */
public enum MediaType {
    
    /** The dvd. */
    DVD("dvd"),
    
    /** The Bluray. */
    Bluray("bluray"),
    
    /** The cd. */
    CD("cd");

    /** The media type. */
    private String mediaType;

    /**
     * Instantiates a new media type.
     *
     * @param mediaType the media type
     */
    MediaType(final String mediaType) {
        this.mediaType = mediaType;
    }

    /**
     * Gets the media type.
     *
     * @return the mediaType
     */
    public String getMediaType() {
        return mediaType;
    }
     
}
