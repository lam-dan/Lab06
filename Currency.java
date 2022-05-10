/**
 * Lab 2
 * @author Daniel Lam, Chitra Srinivasan
 * CS 22C
 * Date: 4/27/22
 * Currency.java is designed to act as a currency simulator, with two integer 
 * attributes noteValue and coinValue. This class has constructors, getters/setters and methods add, subtract, isEqual
 * and isGreater, which compare and manipulate different currency objects.
 */
public abstract class Currency {
	private int noteValue;
	private int coinValue;
	
	// Default constructor
	public Currency(){
		this.noteValue = 0;
		this.coinValue = 0;
	}
	
	
	// A normal parameterized constructor
	public Currency(double number){
		if(number < 0){
			throw new IllegalArgumentException("Currency value cannot be less than 0.");
		}
		int intValue = (int) number;
		this.noteValue = intValue;
		this.coinValue = (int) Math.round((100*(number - Math.floor(intValue))));
	}
	
	// Copy constructor
	Currency(Currency obj){
		this.noteValue = obj.noteValue;
		this.coinValue = obj.coinValue;
	}
	
	// Getters and Setters
	/**
	 * The getters for the Currency class get & read the coin (fraction) and note (whole) 
	 * values so that they can be manipulated in add/subtract/isEqual/isGreater methods,
	 * and elsewhere in the program.
	 * 
	 * Pre: None
	 * Post: the value of the note and/or coin variable is returned.
	 */
	
	/**
	 * The setters for the Currency class update the coin (fraction) and note (whole) 
	 * values and set them so that they can be manipulated in add/subtract/isEqual/isGreater methods,
	 * and elsewhere in the program.
	 * 
	 * Pre: number: Check to see if the number is greater than 0.
	 * Post: The value of the note and/or coin variable is updated/set.
	 */
	public void setNoteValue(int number){
		if(number > 0){
			this.noteValue = number;
		}
	}
	
	public int getNoteValue(){
		return noteValue;
	}
	
	public void setCoinValue(int number){
		if(number > 0){
			this.coinValue = number;
		}
	}
	
	public int getCoinValue(){
		return coinValue;
	}
	
	// Additions & Subtractions
	/**
	 * The add method adds an input object (called obj) of the same currency.
	 * 
	 * Pre: Check to see if the coinValue is greater than or equal to 100. If it is,
	 * the noteValue is incremented, and the coinValue gets updated to be the remainder 
	 * of coinValue divided by 100.
	 * Post: The input object is added and the value of noteValue and coinValue is updated.
	 */
	public void add(Currency obj){
		this.noteValue += obj.noteValue;
		this.coinValue += obj.coinValue;
		if(this.coinValue >= 100){
			this.noteValue ++;
			this.coinValue = this.coinValue % 100;
		}
	}
	
	/**
	 * The subtract method subtracts an input object (called obj) of the same currency.
	 * 
	 * Pre: Check to see if the value of noteValue and coinValue is not greater than and equal to 
	 * the currency obj. If it is, then it is an invalid subtraction, and the "Invalid subtraction"
	 * message is printed out to the console.
	 * Post: The input object is subtracted and the value of noteValue and coinValue is updated.
	 */
	public void subtract(Currency obj){
		if (!this.isGreater(obj) && !this.isEqual(obj)) {
			System.out.println("Invalid subtraction");
            return;
        }
        this.noteValue -= obj.noteValue;
        this.coinValue -= obj.coinValue;        
        if(this.coinValue < 0) {
			this.noteValue -= 1;
            this.coinValue += 100;
        }
	}
	
	// Comparison
	/**
	 * The isEqual method compares an input object of the same currency for equality
	 * or inequality.
	 * 
	 * Pre: Check to see if the value of noteValue and coinValue is equal to 
	 * the note and coin value of currency obj.
	 * Post: If the values of the input object and noteValue and coinValue are equal
	 * then true is returned, otherwise false is returned.
	 */
	public boolean isEqual(Currency obj){
		if(this.noteValue == obj.noteValue && this.coinValue == obj.coinValue){
			return true;
		} else {
			return false;
		}
	}
	
	
	/**
	 * The isGreater method compares an input object of the same currency to see
	 * which object is larger or smaller.
	 * 
	 * Pre: Check to see if the value of noteValue and coinValue is less than or greater
	 * than the note and coin value of currency obj.
	 * Post: If the values of the input object and noteValue and coinValue are greater than
	 * the note and coin value of currency obj, true is returned, otherwise false is returned.
	 */
	public boolean isGreater(Currency obj){
		if(this.noteValue > obj.noteValue) {
			return true;
		} 
		else if (this.noteValue < obj.noteValue){
			return false;
		}
		else if (this.coinValue > obj.coinValue){
			return true;
		}
		else if (this.noteValue < obj.noteValue){
			return false;
		} 
		else {
			return false;
		}
	}
	
	/**
	 * The print method prints the name and value of the currency object in the form xx.yy, 
	 * followed by either dollar or pound, whichever is specified.
	 * 
	 * Change for Lab 3: Changed return type to String to use in SinglyLinkedList
	 * Pre: None
	 * Post: The name and value of the currency object is printed, along with the appropriate currency name.
	 */
	public String toString(){
		String coinString = String.valueOf(this.coinValue);
		if(this.coinValue == 0){
			coinString = "00";
		}
		else if( coinString.length() > 2){
			coinString = coinString.substring(coinString.length() - 2);
		}
		return this.noteValue + "." + coinString + "	";
	}
}
