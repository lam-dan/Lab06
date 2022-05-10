public class Stack extends SinglyLinkedList{

	public Stack() {
		super();
	}
	
	public void push(Currency obj) {
		LinkNode node1 = new LinkNode(obj);
		node1.next = getStart();
		setStart(node1);
		setCount(getCount() + 1);
    }
	
	public Currency pop() {
		if (isListEmpty()) {
			return null;
		}
        Currency result = getStart().getData();
        setStart(getStart().getNext());
        setCount(getCount() - 1);
        return result;
     }
	
	public Currency peek() {
		if (isListEmpty()) {
			return null;
		}
        else {
            return getStart().getData();
        }
    }
    
    public String toString(Currency obj){
		return obj.toString();
	}
	
	public String printStack()  {
		StringBuilder sb = new StringBuilder("");
		LinkNode current = getStart();
		while (current != null) {
			sb.append(current.getData().toString()+ "	");
			current = current.next;
		}
		return sb.toString();
    }

}
