public class BST {
	private BSTNode root;
	
	  /**
   * Constructor for BS
   */
	public BST(){
		this.root = null;
	}
	
	/** For the BST, implement the four traversal methods as well as 
	 * methods for the usual search, insert, delete, print, count, isEmpty, 
	* empty operations and any other needed.
	*/
	
	
	/** 
	 * Go to left-subtree
	 * Visit Node
	 * Go to right-subtree
	 **/
	
	public void inOrder(){
		if(root != null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		} 
	}
	
	public void preOrder(){
		if (root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
		}
	}
	
	/**
	 * Visit Node
	 * Go to left-subtree
	 * Go to right-subtree
	 * */
	
	public void postOrder(){
		if (root != null) {
			System.out.print(root.data + " ");
			preorderTraversal(root.left);
			preorderTraversal(root.right);
			}
		}
		
		public void breadthFirst(){
				if (root == null) {
			return;
		}

		Queue queue = new Queue();
		queue.enqueue(root);

		while (!queue.isEmpty()) {
			BSTNode node = queue.dequeue();
			System.out.print(node.data + " ");

			if (node.left != null) {
				queue.enqueue(node.left);
			}

			if (node.right != null) {
				queue.enqueue(node.right);
			}
		}
	}
	
	
	
	/** Search for a particular data value
	 * */
	 
	public search(){
	}
	
	/** if N is the data of a node, X < N goes on left subtree, X >= N 
	 * goes on the right subtree. Assume no duplicate data entered in the tree.
	 */
	
	public insert(){
		
	}
	
	public delete(){
		
		
	}
	
	public print(){
		
	}
	
	public count(){
		
		
	}
	
	public isEmpty(){
		
	}
	
	public String toString(Dollar data){
		
		return data.print();
	}


	
}
