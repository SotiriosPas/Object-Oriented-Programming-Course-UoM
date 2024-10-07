
public class Dealer {

	private String name;
	private int total;
	
	public Dealer(String aname) {
			name = aname;
			total = 0;
	}

	public void increasetotal(int acard){
		this.total = this.total + acard;
	}

	public int gettotal(){
		return total;
	}

	public void resettotal(){
		this.total = 0;
	}
	
}