/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.model.Patron;


/**
 * The Class PatronException.
 *
 * @author luke
 */
public class PatronException extends Exception {
    
    /** The patron. */
    private Patron patron;

    /**
     * Instantiates a new patron exception.
     *
     * @param patron the patron
     */
    public PatronException(Patron patron) {
        this.patron = patron;
    }
}
