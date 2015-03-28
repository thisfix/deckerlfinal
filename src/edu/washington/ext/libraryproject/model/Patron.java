/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.model;


/**
 * The Class Patron.
 *
 * @author luke
 */
public class Patron {
    
    /** The name. */
    private String name = null;
    
    /** The card number. */
    private int cardNumber = 0;

    /**
     * Instantiates a new patron.
     *
     * @param name the name
     * @param cardNumber the card number
     */
    public Patron(String name, int cardNumber) {
        this.name = name;
        this.cardNumber = cardNumber;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the card number.
     *
     * @return the cardNumber
     */
    public int getCardNumber() {
        return cardNumber;
    }


}
