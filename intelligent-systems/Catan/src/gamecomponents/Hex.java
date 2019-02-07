package gamecomponents;

import java.util.ArrayList;

public class Hex {
	private boolean robber = false;
	private int number = 0;
	private int tagval = -1;
	private ArrayList<Corner> corners = new ArrayList<Corner>();
	private ArrayList<Edge> edges = new ArrayList<Edge>();
	
	
	public Hex() {
		
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber( int num ) {
		number = num;
	}
	
	public boolean hasRobber() {
		return robber;
	}
	
	public void placeRobber( boolean setRob ) {
		robber = setRob;
	}
	
	public void setTag( int myTag ) {
		tagval = myTag;
	}
	
	public int tag() {
		return tagval;
	}
	
	
}
