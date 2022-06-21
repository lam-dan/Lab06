/**
 * Use the same input seed data you used for Lab 4 (your BST homework) as seed input data into a hash table.
 * Declare a hash table of size 29 elements.
 * To hash your currency objects into the hash table, 
 * use the pseudorandom hash scheme - (m*w +  n*f) % size - where size = 29, 
 * 
 * m = 2, n = 3, w = whole value, f = fractional value.
 * For collision resolution, use quadratic probing in the same direction always. Remember to circle around to the start of the array if needed.
 * Your main will first load the data into the hash table and print the number of data items loaded, load factor and number of collisions. 
 * Then it will ask the user in a loop to enter a Dollar to search for. If the Dollar object is found in the hash table, it will print the index where found, otherwise it will print 'Invalid Data'. Then it will ask the user if they want to check again or end the program.
 * To submit, upload your code files and screenshot of the console only.
 * For documentation, only name blocks and existing documentation in your Dollar class are needed.
 * */
 import java.text.DecimalFormat;
 
public class HashTable{
	Dollar hashTable[];
	int count;
	int size;
	int m;
	int n;
	int totalCollisions;
	
	public HashTable(int size){
		this.hashTable = new Dollar[size];
		this.count = 0;
		this.size = size;
		this.m = 2;
		this.n = 3;
		this.totalCollisions = 0;
	}

	/**
	* The insert method takes a Dollar object as parameter and gets the key
	* from the dollar object, hashes the key, resizes based on load factor, 
	* inserts dollar object into the hash table based on the hashed key index and increases
	* count. If the hashtable does not contain any value from the calcualte hashKey, 
	* we will inser the new dollar object in there and increase count.
	* If the hashed table already contains a dollar object at the index hashed keys,
	* we will use the quadartic probing formula to generate a new hash key to be used to
	* insert into the hash table, however, if there is already a value at that hash key as well,
	* we will increase collisions to generate another hashKey.
	* Pre: 
	* Post: 
	*/
	public void insert(Dollar dollar){
		int newHashKey;
		int collisions;
		int w = dollar.getNoteValue();
		int f = dollar.getCoinValue();
		int hashKey = (( this.m * w )+ ( this.n * f )) % size;
		
		if( getLoadFactor() >= 0.75){
			resize();
		}

		if(this.hashTable[hashKey] == null){
			this.hashTable[hashKey] = dollar; 
			this.count++;
		} else {
			collisions = 1;
			totalCollisions++;
			//hash new key using quadratic probing
			for(int i = 0; i < this.size; i++){
				newHashKey = (hashKey + collisions * collisions) % this.size;
				if (this.hashTable[newHashKey] == null){
					this.hashTable[newHashKey] = dollar;
					this.count++;
                break;
                }
				else {
					collisions++;
					totalCollisions++;
				}
			}
		}
				    
	}
	
	//Getters
	
	public int getDollarCount(){
		return count;	
	}
	
	public double getLoadFactor(){
		double d = (double) getDollarCount()/getSize();
		double roundOff = Math.round(d * 100.0) / 100.0;
		return roundOff;
	}
	
	public int getCollisionsCount(){
		return totalCollisions;	
	}
	
	public int getSize(){
		return size;
	}
		
	/** resize() method
	 * N is >= size * 2
	 * nearest prime number to N 
	 **/

	/**
	* The resize method finds the newSize for the hash table using nextPrime
	* and the size of the current hash table times 2. It will create a new hash
	* table based on the new size and point this.hashTable to it. Then it will
	* attach copy over all the values from the old hash table to the new hash table.
	* Pre: 
	* Post: 
	*/ 
	 public void resize(){
		 int newSize = nextPrime(this.size * 2);
		 Dollar[] oldTable = this.hashTable;
		 this.hashTable = new Dollar[newSize];		 
		 
		 for ( int i = 0; i < oldTable.length; i++){
			 if(oldTable[i] != null){
				 insert(oldTable[i]);
			 }
		 }
		 oldTable = null;
	 }
	 
	/**
	* The nextPrime method takes a number as parameter and returns the 
	* next greater prime number.
	* Pre: 
	* Post: 
	*/
	 public static int nextPrime(int number){
		 number++;
		 for (int i = 2; i < number; i++) {
			 if( number % i == 0){
				 number++;
				 i = 2;
			 }
			 else {
				 continue;
			 }
		}
		return number;
	 }
	 
	/**
	* The search method takes a Dollar object as parameter and gets the key
	* from the dollar object, hashes the key, resizes based on load factor, 
	* inserts dollar object into the hash table based on the hashed key index, and increases
	* count. If the hash table contain this hashKey, we will return the hashKey, since 
	* it is the index of the hash table.
	* 
	* If the hashTable doesn't contain the hashKey, we will return -1.
	* 
	* Otherwise, we will use the quadartic probing formula to generate a new hash key to be used to
	* search the hash table, until we find a value and return the hashKey. We will continue
	* to increase collisions until it's found.
	* Pre: 
	* Post: 
	*/
	public int findDollar(Dollar dollar){
		int newHashKey;
		int collisions;
		int w = dollar.getNoteValue();
		int f = dollar.getCoinValue();
		int hashKey = (( this.m * w )+ ( this.n * f )) % size;
		
		if( getLoadFactor() >= 0.75){
			resize();
		}
		if(this.hashTable[hashKey] != null){
			return hashKey;
		} 
		else if(this.hashTable[hashKey] == null){
			return -1;
		}
		else {
			collisions = 1;
			//hash new key using quadratic probing
			for(int i = 0; i < this.size; i++){
				newHashKey = (hashKey + collisions * collisions) % this.size;
				if (this.hashTable[newHashKey] != null){
					return newHashKey;
                }
				else {
					collisions++;
				}
			}
		}
		return -1;
	}
	
	
}
