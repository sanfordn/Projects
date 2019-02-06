package gamecomponents;
import java.util.Random;

public class Player {
	private String name = "";
	private int number = -1;
	public Bank inventory = null;
	private int vps = 0;
	public final int age;
	Random rand = new Random();
	
	public Player(String playerName, int playerNum) {
		name = playerName;
		number = playerNum;
		inventory = new Bank( 0, 0, 0, 0, 0 );
		age = rand.nextInt(100);
	}
	
	//returns name of player
	public String getName() {
		return name;
	}
	
	//returns player's number
	public int getNum() {
		return number;
	}
	
	//returns the number of victory points the player has
	public int checkVictoryPoints() {
		return vps;
	}
}
