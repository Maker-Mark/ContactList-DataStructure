import java.util.*;
import java.io.*;
/* TODO:
   -need and array

 */
public class ContactList<E> implements List<Contact> {

	private Contact[] arr;
	private int numElem; // static makes things oblivious
	// a private class that the user does not know about!

	private class ContactListIterator implements Iterator<Contact>{

		private int index;
		public ContactListIterator(){
			index = 0;
		}
		public boolean hasNext(){
			return index < numElem;
		}
		public Contact next(){
			index++;
			return get(index-1);  
		}
		public void remove(){
			//optional, call remove on index-1
			ContactList.this.remove(index-1);
			// go to my outer scope and remove
		}
	}

	public ContactList(){
		numElem=0;
		// Casting happens at runtime 
		// Trying to downcast, but we need a work around
		arr =  new Contact[20];// Making a default size  
		// Unlike runtime JAVA does not know  what type E is
	}

	public ContactList(Contact[] array){
		this.arr = array;
		this.numElem = arr.length;

	}


	/**
	 * - A method that searches for a particular contact by last name, and returns a reference
	 * to the Contact. If there is no such Contact, a sentinel value should be returned.
	 */

	public Contact searchLast(String last) {
		for(int i=0;i<numElem;i++) 
			if(arr[i].getLast().equals(last))
				return arr[i];
		return null;
	}
	/**
	 * - A method that searches for a Contact by phone number, and returns a reference to the
	 * Contact. If there is no such Contact, a sentinel value should be returned.
	 * @param phone
	 * @return
	 */

	public Contact searchPhone(String phone) {
		for(int i=0; i<numElem;i++)
			if(arr[i].getPhoneNum().equals(phone))
				return arr[i];
		return null;
	}

	/**
	 * 	- A function that searches for and returns a ContactList containing all Contacts with a
	 * last name starting with a particular letter. If there are no such Contacts, you should
	 * return the empty ContactList.
	 */
	public ContactList<Contact> searchLastFirstLetter(char c){
		ContactList<Contact> listL = new ContactList<>();
		for(int i=0;i<numElem;i++)
			if(arr[i].getLast().charAt(0) == c)
				listL.add(arr[i]);
		return listL;
	}

	/**
	 * 	- A method that searches for and returns a ContactList containing all Contacts that live
	in a particular city. If there are no such Contacts, you should return the empty
	ContactList.
	 */

	public ContactList<Contact> searchCity(String city){
		ContactList<Contact> cList = new ContactList<>();
		for(int i=0; i<numElem;i++)
			if(arr[i].getCity().equals(city))
				cList.add(arr[i]);
		return cList;
	}

	public boolean add(Contact e){
		if(numElem>0) {
			for(int i=0; i<numElem; i++)
				if(arr[i].equals(e))
					return false;
			if(numElem == arr.length)
				grow();	
			arr[numElem] = e;
		}else 
			arr[numElem]=e;
		numElem++;
		return true;

	}

	public void add(int index, Contact element) {
		if( index >= numElem || index <0)
			throw new IndexOutOfBoundsException();
		boolean valid = true;
		for(Contact c: arr)
			if(c.equals(c))
				valid=false;
		if(valid) {
			if(numElem ==arr.length) 
				grow();
			for(int i= numElem-1; i>= index; i--) 
				arr[i+1]=arr[i];
			arr[index] = element;
			numElem++;
		}
	}

	private void grow(){
		Contact[] temp = new Contact[2*arr.length];
		for(int i = 0; i<arr.length;i++)
			temp[i] = arr[i];
		arr = temp;
	}

	public int size(){
		return numElem;
	}

	public boolean isEmpty(){
		return numElem == 0;
	}

	public boolean remove(Object obj){
		int index = indexOf(obj);
		if(index ==-1)
			return false;
		remove(index);
		return true;
	}

	public Contact remove(int index){
		if( index >= numElem || index <0)
			throw new IndexOutOfBoundsException();
		Contact value = arr[index];
		for(int i = index+1; i<numElem; i++)
			arr[i-1] = arr[i];
		numElem--;
		return value;
	}

	public Contact get(int index ) {
		if( index >= numElem || index <0)
			throw new IndexOutOfBoundsException();
		return arr[index];
	}

	public Contact set(int index, Contact value) {
		if( index >= numElem || index <0)
			throw new IndexOutOfBoundsException();
		Contact old = arr[index];
		arr[index] = value;
		return old;
	}

	public void clear (){
		numElem = 0;
	}

	public boolean contains(Object obj) {
		// uses indexof, if its not negative 1, the {
		return indexOf(obj)!=-1;
	}

	public int indexOf(Object obj){
		for(int i=0; i<numElem;i++)
			if(arr[i].equals(obj))
				return i;
		return -1;
	}

	// Review me
	public String toString(){
		StringBuilder result = new StringBuilder();
		// can use string builder
		for(int i=0; i<numElem;i++)
			result.append(arr[i] +"\n");
		return result.toString();
	}

	public boolean addAll(Collection<? extends Contact> c) {
		if(c.size()==0) return false;
		for(Contact con: c) 
			add(con);
		return true;
	}

	public boolean addAll(int index, Collection<? extends Contact> c) {

		if(c.size()==0) return false;
		for(Contact con: c) { 
			add(index, con);
			index++;
		}
		return true;
	}

	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		boolean valid;
		for(int i=0; i <c.size(); i++) {
			valid = false;
			for(int j=0; j < numElem; j++)
				if(c.toArray()[i].equals(arr[j]))
					valid= true;
			if(!valid)
				return false;
		}
		return true;
	}

	public int lastIndexOf(Object o) {
		for(int i=numElem-1; i>=0;i--)
			if(arr[i].equals(o))
				return i;
		return -1;
	}

	public Iterator<Contact> iterator()
	{
		return new ContactListIterator();
	}

	public List<Contact> subList(int fromIndex, int toIndex) {
		if(toIndex<= fromIndex) 
			throw new IllegalArgumentException("fromIndex needs to be less than or equal to toIndex");
		if(fromIndex<0 || toIndex>= numElem) 
			throw new IndexOutOfBoundsException();
		ContactList<Contact> list = new ContactList<>();
		for(int i = fromIndex; i <=toIndex; i++)
			add(arr[i]);
		return list;
	}

	public Object[] toArray() {
		return arr;
	}


	//REVIEW
	public <T> T[]    toArray(T[] a) {
		a = (T[]) new Object[numElem];
		for(int i=0;i<numElem;i++)
			a[i]= (T)arr[i];
		return a;
	}

	@Override
	public ListIterator<Contact> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<Contact> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean removeAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		throw new UnsupportedOperationException();
	}

}



