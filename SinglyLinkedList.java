/**
 * Lab 3
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/9/22
 * SinglyLinkedList.java is designed to have the linked-list behaviors
 * that were defined in class, along with a count attribute, LinkNode start and LinkNode end
 * that point to the start and end of the linked list. 
 */
public class SinglyLinkedList extends Currency {

	/**
	 * Private attributes count, start of LinkNode (points to start of list) and end of LinkNode (points to end of list)
	 */
	private int count;
	
	private LinkNode start;
	
	private LinkNode end;
	
	/**
	 * Constructor for SinglyLinkedList that creates the list with start, end = null and count = 0.
	 */
	public SinglyLinkedList() {
		start = null;
		end = null;
		setCount(0);
	}
	
	// Getters and Setters
	/**
	 * The getters for the SinglyLinkedList class get & read the data of the list, 
	 * and pointer to the next node, so that they can be manipulated in stack & queue methods,
	 * and elsewhere in the program.
	 * 
	 * Pre: None
	 * Post: the start/end pointer of the list and the count attribute is returned 
	 */
	
	/**
	 * The setters for the LinkNode class update the data of the list
	 * and set them so that they can be manipulated in the linked list,
	 * queue, stack and elsewhere in the program.
	 * 
	 * Pre: none
	 * Post: The position and counter in the linked list is updated/set.
	 */
	public int getCount() {
		return count;
	}
	  
	public LinkNode getStart() {
		if (isListEmpty() == true) {
			return null;
		}
		return start;
	}

	public LinkNode getEnd() {
		if (isListEmpty() == true) {
			return null;
		}
		return end;
	}
	  
	public void setCount(int count) {
		this.count = count;
	}
	   
	 
	public void setStart(LinkNode start) {
		this.start = start;
    }

	public void setEnd(LinkNode end) {
		this.end = end;
    }
	 
	
	/**
	 * Prepend adds the nodes to the linked list in the front.
	 * 
	 * Pre: Checks if list is empty
	 * Post: The prepended list now has nodes in the front
	 */
	public void prepend(Currency obj){
		LinkNode node = new LinkNode(obj);
		if(isListEmpty()){
			this.start = node;
			this.end = this.start;
		} else {
			node.setNext(this.start);
			this.start = node;
		}
		count++;
	}


	/**
	 * Append adds the nodes to the linked list in the back.
	 * 
	 * Pre: Checks if list is empty
	 * Post: The prepended list now has nodes in the back
	 */
	public void append(Currency obj){
		LinkNode node = new LinkNode(obj);
		if(isListEmpty()){
			this.start = node;
			this.end = node;
		} else {
			this.end.setNext(node);
		}
		this.end = node;
		count++;
	}
	
	/**
	 * addCurrency adds the Currency object to the list at that specified index
	 * 
	 * Pre: Checks if index < 0, if yes, print error message & return.
	 * Post: Currency object is added to list at the 'index'
	 */
	public void addCurrency(Currency obj, int index) {
		if( index < 0 ){
			System.out.println("This index is invalid.");
			return;
		}
		if ( index == 0 ){
			this.prepend(obj);
		} else {
			while(index != -1){
				index--;
				if( index == 0){
					LinkNode newNode = new LinkNode(obj);
					newNode.next = start.next;
					start.next = newNode;
					break;
				}
			}
		}
	}
	  
	/**
	 * removeCurrency removes that Currency object from the list and returns a copy of the Currency
	 * 
	 * Pre: none
	 * Post: Currency object is removed from the list and a copy of the object is returned
	 */
	public Currency removeCurrency(Currency obj) {
		LinkNode node = this.start;
		int index = 0;
		
		while(!obj.isEqual(node.getData())){
			node = node.getNext();
			index++;
		}
		Currency currencyRef = removeCurrency(index);
		return currencyRef;
	}
	   
	/**
	 * removeCurrency overload method removes that Currency object from the list at that index and returns a copy of the Currency.
	 * 
	 * Pre: Checks to see if index is < 0 or if index >= count, if yes, throw a index out of bounds exception
	 * Post: Currency object is removed from the list at specified index and a copy of the object is returned
	 */
	public Currency removeCurrency(int index) {
		if (index < 0 || index >= count) {
			throw new IndexOutOfBoundsException();
		}
		LinkNode node = start;
		for (int i = 0; i < index-1; i++) {
			node = node.getNext();
        }
        if( index == 0){
			start = node.getNext();
		} else {
			LinkNode next = node.getNext().getNext();
			node.next = next;
			return node.getData();
		}
		return node.getData();
	}
	   
	/**
	 * findCurrency method returns the node index at which the Currency is found in the list
	 * 
	 * Pre: None
	 * Post: Index at which the currency object is found at is returned
	 */
	public int findCurrency(Currency obj) {
		int index = 0;
		LinkNode node = this.start;
		while(node != null){
			if(obj.isEqual(node.getData())){
				System.out.println("Found " + obj.printCurrency() + " at index " + index + ".");
				return index;
			}
			index++;
			node = node.getNext();
		}
		System.out.println("Did not find " + obj.printCurrency()+ " at any index.");
		return -1; 
	}
	   
	/**
	 * getCurrency method returns the Currency object
	 * 
	 * Pre: Check to see if index is >= the currency of count or if index is < 0, if yes to either, returns null
	 * Post: Currency object is returned
	 */
	public LinkNode getCurrency(int index) {
		if (index >= countCurrency() || index < 0) {
			return null;
		}
		LinkNode node = getStart();
		for (int i = 0; i < index; i++) {
			if (node == null) {
				return null;
			}
			node = node.getNext();
		}
		return node;
	}
	   
	/**
	  * The printList method returns a string of all the Currency objects in the list in the order of index
	  * 
	  * Pre: none
	  * Post: String with contents of the list is returned in order of the index
	  */
	public void printList() {
		StringBuilder sb = new StringBuilder("");
		LinkNode node = this.start;
			while (node != null) {
				sb.append(node.getData().printCurrency());
				System.out.print(node.getData().getNoteValue() + "." + node.getData().getCoinValue() + "	");
				node = node.getNext();
				if(node!=null)
				sb.append("	");
			} 
	}
	   
	/**
	  * isListEmpty method checks to see if the singly linked list is empty
	  * 
	  * Pre: none
	  * Post: true if the singly linked list is empty
	  */
	public boolean isListEmpty() {
		return this.start == null;
	}
	   
	/**
	  * countCurrency method returns a count of Currency nodes in the list
	  * 
	  * Pre: none
	  * Post: number of currency nodes in the singly linked list
	  */
	public int countCurrency() {
		return getCount();
		   
	}
}
