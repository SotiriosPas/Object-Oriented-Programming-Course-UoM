
public class Check {

	private String name;
	
	public Check(String name){
		this.name = name;
	}
	
	public boolean CheckTotalForPlayer(int total){
		
		if(total==21) {
			System.out.println("Blackjack! You win!");
			return false;
		}
		else if(total>21) {
			System.out.println("Your total is over 21! The Dealer wins!");
			return false;
		}
		return true;	
	}

	public boolean CheckTotalForDealer(int total){
		
		if(total==21) {
			System.out.println("Blackjack! Dealer wins!");
			return false;
		}
		else if(total>21) {
			System.out.println("The Dealer's total is over 21! You win!");
			return false;
		}
		return true;	
	}

	public void CheckBothTotals(int ptotal,int dtotal){
		
		if(dtotal>=ptotal) System.out.println("Dealer's total is bigger than yours! Dealer wins!"); 
		else System.out.println("Your total suprasses the Dealer's! You win!");
	
	}
	
}