/**
 * Lab 3
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/7/22
 * SinglyLinkedList.java is designed to have the linked-list behaviors
 * that were defined in class, along with a count attribute, LinkNode start and LinkNode end
 * that point to the start and end of the linked list. 
 */
public class SinglyLinkedList extends Currency {

	private int count;
	
	private LinkNode start;
	
	private LinkNode end;
	
	public SinglyLinkedList() {
		start = null;
		end = null;
		setCount(0);
	}
	
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
	 
//Add Nodes to the linked list in front
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

	//Add Nodes to the linked list in back	
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
	
	
	public void addCurrency(Currency obj, int index) {
	//	LinkNode node = start;
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
	   
	public int findCurrency(Currency obj) {
		int index = 0;
		LinkNode node = this.start;
		while(node != null){
			if(obj.isEqual(node.getData())){
				//String s = "Found " + obj.print() + " at index " + index;
			//	System.out.println(s);
				return index;
			}
			index++;
			node = node.getNext();
		}

		//	System.out.println("Did not find " + obj.print()+ " at any index.");

		return -1; 
	}
	   
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
	   
	public void printList() {
		StringBuilder sb = new StringBuilder("");
		LinkNode node = this.start;
			while (node != null) {
				sb.append(node.getData().print());
				System.out.print(node.getData().getNoteValue() + "." + node.getData().getCoinValue() + " ");
				node = node.getNext();
				if(node!=null)
				sb.append("	");
			} 
	}
	   
	public boolean isListEmpty() {
		return this.start == null;
	}
	   
	public int countCurrency() {
		return getCount();
		   
	}
}
