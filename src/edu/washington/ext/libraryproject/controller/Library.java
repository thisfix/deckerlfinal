package edu.washington.ext.libraryproject.controller;

import edu.washington.ext.libraryproject.common.LibraryItem;
import edu.washington.ext.libraryproject.model.Patron;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map; 
import java.util.Random;

// <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
// #[regen=yes,id=DCE.2FEFDCA2-EC7B-D0BE-1272-223B5E6BD078]
// </editor-fold>

/**
 * The Class Library.
 */
public class Library {

    /** The items. */
    private List<LibraryItem> items = null; //list of items,
    
    /** The patrons. */
    private Map<Integer, Patron> patrons = null; //hashmap of patrons where key is their library number
    
    /** The checked out items. */
    private Map<Integer, LibraryItem> checkedOutItems = null; //map of checkedoutitems where the key is the patron's number
    
    /** The branch. */
    private String branch = null;

    // <editor-fold defaultstate="collapsed" desc=" UML Marker "> 
    // #[regen=yes,id=DCE.BB0EE4F5-FAE9-F758-28D3-AD613B04A35C]
    // </editor-fold>
    
    /**
     * Instantiates a new library.
     *
     * @param branch the branch
     */
    public Library (String branch) {
    	this.branch = branch;
    }

    /**
     * Adds the.
     *
     * @param item the item
     * @throws LibraryException the library exception
     */
    public void add(LibraryItem item) throws LibraryException { 
    	//allows adding library items such as Videos, Music, and Books to the library stock
		if (item == null){
			throw new IllegalArgumentException("Arguement must not be null");
		} else {
			if (items == null){
				items = new ArrayList<LibraryItem>();
			} else {
				for (int i=0; i<items.size(); i++){
					if (item == items.get(i)){
						throw new LibraryException(item);
					}
				}
			}
		}
		items.add(item);

    }

    /**
     * Removes the.
     *
     * @param item the item
     * @throws LibraryException the library exception
     */
    public void remove(LibraryItem item) throws LibraryException {
    	//remove method removes the library item contained in the library stock. 
    	//	If it cannot remove item then it throws a LibraryException on why and 
    	//	contains the LibraryItem that failed.
    	boolean found = false;
    	int indexOfItemToRemove = -1;
		if (item == null){
			throw new IllegalArgumentException("Arguement must not be null");
		} else {
			for (int i=0; i<items.size(); i++){
				if (item == items.get(i)){
					found = true;
					indexOfItemToRemove = i;
				}
			}
		}
		if (found){
			items.remove(indexOfItemToRemove);
		} else {
			throw new LibraryException(item);
		}
    }
    
    /**
     * Find patron by name.
     *
     * @param name the name
     * @return the patron
     */
    public Patron findPatronByName(String name){
    	Map<Integer, Patron> map = new HashMap<Integer, Patron>();
    	Iterator<Map.Entry<Integer, Patron>> entries = map.entrySet().iterator();
    	while (entries.hasNext()) {
    	    Map.Entry<Integer, Patron> entry = entries.next();
    		Integer key = entry.getKey();
    		Patron value = entry.getValue();
    		if (value.getName() == name){
    			return patrons.get(key);
    		}
    	}

    	return null;
    }


    /**
     * Adds new patrons and returns library number.
     *
     * @param name of patron
     * @return library card number
     * @throws PatronException the patron exception
     */
    public int addPatron(String name) throws PatronException {
    	//addPatron adds a new patron to the library, it is stored in a Map where 
    	//	the key is the library number that is generated and associated to the 
    	//	Patron object. If there is a duplicate name it throws a PatronException that 
    	//	contains the patron object that is defined in library as well as the name 
    	//	that is being tried to add.
    	int patronID;
		if (name == null){
			throw new IllegalArgumentException("Arguement must not be null");
		} else {
			if (patrons ==null){
				patrons = new HashMap<Integer, Patron>();
			} 
			Patron patron = findPatronByName(name);
			if (patron != null){
				throw new PatronException(patron);
			} else {
				patronID = generateUniqueNumber();
				patrons.put(patronID, new Patron(name, patronID));
			}
		}

        return patronID;
    }
    
    /**
     * Generate unique number.
     *
     * @return the int
     */
    private int generateUniqueNumber(){
    	int randomNumber = randInt(0,999999999);
    	if (!patrons.containsKey(randomNumber)){
    		
    	} else {
    		randomNumber = generateUniqueNumber();
    	}
		return randomNumber;
    }
    
    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
    
    /**
     * Removes the patron.
     *
     * @param libraryCardNumber the library card number
     * @return true, if successful
     * @throws PatronException the patron exception
     */
    public boolean removePatron(int libraryCardNumber) throws PatronException {
    	//removePatron method removes the patron based on the library number. 
    	//	It returns true if successful and false if not, meaning that it was not found.
		if (libraryCardNumber < 0){
			throw new IllegalArgumentException("Arguement must not be less than zero");
		} else {
			if (patrons.containsKey(libraryCardNumber)){
				patrons.remove(libraryCardNumber);
				return true;
			} else {
				return false;
			}
		}
    }


    /**
     * Checkout.
     *
     * @param item the item
     * @param libraryCardNumber the library card number
     * @throws CheckInOutException the check in out exception
     */
    public void checkout(LibraryItem item, int libraryCardNumber) throws CheckInOutException {
    	//checkout method checks out a library item based on the patron's card number. 
    	//	If fails, then throws an CheckInOutException and contains the library item and 
    	//	card number along with the reason for failing like item does not exits or patron 
    	//	does not exist.
    	if (libraryCardNumber<0 || item==null){
    		throw new IllegalArgumentException("Arguements must not be less than zero or null");
    	} else {
    		if (!patrons.containsKey(libraryCardNumber)){
    			throw new CheckInOutException(item, libraryCardNumber, "patron doesn't exist");
    		} else if (!items.contains(item)){
    			throw new CheckInOutException(item, libraryCardNumber, "item doesn't exist");
    		} else {
    			item.setCheckedOut(patrons.get(libraryCardNumber));
    			checkedOutItems.put(libraryCardNumber, item);
    		}
    	}

    }

    /**
     * Checks if is checkout.
     *
     * @param item the item
     * @return true, if is checkout
     * @throws CheckInOutException the check in out exception
     */
    public boolean isCheckout(LibraryItem item) throws CheckInOutException {
    	//isCheckout method does what you would think, it validates whether it is checked out 
    	//	or not. If the the item does not exist throw CheckInOutException with the library 
    	//	item and why failed.
    	if (checkedOutItems.containsValue(item)){
    		return true;
    	} else {
    		if (items.contains(item)){
    			return false;
    		} else {
    			throw new CheckInOutException(item, -1, "item doesn't exist");
    		}
    	}
    }

    /**
     * Checkin.
     *
     * @param item the item
     * @throws CheckInOutException the check in out exception
     */
    public void checkin(LibraryItem item) throws CheckInOutException {
    	//checkin method resets the library item so accessible to others to check out. 
    	//	If errors like item does not exist or item is not checkout, throw an 
    	//	CheckInOutException with the item and reason for error.
    	if (isCheckout(item)){
    		checkedOutItems.remove(item); // the assignment description above doesn't account for the multiple copies of the same item - might be a future enhancement
    	} else {
    		throw new CheckInOutException(item, -1, "item is not checked out");
    	}
    }

    /**
     * Gets the library members.
     *
     * @return the library members
     */
    public Map<Integer, Patron> getLibraryMembers() {
        return patrons;
    }

    /**
     * Gets the checked out items.
     *
     * @return the checked out items
     */
    public Map<Integer, LibraryItem> getCheckedOutItems() {
        return checkedOutItems;
    }

    /**
     * Gets the list of all library items.
     *
     * @return the list of all library items
     */
    public List<LibraryItem> getListOfAllLibraryItems() {
        return items;
    }
}

