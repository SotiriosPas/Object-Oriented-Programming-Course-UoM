import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private String name;
	
	Random randomnumber = new Random();
	
	public Deck(String aname) {
		name = aname;
	}
	
	public int DrawCard(ArrayList<Integer> adeck) {
		
		int card = 0;
		
		if(adeck.size()<2) {
			System.out.println("Sorry, your deck doesn't have enough cards! To keep playing, restart the game.");
			System.exit(0);
		}
		else {	
			int randomnum = randomnumber.nextInt(adeck.size());
			card = adeck.get(randomnum);
			adeck.remove(randomnum);
		}
		return card;
	}
	
}