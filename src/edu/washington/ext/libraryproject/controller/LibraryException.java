package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.common.LibraryItem;


/**
 * The Class LibraryException.
 */
public class LibraryException extends Exception {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 2014;
	
	
	/** The item. */
	private LibraryItem item = null;

	
	/**
	 * Instantiates a new library exception.
	 *
	 * @param item the item
	 */
	public LibraryException(LibraryItem item){
		this.item = item;
	}
	
	
	/**
	 * Gets the item.
	 *
	 * @return the item
	 */
	public LibraryItem getItem(){
		return this.item;
	}

}
