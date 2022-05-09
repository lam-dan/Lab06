public class Stack extends SinglyLinkedList{

	public Stack() {
		super();
		
	}
	
	public void push(Currency obj) {
		LinkNode node1 = new LinkNode(obj);
		node1.setNext(getStart());
		setStart(node1);
		setCount(getCount() + 1);
    }
	
	public Currency pop() {
		if (isListEmpty()) {
			return null;
		}
        else {
        	Currency result = getStart().getData();
        	setStart(getStart().getNext());
        	setCount(getCount() - 1);
        	return result;
        }
			
     }
	
	public Currency peek() {
		if (isListEmpty()) {
			return null;
		}
        else {
            return getStart().getData();
        }
    }
	
	public String printStack()  {
		 String result = "";
	        LinkNode current = getStart();
	        while (current != null) {
	            result = result + current.toString() + "\n";
	            current = current.getNext();
	        }
	        return result;
    }

}
