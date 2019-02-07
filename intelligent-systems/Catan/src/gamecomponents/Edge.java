package gamecomponents;

public class Edge {
	
	private Hex otherHex;
	
	public Edge(Hex sharedWithHex) {
		otherHex = sharedWithHex;
	}
	
	public Edge() {
		otherHex = null;
	}
	
	public Hex sharedWith() {
		return otherHex;
	}
}
