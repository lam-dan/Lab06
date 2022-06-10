/**
 * Use the same input seed data you used for Lab 4 (your BST homework) as seed input data into a hash table.
 * Declare a hash table of size 29 elements.
 * To hash your currency objects into the hash table, 
 * use the pseudorandom hash scheme - (m*w +  n*f) % size - where size = 29, 
 * m = 2, n = 3, w = whole value, f = fractional value.
 * For collision resolution, use quadratic probing in the same direction always. Remember to circle around to the start of the array if needed.
 * Your main will first load the data into the hash table and print the number of data items loaded, load factor and number of collisions. 
 * Then it will ask the user in a loop to enter a Dollar to search for. If the Dollar object is found in the hash table, it will print the index where found, otherwise it will print 'Invalid Data'. Then it will ask the user if they want to check again or end the program.
 * To submit, upload your code files and screenshot of the console only.
 * For documentation, only name blocks and existing documentation in your Dollar class are needed.
 * */
public class HashTable{
	Dollar hash[];
	int count;
	int size;
	int m;
	int n;
	
	public HashTable(int size){
		this.hash = new Dollar[size];
		this.count = 0;
		this.size = size;
		this.m = 2;
		this.n = 3;
	}
	
	/** Need to implement below pseudocode
	 * algorithm insert(key){  
    if (loadFactor > x(not sure what the factor is){
        resize()
    }

    hv = hash(key);

    if array[hv] is empty{
        insert key into array[hv]
    }
    otherwise{
        collisions++
        hash new key using quadratic probing
        for i < size{
            t = (hv + collisions * collisions) % size
            if array[t] is empty{
                insert key at array[t]
                break/return
            }
            otherwise
                collisions++;
                increment i

    }
    * 
    * 

	 * 
	 **/
	
	
	public void insert(HashTable hashTable, Dollar dollar){
		
		int w = dollar.getNoteValue();
		int f = dollar.getCoinValue();
		System.out.println("Note Value:" + w);
		System.out.println("Coin Value:" + f);
		
		// Hash function determines initial bucket
		
		this.hash[(( this.m * w )+ ( this.n * f )) % size] = dollar; 
		
		
		
		this.count++;
		
		    
	}

	public int getCount(){
		return count;	
	}
	
	/** TODO: implemnt resize() method
	 *resize()
	 * N is >= size * 2
	 * nearest prime number to N 
	 * 
	 * 
	 * 
	 **/
	


}
