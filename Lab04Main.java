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
    
    bst.insert(new Dollar(57.12));
    bst.insert(new Dollar(23.44));
    bst.insert(new Dollar(87.43));
    bst.insert(new Dollar(68.99));
    bst.insert(new Dollar(111.22));
    bst.insert(new Dollar(44.55));
    bst.insert(new Dollar(77.77));
    bst.insert(new Dollar(18.36));
    bst.insert(new Dollar(543.21));
    bst.insert(new Dollar(20.21));
    bst.insert(new Dollar(345.67));
    bst.insert(new Dollar(36.18));
    bst.insert(new Dollar(48.48));
    bst.insert(new Dollar(101.00));
    bst.insert(new Dollar(11.00));
    bst.insert(new Dollar(21.00));
    bst.insert(new Dollar(51.00));
    bst.insert(new Dollar(1.00));
    bst.insert(new Dollar(251.00));
    bst.insert(new Dollar(151.00));
    
    bst.inOrder();
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
