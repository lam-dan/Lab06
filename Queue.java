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
        return getStart().getData();
	}

	public Currency peekRear() {
		if (isListEmpty()) {
            return null;
        }
        return getEnd().getData();
	}
	
	public String printQueue()  {
		StringBuilder sb = new StringBuilder("");
		LinkNode current = getStart();
		while (current != null) {
			sb.append(current.getData().getNoteValue() + "." + current.getData().getCoinValue() + "	");
			current = current.next;
		}
		return sb.toString();
    }
}
