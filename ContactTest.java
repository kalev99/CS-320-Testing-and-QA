/* 
 * Author: Caleb Baldwin
 * Created: 3/19/2026
 * Last Updated: 4/8/2026
 */

package tests;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import main.Contact;

class ContactTest {

	@Test
	void testValidContact() {
		Contact contact = new Contact("123456", "Caleb", "Baldwin", "9876543210", "111 Graduate St., SNHU");
		assertEquals(contact.getContactID(), "123456");
		assertEquals(contact.getFirstName(), "Caleb");
		assertEquals(contact.getLastName(), "Baldwin");
		assertEquals(contact.getPhoneNum(), "9876543210");
		assertEquals(contact.getAddress(), "111 Graduate St., SNHU");
	}
	
	@Test
	void testNullContactID() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Caleb", "Baldwin", "9876543210", "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testNullFirstName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", null, "Baldwin", "9876543210", "111 Graduate St., SNHU");
		});
	}

	@Test
	void testNullLastName() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Caleb", null, "9876543210", "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testNullPhone() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Caleb", "Baldwin", null, "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testNullAddress() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Caleb", "Baldwin", "9876543210", null);
		});
	}
	
	@Test
	void testIDTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678910", "Caleb", "Baldwin", "9876543210", "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testFirstNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "CalebCalebCaleb", "Baldwin", "9876543210", "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testLastNameTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Caleb", "BaldwinBaldwin", "9876543210", "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testAddressTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("123456", "Caleb", "Baldwin", "9876543210", "111 Graduate St., SNHU but then keep driving past it");
		});
	}
	
	@Test
	void testPhoneTooLong() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567891", "Caleb", "Baldwin", "98765432100", "111 Graduate St., SNHU");
		});
	}
	
	@Test
	void testPhoneTooShort() {
		assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567892", "Caleb", "Baldwin", "987654", "111 Graduate St., SNHU");
		});
	}
}
