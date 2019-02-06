package gamecomponents;

public class Bank {
	private int wood = 0;
	private int brick = 0;
	private int sheep = 0;
	private int ore = 0;
	private int hay = 0;
	
	public Bank(int w, int b, int s, int o, int h) {
		wood = w;
		brick = b;
		sheep = s;
		ore = o;
		hay = h;
	}
	
	//increments wood count by amount
	public void getWood(int amount) {
		wood = wood + amount;
	}
	
	//increments brick count by amount
	public void getBrick(int amount) {
		brick = brick + amount;
	}
	
	//increments sheep count by amount
	public void getSheep(int amount) {
		sheep = sheep + amount;
	}
	
	//increments ore count by amount
	public void getOre(int amount) {
		ore = ore + amount;
	}
	
	//increments hay count by amount
	public void getHay(int amount) {
		hay = hay + amount;
	}
	
	//decrements wood count and returns amount given
	public int giveWood(int amount) {
		if( (wood - amount) >= 0) {
			wood = wood - amount;
			return amount;
		} else {
			System.out.println("Insufficient wood");
			return 0;
		}
	}
	
	//decrements brick count and returns amount given
	public int giveBrick(int amount) {
		if( (brick - amount) >= 0) {
			brick = brick - amount;
			return amount;
		} else {
			System.out.println("Insufficient brick");
			return 0;
		}
	}
	
	//decrements sheep count and returns amount given
	public int giveSheep(int amount) {
		if( (sheep - amount) >= 0) {
			sheep = sheep - amount;
			return amount;
		} else {
			System.out.println("Insufficient sheep");
			return 0;
		}
	}
	
	//decrements ore count and returns amount given
	public int giveOre(int amount) {
		if( (ore - amount) >= 0) {
			ore = ore - amount;
			return amount;
		} else {
			System.out.println("Insufficient ore");
			return 0;
		}
	}
	
	//decrements hay count and returns amount given
	public int giveHay(int amount) {
		if( (hay - amount) >= 0) {
			hay = hay - amount;
			return amount;
		} else {
			System.out.println("Insufficient hay");
			return 0;
		}
	}
	
	public int[] checkResources() {
		int[] resources = new int[5];
		resources[0] = wood;
		resources[1] = brick;
		resources[2] = sheep;
		resources[3] = ore;
		resources[4] = hay;
		return resources;
	}
	
}
