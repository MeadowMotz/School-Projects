
public class VendingMachine {
	// 27.3
	private int cans;
	private int tokens;
	
	// extra
	public VendingMachine() {
		cans = 0;
		tokens = 0;
	}
	
	
	public void insertToken() {
		// 27.4
		if (cans<=0) {
			System.err.println("Sold out.");
			return;	}
		cans--;
		tokens++;
	} // end dispense
	
	public void fillUp(int newCans) {
		// 27.5
		cans += newCans;
	} // end fillUp

	public int getCanCount() {
		// 27.6
		return cans;
	}
	
	public int getTokenCount() {
		// 27.6
		return tokens;
	}
}