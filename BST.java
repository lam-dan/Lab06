import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
/**
 * Lab 4
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/29/22
 * BST.java is designed to act as the binary search tree program where the different sequence
 * of operations and traversals for Binary Search Tree are housed including breadth first, in order,
 * pre order and post order as well as the search,insert,and delete operations. The results
 * are printed to the console and to an output file.
 */

public class BST{
	private BSTNode root;
	private int count;

	  /**
   * Constructors for BS
   */
	public BST() throws IOException{
		root = null;
	}
	
	/** For the BST, implement the four traversal methods as well as 
	 * methods for the usual search, insert, delete, print, count, isEmpty, 
	* empty operations and any other needed.
	*/
	
	
	/** 
	 * Change 1: Removed print statements as they will now be in main.
	 * Go to left-subtree
	 * Visit Node
	 * Go to right-subtree
	 **/
	/**
	 * InOrder helper method
	 * 
	 */
	public void inOrder() { 
	    writeToFile("InOrder Traversal");	
		inOrderRecursive(getRoot());
		System.out.println();
    } 
	
	/* InOrder traversal method that recursively processes the left subtree, the root, and then the right subtree
	 * 
	 * Pre: Checks to see if the left/right node is not null
	 * Post: All nodes in the tree reachable from the root have been visited and the value is printed to console & output file
	 * 
	 */
	public void inOrderRecursive(BSTNode node){
	      if(node.getLeft() != null){
	    	  inOrderRecursive(node.getLeft());
	      }
    	  printNode(node);
	      if (node.getRight() != null) {
	    	  inOrderRecursive(node.getRight());
	      }
	}
	
	/** Change 1: Removed print statements as they will now be in main.
	 * PreOrder helper method
	 * 
	 */
	public void preOrder() { 
	    writeToFile("PreOrder Traversal");	
        preOrderRecursive(getRoot()); 
        System.out.println();
    } 
	
	/**
	 * PreOrder traversal method that processes all nodes by processing the root, and then recursively processes all subtrees
	 * 
	 * Pre: Checks to see if the left/right node is not null
	 * Post: All nodes in the tree reachable from the root have been visited and the value is printed to console & output file
	 * 
	 */
	public void preOrderRecursive(BSTNode node){
		printNode(node);
		if (node.getLeft() != null) {
			preOrderRecursive(node.getLeft());
		}
		if (node.getRight() != null) {
			preOrderRecursive(node.getRight());
		}
	}
	
	/** Change 1: Removed print statements as they will now be in main.
	 * Visit Node
	 * Go to left-subtree
	 * Go to right-subtree
	 * */

	/**
	 * PostOrder helper method
	 * 
	 */
	public void postOrder() { 
	    writeToFile("PostOrder Traversal");	
		postOrderRecursive(getRoot()); 
		System.out.println();
    } 
	 
	/**
	 * PostOrder traversal method that processes all nodes by traversing from the left subtree to the right subtree then to the root
	 * 
	 * Pre: Checks to see if the left/right node is not null
	 * Post: All nodes in the tree reachable from the root have been visited and the value is printed to console & output file
	 * 
	 */
	public void postOrderRecursive(BSTNode node){
		if (node.getLeft() != null) {
			postOrderRecursive(node.getLeft());
		} 
		if (node.getRight() != null) {
			postOrderRecursive(node.getRight());
		}
		printNode(node);
		}
	
	/**
	 * Breadth First traversal goes to all nodes at current depth before moving on to nodes at next depth level
	 * 
	 * Pre: Checks to see if there is a tree with a root
	 * Post: All nodes in the tree reachable from the root have been visited and the value is printed to console & output file
	 */
	public void breadthFirst() throws IOException {
		writeToFile("breadthFirst Traversal using lab3 queue no modification.");
		BSTNode currentNode = root;
		Queue queue = new Queue();
		queue.enqueue(currentNode.getData());
		while (true){
			try {
				Dollar obj = new Dollar(queue.peekFront());
				BSTNode found = search(obj);
				if(search(obj) != null){
					System.out.println(queue.peekFront().toString());
					writeToFile(queue.peekFront().toString());
					queue.dequeue();
				}
				if (found.getLeft() != null) {
					queue.enqueue(found.getLeft().getData());
				}
				if (found.getRight() != null) {
					queue.enqueue(found.getRight().getData());
				}
			}
			catch (Exception e){
				break;
			}
		}
	}
	
	
	
	/** Insert method inserts a node into a binary search tree while obeying the binary search tree ordering properties
	 * 
	 * Pre: Checks to see if the root is null, if yes then set root to equal node, if not set currNode equal to root.
	 * A node inserted into an empty tree will become the tree's root.
	 * Post: Inserted node is returned, and the node is inserted into the binary search tree
	 * 
	 */
	public BSTNode insert(BSTNode node) {
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
	
	/** printNode method prints the node's data attributes to the console
	 * 
	 * Pre: None
	 * Post: Data attributes of the node are printed
	 * 
	 */
	public void printNode(BSTNode node){
		System.out.println(node.getData().toString());
		writeToFile(node.getData().toString());
	}
	
	/** Gets the root of the BST
	 * 
	 * Pre: None
	 * Post: Returns root of BST
	 * 
	 */
	 public BSTNode getRoot(){
		 return root;
	 }
	 
	 /** Sets the root of the BST
	  * 
	  * Pre: None
	  * Post: Sets root value equal to node value
	  * 
	  */
	 public void setRoot(BSTNode node){
		 root = node;
	 }
	 
	 /** Sets the count of the BST nodes
	  * 
	  * Pre: None
	  * Post: Sets count equal to number of nodes
	  * 
	  */
	 public void setCount(int count){
		 this.count = count;
	 }
	 
	 /** Gets the count of the BST nodes
	  * 
	  * Pre: None
	  * Post: returns count of nodes in BST
	  * 
	  */
	 public int getCount(){
		 return count;
	 }
	 
	 /** IsEmpty method to check if BST is empty (i.e. if root is null)
	  * 
	  * Pre: Checks to see if root is null
	  * Post: If root is null, true is returned. Otherwise false is returned. 
	  * 
	  */
	 public boolean isEmpty(){
		if(root == null){
			return true;
		} else {
			return false;
		}
	 }
	 
	 /** Search method to search for a particular node of a BST 
	  * 
	  * Pre: Checks to see if root is null
	  * Post: If root is null, null is returned. Otherwise current node is set to root value, and parses through 
	  * the tree to try and search for the appropriate node.
	  * 
	  */
	 public BSTNode search(Dollar node) {
	        if (getRoot() == null) {
	            return null;
	        } else {
	            BSTNode currNode = getRoot();

	            while (currNode != null) {
	                if (currNode.getData().isEqual(node)) {
	                    return currNode;
	                }
	                else if (currNode.getData().isGreater((node))) {
	                    currNode = currNode.getLeft();
	                }
	                else {
	                    currNode = currNode.getRight();
	                }
	            }
	        }
	        return null;
	    }
	 
	 /** Delete method to delete a particular node of a BST 
	  * 
	  * Pre: Checks to see if root is null
	  * Post: If root is null, root value is returned. Otherwise the appropriate node is removed, depending on how many children 
	  * it has. 
	  * 
	  */
	public BSTNode delete(BSTNode node) {
        BSTNode prev = null;
        BSTNode current = getRoot();

        if (current == null) {
            return root;
        }

        while (current != null && !current.getData().isEqual((node.getData()))) {
            prev = current;
            if (current.getData().isGreater(node.getData())) {
                current = current.getLeft();
            }
            else {
                current = current.getRight();
            }
        }
        if (current.getLeft() == null && current.getRight()== null) {
            if (!current.getData().isEqual((getRoot().getData()))) {
                if (prev.getLeft().getData().isEqual((current.getData()))) {
                    prev.setLeft(null);
                }
                else {
                    prev.setRight(null);
                }
            }
            else {
                root = null;
            }
        }
        else if (current.getLeft() != null && current.getRight() != null) {
            BSTNode nodeHead = current.getRight();
            while (nodeHead.getLeft() != null) {
                nodeHead.setLeft(nodeHead.getLeft());
            }

            Dollar currency = nodeHead.getData();
            delete(nodeHead);
            current.setData(currency);
        }

        else {
        	BSTNode child;
        	if (current.getLeft() != null) {
        		 child = current.getLeft();
        	}
        	else {
        		 child = current.getRight();
        	}
            if (!current.getData().isEqual(getRoot().getData())) {
                if (current.getData().isEqual(prev.getLeft().getData())) {
                    prev.setLeft(child);
                }
                else {
                    prev.setRight(child);
                }
            }

            else {
                setRoot(child);
            }
        }

        return root;
    }
    	
	/**
	 * Write to file method that writes output to a external file
	 *
	 * Pre: None
	 * Post: Outputs contents to an external file
	 */
	public static void writeToFile(String string) {
		try {
		  Writer output = new BufferedWriter(new FileWriter("Lab04.txt", true));
		  output.append("\n" + string);
		  output.close();
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}

}
