//NAME: MARK GOLDSTEIN 
//HOMEWORK 1, 3130
public class Contact implements Comparable  <Contact> {
	private String first;
	private String last;
	private String phoneNum;
	private String address;
	private String city;
	private String state;

	//Constructor with all fields initialized
	public Contact(String first, String last, String phoneNum,
			String address, String city, String state) {
		this.first = first;
		this.last = last;
		this.phoneNum = phoneNum;
		this.address = address;
		this.city = city;
		this.state = state;
	}  

	//Constructor for Contact that only has a name and phone number
	public Contact(String first, String last, String phoneNum) {
		this.first = first;
		this.last = last;
		this.phoneNum = phoneNum;
	}

	/**
	 * updateContact method allows the user to update all the
	 * information on a contact.
	 * @param first 
	 * @param last
	 * @param phoneNum
	 * @param address
	 * @param city
	 * @param state
	 */
	public void updateContact(String first, String last, String phoneNum,
			String address, String city, String state) {
		this.first = first;
		this.last = last;
		this.phoneNum = phoneNum;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	public void updateContact(String first, String last, String phoneNum ) {
		this.first = first;
		this.last = last;
		this.phoneNum = phoneNum;
	}

	//Returns full name as a string
	public String getFullName() {
		return first + " " + last;
	}

	//Returns a print-friendly, formatted, string 
	public String toString() {
		if(this.address !=null){
			return String.format("%-8s %-10s Phone Number:"
					+ "(%s)-%s-%s %n%-10s%n%-8s, %-10s %n" , this.first, 
					this.last, this.phoneNum.substring(0,3),this.phoneNum.substring(3,6), 
					this.phoneNum.substring(6,10),this.address, this.city, this.state);
		}else{
			return String.format("%-8s %-10s Phone Number:(%s)-%s-%s", this.first, 
					this.last, this.phoneNum.substring(0,3),this.phoneNum.substring(3,6), 
					this.phoneNum.substring(6,10));
		}

	}

	//Returns true if the first and last name are equal (ignoring case)
	// Check if its the same type using instanceof
	public boolean equals(Object c) {
		if( ! (c instanceof Contact))
			return false;
		// We are creating a ref var "con" of contact type that is equal to the address of object c being sent in.
		// We cast it down, because once we get past the instanceof boolean we know that the Object is actually a Contact
		// Now we just need to remind the Object c that it is an Contact and then with the Contact var "con" we can simply use 
		// the compareTo of Contact on con, to compare it to the object that is being sent in.
		Contact con = (Contact) c;
		return con.compareTo(this) == 0;

	}

	/* compareTo() Method compares the contact object name lexicographically
	 * @param Contact object
	 * Output: integer signaling if this object's last name is lexicographically smaller ,
	 * larger or equal to the contact object being sent for comparison.
	 * Positive IF:the last name of the "other" contact is lexicographically first, returns the 
	 * positive value returned from the string compareTo method.
	 * Negative IF: the last name of the "other" contact is lexicographically second, returns the 
	 * negative value returned from the string compareTo method.
	 * ZERO IF: the fist and last name are the same.
	 * Uses first name IF: the last name of a contact is the same but the first name is different,
	 * uses the first name of each object to to determine the order.
	 */
	public int compareTo(Contact o) {  
		int lexValLast = this.last.compareTo(o.getLast()), 
				lexValFirst = this.first.compareTo(o.getFirst());
		if(lexValLast != 0) {
			return lexValLast; //If there's a difference in the last name returns that value
		} 
		if(lexValFirst !=0) { 
			return lexValFirst; // Send back the difference of their first name, since they share a last name
		}	
		return lexValFirst;
	}

	public String getFirst() {
		return first;
	}

	public String getLast() {
		return last;
	}

	public String getPhoneNum() {
		return phoneNum;
	}
	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}


}
