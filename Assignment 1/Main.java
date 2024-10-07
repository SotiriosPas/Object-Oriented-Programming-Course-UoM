import java.util.Scanner; 
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		String keepplaying;
		String answer = null;
		ArrayList<Integer> mydeck = new ArrayList<Integer>();
		Player player1 = new Player("You");
		Deck D = new Deck("deckmanager");
		Dealer dealer1 = new Dealer("Dealer");
		Check checker = new Check("check");
		Scanner in = new Scanner(System.in);
		
		System.out.println("Welcome to the simplified Blackjack game!");

		int d = 0;	
		int e = 2;
		
		while (d<40) {
			
			for (int f=0;f<4;f++) {
				mydeck.add(e);
				d++;	
			}
			e++;
		}
		
			int a,b,c,x;
			
			do {
				boolean flag1,answerflag = true;
				a = D.DrawCard(mydeck);
				player1.increasetotal(a);
			
				b = D.DrawCard(mydeck);
				player1.increasetotal(b);
			
				System.out.println("You get a " + a + " and a " + b);
				System.out.println("Your total is " + player1.gettotal());
			
				a = D.DrawCard(mydeck);
				dealer1.increasetotal(a);
				b = D.DrawCard(mydeck);
				dealer1.increasetotal(b); 
			
				System.out.println("The Dealer has a " + a + " showing, and a hidden card.");
				x = player1.gettotal();
				flag1 = checker.CheckTotalForPlayer(x);
				while (flag1) { 
					do {
					
						System.out.println("Would you like to “hit” or “stay”?");
					
						while (answerflag){
							answer = in.nextLine();
								if (answer.equals("hit") || answer.equals("stay")) {
									answerflag = false;
								}
								else System.out.println("Answer not valid. Type either “hit” or “stay”.");
						}
					
						if (answer.equals("hit")){
							c = D.DrawCard(mydeck);
							System.out.println("You drew a " + c);
							player1.increasetotal(c);
							System.out.println("Your new total is " + player1.gettotal());
							flag1 = checker.CheckTotalForPlayer(player1.gettotal());
						}
						else flag1 = false;
						answerflag = true;
					} while (flag1==true && answer.equals("hit"));
				}	
				
				if(player1.gettotal()>=21 && answer.equals("hit")) {
					System.out.println("Would you like to play again?");
					answerflag = true;
					do {
						keepplaying = in.nextLine();
						if (keepplaying.equals("y") || keepplaying.equals("n")) {
							answerflag = false;
						}
						else System.out.println("Answer not valid. Type either “y” or “n”.");
					   } while (answerflag);
					if (keepplaying.equals("n")) System.exit(0);
					else if(keepplaying.equals("y")) {
						dealer1.resettotal();
						player1.resettotal();
						continue;
						}
				}
				
				System.out.println("OK, dealer is playing.");
				System.out.println("His hidden card was a " + b);
				x = dealer1.gettotal();
				System.out.println("His total is " + x);
				flag1 = checker.CheckTotalForDealer(x);
				while (flag1) { 
					if(x<=16){
						System.out.println("Dealer chooses to hit.");
						c = D.DrawCard(mydeck);
						System.out.println("Dealer draws a " + c);
						dealer1.increasetotal(c);
						x = dealer1.gettotal();
						System.out.println("Dealer's new total is " + x);
						flag1 = checker.CheckTotalForDealer(x);
					}
					else {
						System.out.println("Dealer chooses to stay."); 
						flag1 = false;	
					}	
				}
				
				if(x<21) checker.CheckBothTotals(player1.gettotal(), x);
				System.out.println("Would you like to play again?");
				
				answerflag = true;
				do {
					keepplaying = in.nextLine();
					if (keepplaying.equals("y") || keepplaying.equals("n")) {
						answerflag = false;
					}
					else System.out.println("Answer not valid. Type either “y” or “n”.");
				   } while (answerflag);
			
			dealer1.resettotal();
			player1.resettotal();
				
			} while (keepplaying.equals("y"));
	
		}

	}