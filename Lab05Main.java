/**
 * Lab 5
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 06/9/22
 * Lab05Main.java is designed to act as the main program where the Hash 
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

public class Lab05Main {
  
  public static void main(String [] args){
    System.out.println("Welcome to ADT Testing by Daniel Lam and Chitra Srinivasan.");
    System.out.println();
    Scanner sc = new Scanner(System.in);
    
    // Initializing HashTable with size 29 elements
    HashTable hashTable = new HashTable(29);
    
    hashTable.insert(new Dollar(57.12));
    hashTable.insert(new Dollar(23.44));
    hashTable.insert(new Dollar(87.43));
    hashTable.insert(new Dollar(68.99));
    hashTable.insert(new Dollar(111.22));
    hashTable.insert(new Dollar(44.55));
    hashTable.insert(new Dollar(77.77));
    hashTable.insert(new Dollar(18.36));
    hashTable.insert(new Dollar(543.21));
    hashTable.insert(new Dollar(20.21));
    hashTable.insert(new Dollar(345.67));
    hashTable.insert(new Dollar(36.18));
    hashTable.insert(new Dollar(48.48));
    hashTable.insert(new Dollar(101.00));
    hashTable.insert(new Dollar(11.00));
    hashTable.insert(new Dollar(21.00));
    hashTable.insert(new Dollar(51.00));
    hashTable.insert(new Dollar(1.00));
    hashTable.insert(new Dollar(251.00));
    hashTable.insert(new Dollar(151.00));
    
    System.out.println("Total dollar items loaded: " + hashTable.getDollarCount());
    System.out.println("Load Factor: " + hashTable.getLoadFactor());
    System.out.println("Number of collisions: " + hashTable.getCollisionsCount());
        
	double dollar;
	String answer;
	
	while(true){
		try {
			System.out.println("Please enter a dollar value to be searched: ");
			dollar = sc.nextDouble();
			int index = hashTable.findDollar(new Dollar(dollar));
			if( index != -1){
				System.out.println("Dollar found here at index: " + index);
				System.exit(0);
				break;
			} 
			else {
				System.out.println("Invalid Data.");
			}
			System.out.println("Do you want to check again or end the program?");
			System.out.println("'Y' to end search again or 'N' to end the program.");
			answer = sc.next();
			if(answer.equals("n") || answer.equals("N")){
				System.exit(0);
				break;
			}
		} catch (InputMismatchException e) {
			System.out.println("You did not enter a valid number: " + e.getMessage());
			sc.nextDouble();
		}
	
	}	
  }
}
