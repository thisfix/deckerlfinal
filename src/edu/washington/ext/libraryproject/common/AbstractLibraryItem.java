package edu.washington.ext.libraryproject.common;

//import edu.washington.ext.libraryproject.model.*;
import edu.washington.ext.libraryproject.model.Patron;
import java.util.Date; 

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.FD6EFDA1-D715-94D9-AF44-FEC5DE2F02F3]
// </editor-fold> 

/**
 * The Class AbstractLibraryItem.
 */
public abstract class AbstractLibraryItem implements LibraryItem {
    
    /** The title. */
    private String title;
    
    /** The published date. */
    private Date   publishedDate;
    
    /** The author. */
    private String author;
    
    /** The publisher. */
    private String publisher;
    
    /** The checked out. */
    private Patron checkedOut;

//        super((String title, String author, String publisher, Date publishedDate);

    /**
 * Instantiates a new abstract library item.
 *
 * @param title the title
 * @param author the author
 * @param publisher the publisher
 * @param publishedDate the published date
 */
public AbstractLibraryItem(String title, String author, String publisher,
            Date publishedDate) {
        this.title = title;
        this.publishedDate = publishedDate;
        this.author = author;
        this.publisher = publisher;
    }



    /**
     * Gets the title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the published date.
     *
     * @return the publishedDate
     */
    public Date getPublishedDate() {
        return publishedDate;
    }

    /**
     * Gets the author.
     *
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Gets the publisher.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Gets the checked out patron.
     *
     * @return the checkedOut
     */
    public Patron getCheckedOutPatron() {
        return checkedOut;
    }

    /**
     * Sets the checked out.
     *
     * @param checkedOut the checkedOut to set
     */
    public void setCheckedOut(Patron checkedOut) {
        this.checkedOut = checkedOut;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return super.toString();
    }



}

