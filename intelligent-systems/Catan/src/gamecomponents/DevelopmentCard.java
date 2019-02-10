package gamecomponents;
import java.util.ArrayList;

public class DevelopmentCard {
	//These can be accessed from every player
	public int amount_K = 14;
	public int amount_VP = 5;
	public int amount_RB = 2;
	public int amount_MO = 2;
	public int amount_YoP = 2;
	//The players current resources
	private int sheep = 0;
	private int ore = 0;
	private int hay = 0;
	//Players knights or VP 
	private int knights = 0;
	private int VP = 0;


	public DevelopmentCard(int s, int o, int h) {
		sheep = s;
		ore = o;
		hay = h;
		knights = 0;
		VP = 0;	
	}
	
	//decrements amount of Knight cards by 1
	public void getKnightCard() {
		amount_K = amount_K - 1;
	}
	
	//decrements amount of Victory Point Cards by 1
	public void getVictoryPointCard() {
		amount_VP= amount_VP - 1;
	}
	
	//decrements amount of Road Building Cards by 1
	public void getRoadBuildingCard() {
		amount_RB = amount_RB - 1;
	}
	
	//decrements amount of Monopoly cards by 1
	public void getMonopolyCard() {
		amount_MO = amount_MO - 1;
	}
	
	//decrements amount of Year of Plenty cards by 1
	public void getYearOfPlentyCard() {
		amount_YoP = amount_YoP - 1;
	}
	
	//This is to buy a development card
	public void buyDevelopmentCard(int amount) {
		//we could either leave out amount and have them buy a development
		//card one by one or we could use amount so our agent could buy as many at one time
		if ( (sheep - amount) >=0 && (hay - amount) >=0 && (ore - amount) >= 0) {
			System.out.println("You just bought a Develpoment card");
			
			//Whats left to do
			//  1. Grab the amount of cards we have left with our checkCardsLeft()
			//  2. Figure out how to call one of the get functions above
			//  3. return that to player. 
			
			
		} else {
			System.out.println("Insufficient funds");
		}
		
		
	}
	
	public ArrayList checkCardsLeft() {
		
		//we have to check to make sure we dont try and grab
		//a dev card that equals 0 
		//5 is the max amount of cards we can have
		ArrayList<String> cards = new ArrayList<String>(5);
		if (amount_K > 0) {
			cards.add("Knight");
		}
		if (amount_VP > 0) {
			cards.add("Victory Point");
		}
		if (amount_RB > 0) {
			cards.add("Road");
		}
		if (amount_MO > 0) {
			cards.add("Monopoly");
		}
		if (amount_YoP > 0) {
			cards.add("Year of Plenty");
		}
		return cards;	
	}
	
	
	
	
	
	
	
	

}
