/**
 * Lab 4
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/29/22
 * BSTNode.java is designed to act as the binary search tree node program with a data attribute and two pointer attributes, 
 * one for the left child and the other for the right child. Additionally, it houses the getters and setters for the left
 * and right childs.
 */
public class BSTNode {
	
	//Data Attribute
    private Dollar data;

    //Right Child
    private BSTNode right;

    //Left Child
    private BSTNode left;

    /**
     * BSTNode Constructor method that creates a BST Node
     * Pre: None
     * Post: BSTNode is constructed with left and right childs
     */
    public BSTNode(Dollar data, BSTNode right, BSTNode left) {
        this.data = data;
        this.right = right;
        this.left = left;
    }

    /**
     * BSTNode Constructor method that creates a BST Node
     * Pre: None
     * Post: BSTNode is constructed with no children
     */
    public BSTNode(Dollar data) {
        this.data = data;
    }

    /**
     * BSTNode Constructor method that creates a BST Node
     * Pre: None
     * Post: Empty BST is constructed
     */
    public BSTNode(){

    }

    /**
     * Gets Data from Dollar object
     * Pre: none
     * Post: Returns data from dollar object
     */
    public Dollar getData() {
        return data;
    }

    /**
     * Sets data for dollar object
     * Pre: None
     * Post: Data's value is set
     */
    public void setData(Dollar data) {
        this.data = data;
    }

    /**
     * Gets right child for BSTNode
     * Pre: None
     * Post: right child is returned
     */
    public BSTNode getRight() {
        return right;
    }

    /**
     * Sets right child value for BSTNode
     * Pre: None
     * Post: right child value in BST is set
     */
    public void setRight(BSTNode right) {
        this.right = right;
    }

    /**
     * Gets left child for BSTNode
     * Pre: None
     * Post: left child is returned
     */
    public BSTNode getLeft() {
        return left;
    }

    /**
     * Sets left child value for BSTNode
     * Pre: None
     * Post: left child value in BST is set
     */
    public void setLeft(BSTNode left) {
        this.left = left;
    }
    
    /**
     * ToString method for BSTNode
     * Pre: None
     * Post: returns data of BSTNode in string format
     */
    @Override
    public String toString(){
        return data.toString();
    }
}
