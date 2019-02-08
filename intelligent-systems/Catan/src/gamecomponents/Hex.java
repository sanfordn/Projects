package gamecomponents;

import java.util.ArrayList;

public class Hex {
	private boolean robber = false;
	private int number = 0;
	private int tagval = -1;
	private final char resource;
	private ArrayList<Hex> hexes;
	private float prob;
	
	
	public Hex(char hexResource, Hex w, Hex nw, Hex ne, Hex e, Hex se, Hex sw) {
		resource = hexResource;
		hexes = new ArrayList<Hex>(6);
		hexes.add(0,w);
		hexes.add(1,nw);
		hexes.add(2,ne);
		hexes.add(3,e);
		hexes.add(4,se);
		hexes.add(5,sw);
	}
	
	public Hex() {
		resource = 'n';
		hexes.add(0,null);
		hexes.add(1,null);
		hexes.add(2,null);
		hexes.add(3,null);
		hexes.add(4,null);
		hexes.add(5,null);
	}
	
	public Hex(char hexResource) {
		resource = hexResource;
		hexes.add(0,null);
		hexes.add(1,null);
		hexes.add(2,null);
		hexes.add(3,null);
		hexes.add(4,null);
		hexes.add(5,null);
	}
	
	public void setProbability(float hexProb) {
		prob = hexProb;
	}
	
	public float probability() {
		return prob;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber( int num ) {
		number = num;
	}
	
	public void setW(Hex myHex) {
		hexes.set(0, myHex);
	}
	
	public void setNW(Hex myHex) {
		hexes.set(1, myHex);
	}
	
	public void setNE(Hex myHex) {
		hexes.set(2, myHex);
	}
	
	public void setE(Hex myHex) {
		hexes.set(3, myHex);
	}
	
	public void setSE(Hex myHex) {
		hexes.set(4, myHex);
	}
	
	public void setSW(Hex myHex) {
		hexes.set(5, myHex);
	}
	
	public ArrayList<Hex> getNeighbors() {
		return hexes;
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
