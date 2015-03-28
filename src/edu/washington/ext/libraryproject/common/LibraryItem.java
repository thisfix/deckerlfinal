/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package edu.washington.ext.libraryproject.common;

import edu.washington.ext.libraryproject.model.Patron;
import java.util.Date;


/**
 * The Interface LibraryItem.
 *
 * @author luke
 */
public interface LibraryItem {

    /**
     * Gets the author.
     *
     * @return the author
     */
    String getAuthor();

    /**
     * Gets the checked out patron.
     *
     * @return the checkedOut
     */
    Patron getCheckedOutPatron();

    /**
     * Gets the published date.
     *
     * @return the publishedDate
     */
    Date getPublishedDate();

    /**
     * Gets the publisher.
     *
     * @return the publisher
     */
    String getPublisher();

    /**
     * Gets the title.
     *
     * @return the title
     */
    String getTitle();

    /**
     * Sets the checked out.
     *
     * @param checkedOut the checkedOut to set
     */
    void setCheckedOut(Patron checkedOut);

}
