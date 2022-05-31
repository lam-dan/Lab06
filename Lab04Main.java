/**
 * Lab 4
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 5/29/22
 * Lab04Main.java is designed to act as the main program where the different sequence
 * of operations for Singly Linked List, Stack and Queue are performed on the Dollar and Pound objects, and the results
 * are printed to the console.
 */
 
import java.io.File;  // Import the File class
import java.io.IOException;  // Import the IOException class to handle errors
import java.io.FileWriter;   // Import the FileWriter class

public class Lab04Main {
  
  public static void main(String [] args){
    System.out.println("Welcome to ADT Testing by Daniel Lam and Chitra Srinivasan.");
    System.out.println();
    // Initializing Pound and Dollar in currencies array
    BST bst = new BST();
    
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
    
    System.out.println("Node 20:"+ node20.getData().toString());

    bst.insert(node1);
    bst.insert(node2);
    bst.insert(node3);
    bst.insert(node4);
    bst.insert(node5);
    bst.insert(node6);
    bst.insert(node7);
    bst.insert(node8);
    bst.insert(node9);
    bst.insert(node10);
    bst.insert(node11);
    bst.insert(node12);
    bst.insert(node13);
    bst.insert(node14);
    bst.insert(node15);
    bst.insert(node16);
    bst.insert(node17);
    bst.insert(node18);
    bst.insert(node19);
    bst.insert(node20);
   
   
    bst.inOrder();
    bst.preOrder();
    bst.postOrder();
    System.out.println("BST Search:" + bst.search(node20.getData()));
    
    
  }
	public void createFile() {
		try {
		  File myObj = new File("Lab04.txt");
		  if (myObj.createNewFile()) {
			System.out.println("File created: " + myObj.getName());
		  } else {
			System.out.println("File already exists.");
		  }
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}
	
	public void writeToFile(String string) {
		try {
		  FileWriter myWriter = new FileWriter("Lab04.txt");
		  myWriter.write(string);
		  myWriter.close();
		  System.out.println("Successfully wrote to the file.");
		} catch (IOException e) {
		  System.out.println("An error occurred.");
		  e.printStackTrace();
		}
	}
	


}
