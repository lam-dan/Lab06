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
	 
	
	public void addCurrency(Currency obj, LinkNode index) {
		//Currency add = new Currency();
		//int position = index - 1;
		//Currency current = 
	   
	}
	   
	public void removeCurrency(Currency obj) {
		LinkNode node = new LinkNode(obj);
		if (isListEmpty()) {
			start = node;
			end = node;
		} else {
			end.setNext(node);
		}
		end = node;
		count++;
	}
	   
	public void removeCurrencyOverload(LinkNode index) {
		   
	}
	   
	public void findCurrency(Currency obj) {
		   
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
	   
	public String printList() {
		StringBuilder printString = new StringBuilder("");
		LinkNode node1 = start;
		
		while (node1 != null) {
			printString.append(node1.getData());
			node1 = node1.getNext();
			if (node1 != null) {
				printString.append("   ");
			}
		}
		return printString.toString();

		  
	}
	   
	public boolean isListEmpty() {
		return getCount() == 0;
	}
	   
	public int countCurrency() {
		return getCount();
		   
	}
}
