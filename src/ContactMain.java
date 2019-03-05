//NAME: MARK GOLDSTEIN 
//HOMEWORK 2, 3130
// Worked With Mat
import java.util.*;
import java.io.*;
import java.util.LinkedList;
public class ContactMain {

	public static void main(String[] args) throws Exception {
				
		ContactList<Contact> list = new ContactList<>();
        list.add(new Contact("John", "Doe", "1239349111", "19 Elm Street", "Brooklyn", "New York"));
        list.add(new Contact("Jane", "Doe", "3645828763", "40 Washington Road", "Brooklyn", "New York"));
        list.add(new Contact("Sam", "Deere", "7458294021", "22 West Drive", "Albany", "New York"));
        list.add(new Contact("Jack    ", "Frost", "9853487444", "9 Opening Lane", "Albany", "New York"));
        list.add(new Contact("Mickey", "Leroy", "9273523003", "649 Siri Canal", "Grand Rapids", "Michigan"));
        System.out.println(list.searchLast("Doe"));
        System.out.println(list.searchPhone("9853487444"));
        System.out.println(list.searchLastFirstLetter('D'));
        System.out.println(list.searchCity("Albany"));
        System.out.println(list.add(new Contact("John", "Doe", "1239349111", "77 Fort Hilbert Avenue", "Albany", "New York")));
        System.out.println(list.size());
        System.out.println(list.remove(1));
        System.out.println(list.size());
        System.out.println(list.get(3));
        ContactList <Contact> temp = new ContactList<>();
        temp.add(new Contact("John", "Doe", "1239349111", "19 Elm Street", "Brooklyn", "New York"));
        temp.add(new Contact("Jane", "Doe", "3645828763", "40 Washington Road", "Brooklyn", "New York"));
        temp.add(new Contact("Sam", "Deere", "7458294021", "22 West Drive", "Albany", "New York"));
        temp.add(new Contact("Jack    ", "Frost", "9853487444", "9 Opening Lane", "Albany", "New York"));
        System.out.println(list.equals(temp));
        
//        for(Contact c: list) {
//        	System.out.println(c);
//        }
        
        System.out.println(list);
	}
}