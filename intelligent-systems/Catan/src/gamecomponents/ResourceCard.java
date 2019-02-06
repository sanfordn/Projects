package gamecomponents;

public class ResourceCard implements Card {
	private String strVal = "";
	@Override
	public String value() {
		return strVal;
	}

	@Override
	public void setValue(String val) {
		strVal = val;
	}

}
