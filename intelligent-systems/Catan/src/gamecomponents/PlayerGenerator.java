package gamecomponents;
import java.util.Random;
import java.util.ArrayList;

public class PlayerGenerator {
	 private Random rand = new Random();
	 public final String name;
	 public final int age;
	 private NameList myNameList;
	 private int randNum = rand.nextInt(myNameList.names.length);
	 
	 public PlayerGenerator() {
		name = myNameList.names[randNum];
		age = rand.nextInt(100);
	 }
	 
}
