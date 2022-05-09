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
			System.out.println(getStart().getData().printCurrency());
            return getStart().getData();
        }
    }
	
	public void printStack()  {
		LinkNode current = getStart();
		
		while (current != null) {
			current.getData().printCurrency();
			System.out.print(current.getData().getNoteValue() + "." + current.getData().getCoinValue() + "	");
			current = current.next;
		}
    }

}
