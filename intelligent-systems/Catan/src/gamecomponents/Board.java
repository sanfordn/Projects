package gamecomponents;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private char[] resources = { 'w', 'w', 'w', 'w', 'b', 'b' ,'b', 's', 's', 's', 's',
									'o', 'o', 'o', 'h', 'h', 'h', 'h', 'd'};
	private int[] numbers = {2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 11, 10, 9, 8, 6, 5, 4, 3, 0};
	private ArrayList<Hex> hexBoard = new ArrayList<Hex>();
	private Hex nullHex = new Hex();
	private Random rand = new Random();
	
	public Board() {
		//create board
		for(int i = resources.length, j = 0; i > 0; i--,j++) {
			int randi = rand.nextInt(i);
			Hex newHex;
			while (resources[randi] == 'n') {
				randi = rand.nextInt(i);
			}
			if (resources[randi] == 'd') {
				newHex = new Hex(resources[randi]);
				newHex.setNumber(numbers[18]);
				newHex.setProbability(0);
				numbers[18] = 1;
			} else {
				newHex = new Hex(resources[randi]);
				resources[randi] = 'n';
				randi = rand.nextInt(i);
				while (numbers[randi] <= 1) {
					randi = rand.nextInt(i);
				}
				newHex.setNumber(numbers[randi]);
				newHex.setProbability(numberProb(numbers[randi]));
				numbers[randi] = 1;
			}
			hexBoard.set(j,newHex);
		}
		for(int i = 0; i < hexBoard.size(); i++) {
			Hex changeHex = hexBoard.get(i);
			if(i < 3) {
				//top row
				changeHex.setNeighbors(
						null, //w
						nullHex, //nw 
						nullHex, //ne
						null, //e
						hexBoard.get(i+4), //se
						hexBoard.get(i+3)); //sw
				if(i == 0 || i == 1) {
					
				}
			} else if (i >= 3 && i < 7) {
				//2nd row
				
			} else if (i >= 7 && i < 12) {
				//3rd row
				
			} else if (i >= 12 && i < 16) {
				//4th row
				
			} else if (i >= 16 && i < 19) {
				//bottom row
				
			}
		}
		
	}
	/**
	 * 
	 * @param number
	 * @return the probability of rolling a number
	 */
	private float numberProb(int number) {
		if (number == 2) {
			return (1/36);
		} else if (number == 3 || number == 11) {
			return (2/36);
		} else if (number == 4 || number == 10) {
			return (3/36);
		} else if (number == 5 || number == 9) {
			return (4/36);
		} else if (number == 6 || number == 8) {
			return (5/36);
		} else {
			return 0;
		}
	}
}
