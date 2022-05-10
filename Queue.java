/**
 * Lab 3
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/9/22
 * Queue.java is designed to act as the queue class where operations like enqueue and dequeue are defined. The data from the queue
 * is stored and printed in the printQueue method.
 */
public class Queue extends SinglyLinkedList {

  /**
   * Constructor for queue that creates the queue
   */
  public Queue() {
  }

  /**
   * The enqueue method  takes a Currency object as parameter and adds it to the end of the queue
   * 
   * Pre: Check to see if the list is empty, if yes, setStart to be node1.
   * Post: Currency object is added to the end of the queue
   */
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

  /**
    * The dequeue method takes no parameter and removes and returns the Currency object from the front of the queue.
    * 
    * Pre: Check to see if the list is empty, if yes, return null
    * Post: Currency object is added to the front of the queue
    */
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

  /**
    * The peekFront method takes no parameter and returns a copy of the Currency object at the front of the queue
    * 
    * Pre: Check to see if the list is empty, if yes, return null
    * Post: A copy of Currency object is added to the front of the queue
    */
  public Currency peekFront() {
    if (isListEmpty()) {
      return null;
    }
    return getStart().getData();
  }

  /**
    * The peekRear method takes no parameter and returns a copy of the Currency object at the end of the queue
    * 
    * Pre: Check to see if the list is empty, if yes, return null
    * Post: A copy of Currency object is added to the end of the queue
    */
  public Currency peekRear() {
    if (isListEmpty()) {
      return null;
    }
    return getEnd().getData();
  }

  /**
  * The printQueue method returns a string with contents of the queue from front to end
  * 
  * Pre: none
  * Post: String with contents of the queue is returned
  */
  public String printQueue() {
    StringBuilder sb = new StringBuilder("");
    LinkNode current = getStart();
    while (current != null) {
      sb.append(current.getData().toString());
      current = current.next;
    }
    return sb.toString();
  }
}

