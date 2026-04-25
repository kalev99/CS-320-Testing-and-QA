/* 
 * Author: Caleb Baldwin
 * Created: 3/19/2026
 * Updated: 4/8/2026
 */

package main;

import utility.StringTools;

public class Contact {
	
	// Establish variables
	private final String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	// Constructor
	public Contact(String contactID, String firstName, String lastName, String phone, String address) {
		
		// Validate each variable before setting
		StringTools.validateString("Contact ID", contactID, 10, false);
		StringTools.validateString("First name", firstName, 10, false);
		StringTools.validateString("Last name", lastName, 10, false);
		StringTools.validateString("Phone number", phone, 10, true);
		StringTools.validateString("Address", address, 30, false);
		
		// After passing validations, set variables
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	
	
	// Simple getter methods for all variables
	public String getContactID() { return contactID; }
	
	public String getFirstName() { return firstName; }
	
	public String getLastName() { return lastName; }
	
	public String getPhoneNum() { return phone; }
	
	public String getAddress() { return address; }
	
	
	// Setter methods for updating changeable variables
	// Calls validation helper before changing values
	public void setFirstName(String firstName) {
		StringTools.validateString("First Name", firstName, 10, false);
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		StringTools.validateString("Last name", lastName, 10, false);
		this.lastName = lastName;
	}
	
	public void setPhoneNum(String phone) {
		StringTools.validateString("Phone number", phone, 10, true);
		this.phone = phone;
	}
	
	public void setAddress(String address) {
		StringTools.validateString("Address", address, 30, false);
		this.address = address;
	}
}
