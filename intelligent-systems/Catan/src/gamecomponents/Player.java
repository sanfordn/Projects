package gamecomponents;
import java.util.Arrays;
import java.util.Random;

public class Player {
	private String name = "";
	private int number = -1;
	public Bank inventory = null;
	public DevelopmentCard devCards = null;
	private int vps = 0;
	private int knights = 0;
	public final int age;
	Random rand = new Random();
	
	//Ever player has these 
	private int roadsLeft = 15;
	private int settlementsLeft = 5;
	private int citiesLeft = 4;
	//Players "hand"
	private int roadsInHand = 0;
	private int settlementsInHand = 0;
	private int citiesInHand = 0;
	
	public Player(String playerName, int playerNum) {
		name = playerName;
		number = playerNum;
		inventory = new Bank( 0, 0, 0, 0, 0 );
		devCards = new DevelopmentCard(0,0,0);
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
	
	//returns the number of knights the player has
	public int checkKnights() {
		return knights;
	}
	
	//Buy a road
	public void buyRoad() {
		//gets current resources from inventory
		int[] tmp = inventory.checkResources();
		int tmpWood = Arrays.asList(tmp).indexOf(0);
		int tmpBrick = Arrays.asList(tmp).indexOf(1);
		
		if (tmpWood >=1 && tmpBrick >=1) {
			if (roadsLeft > 0) {
				//roads take 1 wood and 1 brick
				inventory.giveBrick(1);
				inventory.giveWood(1);
				roadsInHand = roadsInHand + 1;
				}
			else {
				System.out.println("You don't have any roads left to buy!");	
			}
		}
		else {
			System.out.println("Not enough resources!");
		}
	}
	
	//Buy a settlement
	public void buySettlement() {
		//gets current resources from inventory
		int[] tmp = inventory.checkResources();
		int tmpWood = Arrays.asList(tmp).indexOf(0);
		int tmpBrick = Arrays.asList(tmp).indexOf(1);
		int tmpSheep = Arrays.asList(tmp).indexOf(2);
		int tmpHay   = Arrays.asList(tmp).indexOf(4);
		
		if (tmpWood >=1 && tmpBrick >=1 && tmpSheep >=1 && tmpHay >=1) {
			if (settlementsLeft > 0) {
				//roads take 1 wood and 1 brick
				inventory.giveBrick(1);
				inventory.giveWood(1);
				inventory.giveSheep(1);
				inventory.giveHay(1);
				settlementsInHand = settlementsInHand +1;
				}
			else {
				System.out.println("You don't have any settlements left to buy!");	
			}
		}
		else {
			System.out.println("Not enough resources!");
		}
	}
	
	
	public void useDevelopmentCard(String acard) {
		//possible cards "Knight,Road,Monopoly, Year of Plenty"
		//Using Road
		if (acard == "Road") {
			//If a player has 2 or more roads not being used and not in hand
			if ((roadsLeft) >= 2) {
				roadsLeft = roadsLeft - 2;
				roadsInHand = roadsInHand + 2;
			}else {
				//if they don't then they have 1 road left
				roadsLeft = 0;
				roadsInHand = roadsInHand + 1;
				}
		}
	}
	
	
}
