/* 
 * Author: Caleb Baldwin
 * Created: 3/19/2026
 * Last Updated: 4/7/2026
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import main.ContactService;

class ContactServiceTest {
	// Instantiate singleton class
	static ContactService instance = ContactService.getInstance();
	
	// Add sample contacts for testing prior to test start
	@BeforeAll
	static void populateContactList() {
		instance.addContact("123456", "Caleb", "Baldwin", "9876543210", "111 Graduate St., SNHU");
		instance.addContact("Example", "Example", "Example", "0000000000", "Example Ave.");
		instance.addContact("Not Null", "Not Null", "Not Null", "Not Null 2", "Not Null");
	}
	
	@Test
	// Verify only one Contact Service exists in memory
	void testSingleton() {
		assertSame(instance, ContactService.getInstance());
	}
	
	@Test
	// Assert that adding a new record does not throw an error
	void testAddUniqueContactID() {
		assertDoesNotThrow(() -> {
			instance.addContact("HelloThere", "Obi-wan", "Kenobi", "9998887777", "191 Jedi Temple, Coruscant");
		});
	}
	
	@Test
	// Assert that adding a new record with an existing id throws an error
	void testAddDuplicateContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			instance.addContact("123456", "Thomas", "TankEngine", "1234567890", "A railyard, I think");
		});
	}

	@Test
	// Assert that deleting a valid record does not throw an error
	void testDeleteExistingContactID() {
		assertDoesNotThrow(() -> {
			instance.deleteContact("Example");
		});
	}
	
	@Test
	// Assert that deleting an invalid record throws an error
	void testDeleteInvalidContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			instance.deleteContact("007");
		});
	}

	@Test
	// Assert that updating the first name of a valid record does not throw an error
	void testUpdateFirstNameField() {
		assertDoesNotThrow(() -> {
			instance.updateField("Not Null", "First name", "Newbie");
		});
	}
	
	@Test
	// Assert that updating the last name of a valid record does not throw an error
	void testUpdateLastNameField() {
		assertDoesNotThrow(() -> {
			instance.updateField("Not Null", "Last name", "Person");
		});
	}
	
	@Test
	// Assert that updating the phone number of a valid record does not throw an error
	void testUpdatePhoneNumField() {
		assertDoesNotThrow(() -> {
			instance.updateField("Not Null", "Phone number", "0000000011");
		});
	}
	
	@Test
	// Assert that updating the address of a valid record does not throw an error
	void testUpdateAddressField() {
		assertDoesNotThrow(() -> {
			instance.updateField("Not Null", "Address", "0011 Newbie Rd.");
		});
	}
	
	@Test
	// Assert that updating an invalid contact throws an error
	void testUpdateInvalidContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			instance.updateField("Testing", "First name", "Testing");
		});
	}
	
	@Test
	// Assert that updating an invalid field throws an error
	void testInvalidField() {
		assertThrows(IllegalArgumentException.class, () -> {
			instance.updateField("123456", "Birthday", "Testing");
		});
	}

}
