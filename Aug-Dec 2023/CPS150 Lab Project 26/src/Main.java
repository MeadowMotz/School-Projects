
public class Main {
	public static void main(String[] args) {
		Door[] doors = new Door[3];
		
		doors[0] = new Door();
		doors[0].setName("Side");
		doors[0].open();
		
		doors[1] = new Door();
		doors[1].setName("Front");
		doors[1].close();
		
		doors[2] = new Door();
		doors[2].setName("Back");
		doors[2].close();
		
		for (Door el : doors) el.output();
		
		for (Door el : doors) {
			if (el.isOpen()) el.close();
			else el.open(); }
		
		for (Door el : doors) el.output();
	}
} // end class Main
