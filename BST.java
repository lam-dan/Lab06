public class BST{
	private BSTNode root;
	private int count;
	
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
		inOrderRecursive(this.root);
    } 
	
	public void inOrderRecursive(BSTNode node){
		StringBuilder sb = new StringBuilder("");
		if(node != null){
			inOrderRecursive(node.getLeft());
			printNode(node);
			inOrderRecursive(node.getRight());
		}
	}
	
	public void preOrder() { 
        preOrderRecursive(this.root); 
    } 
	
	public void preOrderRecursive(BSTNode node){
		if (node != null) {
			printNode(node);
			preOrderRecursive(node.getLeft());
			preOrderRecursive(node.getRight());
		}
	}
	
	/**
	 * Visit Node
	 * Go to left-subtree
	 * Go to right-subtree
	 * */

	public void postOrder() { 
		postOrderRecursive(this.root); 
    } 
	 
	
	public void postOrderRecursive(BSTNode node){
		if (node != null) {
			postOrderRecursive(node.getLeft());
			postOrderRecursive(node.getRight());
			printNode(node);
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
	
	public BSTNode insert(BSTNode node){
			if (getRoot() == null) {
				setRoot(node);
			} else {
				BSTNode currNode = getRoot();

				while (true) {
					if (currNode.getData().isGreater((node.getData()))) {
						if (currNode.getLeft() == null) {
							currNode.setLeft(node);
							break;
						} else {
							currNode = currNode.getLeft();
						}
					}
					else {
						if (currNode.getRight() == null) {
							currNode.setRight(node);
							break;
						} else {
							currNode = currNode.getRight();
						}
					}
				}
			}

			setCount(getCount()+1);
			return node;
		}
	
	
	public void printNode(BSTNode node){
		System.out.println(node.getData().toString());
	}
	
	 
	 public BSTNode getRoot(){
		 return root;
	 }
	 
	 public void setRoot(BSTNode node){
		 root = node;
	 }
	 
	 public void setCount(int count){
		 this.count = count;
	 }
	 
	 public int getCount(){
		 return count;
	 }
	 
	 public boolean isEmpty(){
		if(root == null){
			return true;
		} else {
			return false;
		}
	}

	public boolean search(Dollar data){
		while (getRoot() != null) {
			if( data.isGreater(getRoot().getData())){
				getRoot().setRight(getRoot().getRight());
			} 
			else if(!data.isGreater(getRoot().getData())){
				getRoot().setLeft(getRoot().getLeft());
			}
			else {
				System.out.println("True");
				return true;
			}
		}
		return false;
	}
	
	public void delete(){
		
	}

}
