public class Queue extends SinglyLinkedList{

	public Queue() {
	}
	
	public void enqueue(Currency obj) {
		LinkNode node1 = new LinkNode(obj);
		if (isListEmpty()) {
			setStart(node1);
		} else {
			getEnd().setNext(node1);
		}
		setEnd(node1);
		setCount(getCount() + 1);
    	}
	
	public Currency dequeue() {
		if (isListEmpty()) {
            return null;
        }
		Currency result = getStart().getData();
        setStart(getStart().getNext());
        setCount(getCount() - 1);
        if (isListEmpty()) {
             setEnd(null);
        }
        return result;
   	}
	
	public Currency peekFront() {
		if (isListEmpty()) {
            return null;
        }
        System.out.println(getStart().getData().printCurrency());
        return getStart().getData();
	}
	
	public Currency peekRear() {
		if (isListEmpty()) {
            return null;
        }
        System.out.println(getEnd().getData().printCurrency());
        return getEnd().getData();
	}
	
	public void printQueue()  {
		LinkNode current = getStart();
		while (current != null) {
			current.getData().printCurrency();
			System.out.print(current.getData().getNoteValue() + "." + current.getData().getCoinValue() + "	");
			current = current.next;
		}
    	}
}
