import java.io.IOException;
import java.util.Arrays;

public class MinHeap extends BST{
	BSTNode minHeap[];
	int size;
	int index;
	
	public MinHeap(int size) throws IOException{
		this.size = size;
		this.index = 0;
		this.minHeap = new BSTNode[size];
	}
		
	 /** search method to search for a particular node of a BST is in the minHeap tree.
	  * 
	  * Pre: Checks to see if root is null
	  * Post: If root is null, null is returned. Otherwise, we invoke the helperSearch method 
	  * using the root and the Dollar node we are searching for.
	  */
	 @Override
	 public BSTNode search(Dollar node) {
		 if(isEmpty() == true){
			 return null;
		 } else {
			 return helperSearch(getRoot(), node);
		 }		 
	 }
	 
	 /** helperSearch method to search for a particular node of a BST is in the minHeap tree.
	  * 
	  * Pre: Checks to see current node is null and if it has data that is equal to the searched Dollar node.
	  * It will recursively call current's left nodes to see if it has the dollar node, 
	  * and also recursively call the current's right nodes to see if it has the dollar node.
	  * Post: It will return it whatever it can find from the recursive calls down the minHeap tree on both
	  * the left and right sides of the tree and return it, otherwise, it will return null.
	  */
	 public BSTNode helperSearch(BSTNode current, Dollar node) {
		 if( current != null){
			 if( current.getData().isEqual(node)){
				 return current;
			 } else {
				 BSTNode found = helperSearch(current.getLeft(), node);
				 if( found == null){
					 found = helperSearch(current.getRight(), node);
				 }
				 return found;
			 }
		} else {
			 return null;
		}
	}
	    
	/** getParentIndex returns the parent index of a given index in the array of BSTNodes.
	 * 
	 * Pre: None.
	 * Post: Returns i subtracted by 1 and divided by two.
	 * */
	public int getParentIndex(int i) {
		 return (i - 1) / 2;
	}
	
	/** swap method swaps two BSTNodes in the array based on two indexes of the minHeap array.
	 * 
	 * Pre: None.
	 * Post: Creates a temporary pointer
	 * */
	public void swap(int x, int y) {
		BSTNode tmp;
		tmp = minHeap[x];
		minHeap[x] = minHeap[y];
		minHeap[y] = tmp;
	}
	
	/** Insert method inserts a node into a min heap tree while obeying the min heap tree ordering properties.
	 * 
	 * Pre: Checks to see if the index is 0, if yes then set root to equal node.  Also checks to see if the
	 * index is greater than the size of the array and if it is, it will also return since it cannot insert.
	 * Sets the minHeap current index attribute to the node.
	 * Creates a current pointer to the index.
	 * It checks if the value of the parent for a given index is greater than the current node's value being
	 * inserted. If it is, it will swap the the current node with parent in the minHeap array. 
	 * Sets current to the new to the new parent index.
	 * Increases index count by 1.
	 * Post: Inserted node is returned, and the node is inserted into the minHeap array.
	 */
	@Override
	public BSTNode insert(BSTNode node) {
		if (index == 0){
			setRoot(node);
		}
		if (index >= size){
			return node;
		}
		minHeap[index] = node;
		int current = index;
		
		while(minHeap[getParentIndex(current)].getData().isGreater(minHeap[current].getData())){
			swap(current, getParentIndex(current));
			current = getParentIndex(current);
		}
		index++;
		return node;
	}
	
	/** Getter method for getting the left child index of a given index in minHeap array.
	 * 
	 * Pre: None.
	 * Post: Returns index of left child of a given index.
	 * */
	public int getLeftChild(int i) {
		return (i * 2) + 1;
	}

	/** Getter method for getting the right child index of a given index in minHeap array.
	 * 
	 * Pre: None.
	 * Post: Returns index of right child of a given index.
	 * */
	public int getRightChild(int i) {
		return (i * 2) + 2;
	}
	
	/** isLeaf method for checking if at a given index in the minHeap array, it is a leaf node.
	 * 
	 * Pre: Checks if the right child index is greater than or equal to the size of the array or
	 * the left child infex is greater than or equal to the size of the array.
	 * Post: Returns true if statement is satisfied, else returns false.
	 * */
	private boolean isLeaf(int i) {
		if (getRightChild(i) >= size || getLeftChild(i) >= size) {
			return true;
		}
		return false;
	}
	
	/** minHeapify will heapify the minHeap array into a mininum heap data structure given an index.
	 * 
	 * Pre: Checks to see if the node at the index is a leaf node and if any of it's left and right childs 
	 * are smaller. If they are, it will try swap the index with its left index and recursively call minHeapify  it's
	 * against's it's new left child. It will do the same for the right hand child.
	 * Post: None.
	 * */
	private void minHeapify(int i) {
		if (!isLeaf(i)) {
			if (minHeap[i].getData().isGreater(minHeap[getLeftChild(i)].getData()) ||
                  minHeap[i].getData().isGreater(minHeap[getRightChild(i)].getData())) {
				if (minHeap[getRightChild(i)].getData().isGreater(minHeap[getLeftChild(i)].getData())) {
					swap(i, getLeftChild(i));
					minHeapify(getLeftChild(i));
				} else {
					swap(i, getRightChild(i));
					minHeapify(getRightChild(i));
				}
			}
		}
	}
	
	/** minHeap will build the min-heap array using minHeapify
	 * 
	 * Pre: Iterates over the minHeap array index based on integer i equal to index -1 and divided by 2,
	 * while i is greater than or equal of 1, and i is decremented by 1.  It will call minHeapify based on 
	 * i.
	 * Post: None.
	 * */
	// builds the min-heap using the minHeapify
	public void minHeap() {
		for (int i = (index - 1 / 2); i >= 1; i--) {
			minHeapify(i);
		}
	}
	
	/** buildTree will build the minHeapp from the minHeap array.
	 * 
	 * Pre: If the root is null, we set the root based on the first element in the minHeap array. Current 
	 * is set to null. K is starting at 0. For loop to iterate over each BSTNode in the minHeap array 
	 * and setting current to the first value of the minHeap array (aka the root).  If the left child of the current  is less
	 * than the length of the minHeap array, the left node is set for current. If the right child of the 
	 * current  is less than the length of the minHeap array, the right node is set for current.  
	 * Increase k by 1.
	 * After iterating through all the elements, the new root node is set at the first BSTNode of the minHeap
	 * array.
	 * Post: Return the root of the minHeap array.
	 * */
	public BSTNode buildTree(){
		if( getRoot() == null){
			setRoot(minHeap[0]);
		}
		BSTNode current = null;
		
		int k = 0;
		for (int i = 0; i < minHeap.length; i++){
			current = minHeap[i];
			if( getLeftChild(i) < minHeap.length){
				current.setLeft(minHeap[getLeftChild(i)]);
			}
			if ( getRightChild(i) < minHeap.length){
				current.setRight(minHeap[getRightChild(i)]);
			}
			k++;
		}
		setRoot(minHeap[0]);
		return getRoot();
	}
		
	/** Delete method to delete a particular node of a BST from a minHeap 
	  * 
	  * Pre: Swaps the root node with the last element in the array. 
	  * Creates a new array and copies all elements from old array into new one except the last one.
	  * Sets old minHeap array to null.
	  * Decrement index.
	  * Heapifies new array.
	  * Set root to new array.
	  * Builds tree from new array;
	  * Returns deleted node.
	  * Post: Returns the node that was deleted.
	  */
	@Override
	public BSTNode delete(BSTNode node) {
		swap(0, minHeap.length-1);
		BSTNode newArr[] = Arrays.copyOf(minHeap, minHeap.length - 1);
		minHeap = null;
		index--;
		minHeap();
		setRoot(newArr[0]);
		buildTree();
		return node;
    }
}
