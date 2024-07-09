package smelet01.hw3;

import java.awt.*;
import java.util.Random;
/**
 * Husky class represents the critter Husky on the table.
 * Implements his color , moves/actions and the display name on the table 
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Husky extends Critter {
	private int countSteps = 0;
	Random rng = new Random();
	private Color HColor;

	/**
	 * Husky constructor.
	 */
	public Husky() {}

	/**
	 * Gets color for the critter.
	 * The husky changes color randomly at every step
	 * @return returns the random color 
	 */
	public Color getColor() {
		int numC = rng.nextInt(5);
		if (numC == 0)
			return this.HColor = Color.MAGENTA;
		else if (numC == 1)
			return this.HColor = Color.WHITE;
		else if (numC == 2)
			return this.HColor = Color.RED;
		else if (numC == 3)
			return this.HColor = Color.BLUE;
		else 
			return this.HColor = Color.BLACK;
		
	}

	/**
	 * Action center.
	 * Infect if an enemy is in front
	 * if theres a wall on front and on your right turn left
	 * if theres a wall on front and on your left turn right
	 * if theres another husky in front turn left
	 * else hop 
	 *@return returns the actions that the critter will do on every step 
	 */
	public Action getMove(CritterInfo info) {
		countSteps++;
		//if (info.frontThreat()||info.leftThreat()||info.rightThreat())
		if(info.getFront()==Neighbor.OTHER)
			return Critter.Action.INFECT;
		else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
			return Critter.Action.LEFT;
		else if (info.getFront() == Neighbor.WALL || info.getLeft() == Neighbor.WALL)
			return Critter.Action.RIGHT;
		else if (info.getFront() == Neighbor.SAME)
			return Critter.Action.LEFT;
		else
			return Critter.Action.HOP;
	}
	
	
	/**
	 * toString method to represent the critter on the table.
	 * every step the character changes form ▲ to ▼ and repeat
	 * (because i put special characters to represent it if theres any problem during execution uncomment the code below) 
	 * @return returns the character that is assigned to the critter
	 */
	public String toString() {
		if (countSteps % 2 == 0)
			return "▲";
		else
			return "▼";
		
     //if theres any problem with those symbols change them with those below
		
//		if (countSteps % 2 == 0)
//			return "(";
//		else
//			return ")";		
	}

}
