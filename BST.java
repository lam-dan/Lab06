public class BST{
	private BSTNode root;
	
	  /**
   * Constructors for BS
   */
	public BST(){
		root = null;
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
	 
	public void inOrder() { 
        inOrderRecursive(root); 
    } 
	
	public void inOrderRecursive(BSTNode node){
		System.out.print("inOrderRecursive node value: " + node.getData().toString() + " ");
		if(node == null){
			inOrderRecursive(node.getLeft());
			System.out.print("if node == null" + node.getData().toString() + " ");
			inOrderRecursive(node.getRight());
		} 
	}
	
	public void preOrder(BSTNode node){
		if (node != null) {
			System.out.print(node.getData() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	/**
	 * Visit Node
	 * Go to left-subtree
	 * Go to right-subtree
	 * */
	
	public void postOrder(BSTNode node){
		if (node != null) {
			System.out.print(node.getData() + " ");
			postOrder(node.getLeft());
			postOrder(node.getRight());
			}
		}
		
	/**
	public void breadthFirst(){
		if (root == null) {
			return;
		}
		
		Queue queue = new Queue();
		queue.enqueue(root.getData().;
		
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
	* 
	* /
	
	
	
	/** if N is the data of a node, X < N goes on left subtree, X >= N 
	 * goes on the right subtree. Assume no duplicate data entered in the tree.
	 */
	public void insert(Dollar data){
		root = insertRecursive(root, data);
	}
	
	public BSTNode insertRecursive(BSTNode root, Dollar data){
		if(root == null){
			//System.out.print("Inserting data: " + data);
			root = new BSTNode(data);
			//System.out.println("Root is now: "+ root.getData().toString());
			return root;
		}
		
		Double dataDouble = parseDouble(data.toString());
		Double rootDouble = parseDouble(this.root.getData().toString());
		
		if(dataDouble < rootDouble){
			//System.out.println("dataDouble < rootDouble");
			BSTNode left = root.getLeft();
			left = insertRecursive(left, data);
		} else if ( dataDouble > rootDouble){
			//System.out.println("dataDouble > rootDouble");
			BSTNode right = root.getRight();
			right = insertRecursive(right, data);
		}
		return root;
	}
	
	public Double parseDouble(String data){
		return Double.parseDouble(data);
	}
	
	/** Search for a particular data value
	 
	 
	public search(){
		
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
	**/
	
}
