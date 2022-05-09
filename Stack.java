
public class Stack extends SinglyLinkedList{

	public Stack() {
		super();
		
	}
	
	public void push(Currency obj) {
		append(obj);
    }
	
	public void pop() {
		
			
     }
	
	public LinkNode peek() {
		if (isListEmpty()) {
			return null;
		}
        else {
            return getStart();
        }
    }
	
	public void printStack()  {
		LinkNode currentNode = getStart();
        System.out.println("Printing Current Stack");
        //as long as the node is not null do the following:
        while (currentNode != null) {
        	currentNode.getData().print();
            System.out.println(currentNode.getData().getNoteValue()+ " Dollar " + currentNode.getData().getCoinValue() + " Cent");
            currentNode = currentNode.next;
        }
        System.out.println();
    }

}
