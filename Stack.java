/**
 * Lab 3
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/9/22
 * Stack.java is designed to act as the stack class where operations like push and pop are defined. The data from the stack
 * is stored and printed in the printStack method.
 */
public class Stack extends SinglyLinkedList{

	/**
	 * Constructor for stack that creates the stack
	 */
	public Stack() {
		super();
		
	}
	
	/**
	  * The push method takes a Currency object as parameter and adds it to the top of the stack
	  * 
	  * Pre: none
	  * Post: Currency object is added to the top of the stack
	  */
	public void push(Currency obj) {
		LinkNode node1 = new LinkNode(obj);
		node1.next = getStart();
		setStart(node1);
		setCount(getCount() + 1);
    }
	
	/**
	  * The pop method removes and returns the Currency object from the top of the stack
	  * 
	  * Pre: Check to see if list is empty, if yes return null
	  * Post: Currency object is removed and returned to the top of the stack
	  */
	public Currency pop() {
		if (isListEmpty()) {
			return null;
		}
   
        Currency result = getStart().getData();
        setStart(getStart().getNext());
        setCount(getCount() - 1);
        return result;	
     }
	
	/**
	  * The peek method returns a copy of the Currency object at the top of the stack
	  * 
	  * Pre: Check to see if list is empty, if yes return null
	  * Post: Copy of the Currency object is returned to the top of the stack
	  */
	public Currency peek() {
		if (isListEmpty()) {
			return null;
		}
        else {
			System.out.println(getStart().getData().printCurrency());
            return getStart().getData();
        }
    }
	
	/**
	  * The printStack method returns a string with contents of the stack from the top to bottom
	  * 
	  * Pre: none
	  * Post: String with contents of the stack is returned
	  */
	public void printStack()  {
		LinkNode current = getStart();
		
		while (current != null) {
			current.getData().printCurrency();
			System.out.print(current.getData().getNoteValue() + "." + current.getData().getCoinValue() + "	");
			current = current.next;
		}
    }

}
