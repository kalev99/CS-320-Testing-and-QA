/* 
 * Author: Caleb Baldwin
 * Created: 3/19/2026
 * Updated: 4/8/2026
 */

package main;

import java.util.Map;
import java.util.HashMap;

public class ContactService {
	
	// Establish contact list in memory
	private Map<String, Contact> contactList = new HashMap<String, Contact>();
	private static ContactService instance = null;
	
	// Singleton instance of Contact Service
	public static ContactService getInstance() {
		if (instance == null) {
			instance = new ContactService();
		}
		return instance;
	}
	
	
	// Adds a new contact in memory
	public void addContact(String contactID, String firstName, String lastName, String phoneNum, String address) {
		
		// Create a new contact, ensuring the information is valid
		Contact newContact = new Contact(contactID, firstName, lastName, phoneNum, address);
		
		// If the contactID already exists, throw an error
		 if (contactList.containsKey(newContact.getContactID())) {
			 throw new IllegalArgumentException("A contact with that ID already exists.");
		 }
		 
		 // If no errors, add the contact to the list and print success
		 contactList.put(contactID, newContact);
	}
	
	// Removes a contact using the contactID
	public void deleteContact(String contactID) {
		
		// Throw error if contact was not found
		if (contactList.remove(contactID) == null) {
			throw new IllegalArgumentException("No contact with that ID exists.");
		}
	}
	
	// Updates a specified field in the contact
	public void updateField(String contactID, String field, String contents) {
		
		// Find contact to update
		Contact contact = contactList.get(contactID);
		
		// Throw error if contact was not found
		if (contact == null) {
			throw new IllegalArgumentException("No contact with ID " + contactID + " exists.");
		}
		
		// Attempt to update requested field with contents
		switch (field) {
		case "First name":
			contact.setFirstName(contents);
			break;
		case "Last name":
			contact.setLastName(contents);
			break;
		case "Phone number":
			contact.setPhoneNum(contents);
			break;
		case "Address":
			contact.setAddress(contents);
			break;
		// If invalid field entered somehow, show error
		default:
			throw new IllegalArgumentException("Invalid field.");
		}
	}
}
