/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.common.LibraryItem;
import edu.washington.ext.libraryproject.model.Patron;

/**
 * The Class CheckInOutException.
 *
 * @author luke
 */
public class CheckInOutException extends Exception {
    
    /** The item. */
    private LibraryItem item;
    
    /** The library card number. */
    private int libraryCardNumber;
    
    /** The description. */
    private String description;

    /**
     * Instantiates a new check in out exception.
     *
     * @param item the item
     * @param libraryCardNumber the library card number
     * @param description the description
     */
    public CheckInOutException(LibraryItem item, int libraryCardNumber, String description) {
        this.item = item;
        this.libraryCardNumber = libraryCardNumber;
        this.description = description;
    }
}
