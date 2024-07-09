package smelet01.hw3;
import java.awt.*;
/**
 *  This defines a simple class of critters the food that sit around waiting to be
 *  taken over by other critters.
 */
public class Food extends Critter {
	public Action getMove(CritterInfo info) {
		return Action.INFECT;
	}

	public Color getColor() {
		return Color.GREEN;
	}

	public String toString() {
		return "F";
	}
}
