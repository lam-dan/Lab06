/**
 * Lab 3
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/7/22
 * LinkNode.java is designed to act as class that has a data attribute, attribute to the 'next' node, and 
 * the appropriate constructors, getters and setters.
 */
public class LinkNode {

	private Currency data;
	public LinkNode next;
	
	// Default constructor
	public LinkNode(Currency obj) {
		this.setData(obj);
		this.setNext(null);
		
	}
	
	// Getters and Setters
		/**
		 * The getters for the LinkNode class get & read the data of the node, 
		 * and pointer to the next node, so that they can be manipulated in add/subtract/isEqual/isGreater methods,
		 * and elsewhere in the program.
		 * 
		 * Pre: None
		 * Post: the data of the node 
		 */
		
		/**
		 * The setters for the LinkNode class update the data and position
		 * of the node and set them so that they can be manipulated in add/remove methods in the linked list,
		 * and elsewhere in the program.
		 * 
		 * Pre: none
		 * Post: The data & position of the node in the linked list is updated/set.
		 */
	public Currency getData() {
		return data;
	}
	
	public void setData(Currency data) {
		this.data = data;
	}
	
	public LinkNode getNext() {
		return next;
	}
	public void setNext(LinkNode next) {
		this.next = next;
	}
}
