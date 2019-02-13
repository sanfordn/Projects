package gamecomponents;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
	//List of development cards
	private String[] cards = null;
	
	
	public DevelopmentCard(int s, int o, int h) {
		sheep = s;
		ore = o;
		hay = h;
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
	public void getRoadCard() {
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
	public String buyDevelopmentCard(int amount) {
		//we could either leave out amount and have them buy a development
		//card one by one or we could use amount so our agent could buy as many at one time
		if ( (sheep - amount) >=0 && (hay - amount) >=0 && (ore - amount) >= 0) {
			Random randnum = new Random();
			//get size of list, if we have 0 of a card, the size decreases
			List currentCards = checkCardsLeft();
			//0 - n, n is how many types are left
			int randNum = randnum.nextInt(currentCards.size());
			//get random integer 0-n and pick that from our current cards
			String acard = (String) currentCards.get(randNum);
			System.out.println("You just got " + acard);	
			
			//calls the get functions from earlier
			if (acard == "Knight") {
				getKnightCard();
			}	
			if (acard == "Victory Point") {
				getVictoryPointCard();
			}	
			if (acard == "Road") {
				getRoadCard();
			}	
			if (acard == "Monopoly") {
				getMonopolyCard();
			}	
			if (acard == "Year of Plenty") {
				getYearOfPlentyCard();
			}	
			//return type of card to inventory?
			return acard;			
			
		} else {
			System.out.println("Insufficient funds");
			return "";
		}
	}
	
	public List checkCardsLeft() {
		
		//we have to check to make sure we dont try and grab
		//a dev card that equals 0 
		//5 is the max amount of cards we can have
		List<String> cards = new ArrayList<String>();
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
	
	public String[] checkCards() {
		return cards;
	}
	
}