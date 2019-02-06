package gamecomponents;

public class Hex {
	private boolean robber = false;
	private int number = 0;
	private int tagval = -1;
	
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
