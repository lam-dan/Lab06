/**
 * Lab 2
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 4/27/22
 * Dollar.java is designed to act as a derived class from Currency. This class 
 * creates a Dollar object that can be manipulated. 
 */
public class Dollar extends Currency{
	private String name;
	
	public Dollar(){
		this.name = "Dollar";	
	}
	
	public Dollar(double number) {
        super(number);
        this.name = "Dollar";
    }
    
    public Dollar(Currency obj) {
		super(obj);
		this.name = "Dollar";
    }
    
 // Getters and Setters
 	/**
 	 * The getter for the Dollar class get & read the currency name which is dollar
 	 * so that they can be manipulated in add/subtract/isEqual/isGreater methods, and elsewhere in the program.
 	 * 
 	 * Pre: None
 	 * Post: the currency name "Dollar" is returned
 	 */
    public String getName() {
        return name;
    }
    
    /**
	 * The add method adds an input object (called obj) of the currency Dollar.
	 * 
	 * Pre: Check to see if the currency name of the input object is the same
	 * as "Dollar". If it is not, "Invalid addition" is printed to the console.
	 * Post: The input object is added
	 */
    @Override
    public void add(Currency obj) {
		if(!obj.getClass().getName().equals(this.getName())){
            System.out.println("Invalid addition.");
            return;
        }        
        super.add(obj);
    }
    
    /**
	 * The subtract method subtracts an input object (called obj) of the currency Dollar.
	 * 
	 * Pre: Check to see if the currency name of the input object is the same
	 * as "Dollar". If it is not, "Invalid subtraction" is printed to the console.
	 * Post: The input object is subtracted
	 */
    @Override
    public void subtract(Currency obj) {
        if(!obj.getClass().getName().equals(this.getName()) ){
            System.out.println("Invalid subtraction.");
            return;
        }
        super.subtract(obj);
    }
    
    /**
	 * The isGreater method compares an input object of the same currency to see
	 * which object is larger or smaller.
	 * 
	 * Pre: None
	 * Post: Returns true if the input object of type Dollar currency is greater than
	 * the value of the parent class object.
	 */
    @Override
    public boolean isGreater(Currency obj) {
        return super.isGreater(obj);
    }

    /**
	 * The isEqual method compares an input object of the currency Dollar for equality
	 * or inequality.
	 * 
	 * Pre: None
	 * Post: Returns true if the input object is of type Dollar currency.
	 */
    @Override
    public boolean isEqual(Currency obj) {
        return super.isEqual(obj);
    }
    
    /**
	 * The print method prints the name and value of the dollar currency object in the form xx.yy, 
	 * followed by dollar
	 * 
	 * Pre: None
	 * Post: The name and value of the currency object is printed, along with dollar as the currency name.
	 */
    @Override
    public void print() {
		super.print();
		System.out.print(" " + this.getName() + " ");
	}
	

	
}
