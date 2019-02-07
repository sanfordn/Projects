package gamecomponents;

import java.util.ArrayList;

public class Corner {
	
	private Hex hex1;
	private Hex hex2;
	
	public Corner(Hex sharedHex1, Hex sharedHex2) {
		hex1 = sharedHex1;
		hex2 = sharedHex2;
	}
	
	public ArrayList<Hex> sharedWith() {
		ArrayList<Hex> sharedHexs = new ArrayList<Hex>();
		sharedHexs.add(hex1);
		sharedHexs.add(hex2);
		return sharedHexs;
	}
	
}
