
public class Door {
	private String name;
	private boolean state; // true:open, false:closed
	
	public void setName(String n) {
		name = n;
	} // end setName
	
	public boolean isOpen() {
		return state;
	} // end isOpen
	
	public void open() {
		state = true;
	} // end open
	
	public void close() {
		state = false;
	} // end close
	
	public void output() {
		System.out.print(name);
		System.out.print(": ");
		if (state) System.out.println("open");
		else System.out.println("closed");
	} // end output
} // end class Door
