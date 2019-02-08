package gamecomponents;

import java.util.ArrayList;
import java.util.Random;

public class Board {
	private char[] resources = { 'w', 'w', 'w', 'w', 'b', 'b' ,'b', 's', 's', 's', 's',
									'o', 'o', 'o', 'h', 'h', 'h', 'h', 'd'};
	private int[] numbers = {2, 3, 4, 5, 6, 8, 9, 10, 11, 12, 11, 10, 9, 8, 6, 5, 4, 3 };
	private ArrayList<Hex> hexBoard = new ArrayList<Hex>();
	private Hex nullHex = new Hex();
	private Random rand = new Random();
	
	public Board() {
		//create board
		for(int i = resources.length, j = 0; i > 0; i--,j++) {
			int randi = rand.nextInt(i);
			Hex newHex = new Hex(resources[randi]);
			resources
			newHex.setProbability();
			hexBoard.set(j,newHex);
		}
	}
}
