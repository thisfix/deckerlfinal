import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import edu.washington.ext.libraryproject.controller.Library;
import edu.washington.ext.libraryproject.controller.LibraryException;
import edu.washington.ext.libraryproject.controller.PatronException;
import edu.washington.ext.libraryproject.controller.CheckInOutException;
import edu.washington.ext.libraryproject.common.Binding;
import edu.washington.ext.libraryproject.common.LibraryItem;
import edu.washington.ext.libraryproject.common.AbstractLibraryItem;
import edu.washington.ext.libraryproject.model.Book;
import edu.washington.ext.libraryproject.model.Patron;


/**
 * The Class LibraryTest.
 */
public class LibraryTest {
	
	/** The library. */
	private Library library;

	/**
	 * Sets the up.
	 *
	 * @throws Exception the exception
	 */
	@Before
	public void setUp() throws Exception {
		library = new Library("Southwest");
	}

	/**
	 * Test library.
	 */
	@Test
	public void testLibrary() {
		if (library.getClass().equals(Library.class)){
			//success
		} else {
			fail("The class type of the Library instance was not the same as the Library class");
		}
	}

	/**
	 * Test add.
	 */
	@Test
	public void testAdd() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}
		
	}

	/**
	 * Test remove.
	 */
	@Test
	public void testRemove() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}
		try {
			library.remove(item);
		} catch (LibraryException e) {
			fail("Could not remove an item to the library");
		}
	}

	/**
	 * Test add patron.
	 */
	@Test
	public void testAddPatron() {
		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
	}

	/**
	 * Test remove patron.
	 */
	@Test
	public void testRemovePatron() {
		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		try {
			Patron patron = library.findPatronByName("John Doe");
			int cardNumber = patron.getCardNumber();
			library.removePatron(cardNumber); 
		} catch  (PatronException e) {
			fail("Could not remove a patron to the library");
		}
	}

	/**
	 * Test checkout.
	 */
	@Test
	public void testCheckout() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}

		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
		try{
			library.checkout(item, library.findPatronByName("John Doe").getCardNumber());
		} catch (CheckInOutException e){
			fail("Could not checkout an item from the library");
		}
	}

	/**
	 * Test is checkout.
	 */
	@Test
	public void testIsCheckout() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}

		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
		try{
			library.checkout(item, library.findPatronByName("John Doe").getCardNumber());
		} catch (CheckInOutException e){
			fail("Could not checkout an item from the library");
		}
		
		try{
			library.isCheckout(item);
		} catch (CheckInOutException e){
			fail("Could not execute isCheckout() on the library");
		}
		
	}

	/**
	 * Test checkin.
	 */
	@Test
	public void testCheckin() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}

		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
		try{
			library.checkout(item, library.findPatronByName("John Doe").getCardNumber());
		} catch (CheckInOutException e){
			fail("Could not checkout an item from the library");
		}
		
		try{
			library.checkin(item);
		} catch (CheckInOutException e){
			fail("Could not checkin the item into the library");
		}
	}

	/**
	 * Test get library members.
	 */
	@Test
	public void testGetLibraryMembers() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}

		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
		try{
			library.checkout(item, library.findPatronByName("John Doe").getCardNumber());
		} catch (CheckInOutException e){
			fail("Could not checkout an item from the library");
		}
		
		Patron patron = library.findPatronByName("John Doe");
		assertEquals(library.getLibraryMembers().get(patron.getCardNumber()).getName(), "John Doe", 0);

	}

	/**
	 * Test get checked out items.
	 */
	@Test
	public void testGetCheckedOutItems() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}

		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
		try{
			library.checkout(item, library.findPatronByName("John Doe").getCardNumber());
		} catch (CheckInOutException e){
			fail("Could not checkout an item from the library");
		}
		
		library.getCheckedOutItems();
	}

	/**
	 * Test get list of all library items.
	 */
	@Test
	public void testGetListOfAllLibraryItems() {
		Book item = new Book("Dune", "Frank Herbert", "Chilton Books", new Date(0) , Binding.HARDCOVER, 412);
		try {
			library.add(item);
		} catch (LibraryException e) {
			fail("Could not add an item to the library");
		}

		try {
			library.addPatron("John Doe");
		} catch  (PatronException e) {
			fail("Could not add a patron to the library");
		}
		
		try{
			library.checkout(item, library.findPatronByName("John Doe").getCardNumber());
		} catch (CheckInOutException e){
			fail("Could not checkout an item from the library");
		}
		
		library.getListOfAllLibraryItems();
	}

}
