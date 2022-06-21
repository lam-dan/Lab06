/**
 * Lab 6
 * @author Daniel Lam
 * CS 22C
 * Date: 06/19/22
 * Lab06Main.java is designed to act as the main program where the Hash 
 * Table is created, seeded, and hashed. The hash table will contain methods for collision resolution,
 * inserting data, and searching for it.
 * The user is will be able to search for values, print the number of data items loaded, 
 * load factor, and number of collisions of the hash table.
 */
 
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Arrays;

public class Lab06Main {
  
  public static void main(String [] args){
    System.out.println("Welcome to ADT Testing by Daniel Lam and Chitra Srinivasan.");
    System.out.println();
    Scanner sc = new Scanner(System.in);
    
    BSTNode node1 = new BSTNode(new Dollar(57.12));
    BSTNode node2 = new BSTNode(new Dollar(23.44));
    BSTNode node3 = new BSTNode(new Dollar(87.43));
    BSTNode node4 = new BSTNode(new Dollar(68.99));
    BSTNode node5 = new BSTNode(new Dollar(111.22));
    BSTNode node6 = new BSTNode(new Dollar(44.55));
    BSTNode node7 = new BSTNode(new Dollar(77.77));
    BSTNode node8 = new BSTNode(new Dollar(18.36));
    BSTNode node9 = new BSTNode(new Dollar(543.21));
    BSTNode node10 = new BSTNode(new Dollar(20.21));
    BSTNode node11 = new BSTNode(new Dollar(345.67));
    BSTNode node12 = new BSTNode(new Dollar(36.18));
    BSTNode node13 = new BSTNode(new Dollar(48.48));
    BSTNode node14 = new BSTNode(new Dollar(101.00));
    BSTNode node15 = new BSTNode(new Dollar(11.00));
    BSTNode node16 = new BSTNode(new Dollar(21.00));
    BSTNode node17 = new BSTNode(new Dollar(51.00));
    BSTNode node18 = new BSTNode(new Dollar(1.00));
    BSTNode node19 = new BSTNode(new Dollar(251.00));
    BSTNode node20 = new BSTNode(new Dollar(151.00));
   
    try {
		 // Initializing MinHeap with size 20 elements
		MinHeap minHeap = new MinHeap(20);
		// Inserting 20 elements into MinHeap
		minHeap.insert(node1);
		minHeap.insert(node2);
		minHeap.insert(node3);
		minHeap.insert(node4);
		minHeap.insert(node5);
		minHeap.insert(node6);
		minHeap.insert(node7);
		minHeap.insert(node8);
		minHeap.insert(node9);
		minHeap.insert(node10);
		minHeap.buildTree();
		System.out.println("InOrder Traversal:");
		minHeap.inOrder();
		System.out.println("PreOrder Traversal:");
		minHeap.preOrder();
		System.out.println("PostOrder Traversal:");
		minHeap.postOrder();
		System.out.println("breadthFirst Traversal:");
		minHeap.breadthFirst();
		minHeap.insert(node11);
		minHeap.insert(node12);
		minHeap.insert(node13);
		minHeap.insert(node14);
		minHeap.insert(node15);
		minHeap.insert(node16);
		minHeap.insert(node17);
		minHeap.insert(node18);
		minHeap.insert(node19);
		minHeap.insert(node20);
		minHeap.buildTree();
		System.out.println("InOrder Traversal:");
		minHeap.inOrder();
		System.out.println("PreOrder Traversal:");
		minHeap.preOrder();
		System.out.println("PostOrder Traversal:");
		minHeap.postOrder();
		System.out.println("breadthFirst Traversal:");
		minHeap.breadthFirst();
	}
		catch (IOException e) {
	}
  }
}
