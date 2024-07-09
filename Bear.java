package smelet01.hw3;

import java.awt.*;
/**
 * Bear class represents the critter Bear on the table.
 * Implements his color , moves/actions and the display name on the table 
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Bear extends Critter {
	private boolean isPolar;
	private int countSteps;
	private Color BColor;
/**
 * Bear constructor.
 * Constructs a Bear critter to put on the table , initializes step counter  
 * and gets a random color(black or white) that will represent if it is a polar bear or a normal one 
 * @param polar this boolean parameter gets its info from the {@link CriiterModel} class to color the bear black or white
 */
	public Bear(boolean polar) {
		this.isPolar = polar;
		this.countSteps=1;
	}

	/**
	 *Gets the color for the critter.
	 *@return returns the color for the bear depends on the isPolar variable   
	 */
	public Color getColor() {
		if (this.isPolar == true)
			return this.BColor= Color.WHITE;
		else
			return this.BColor= Color.BLACK;
	}

	/**
	 * Action center.
	 * Infect if an enemy is in front
	 * Otherwise hop if possible 
	 * Otherwise turn left
	 *@return returns the actions that the critter will do on every step 
	 */
	public Action getMove(CritterInfo info) {
		countSteps++;
		//if (info.frontThreat()||info.leftThreat()||info.rightThreat())
		if(info.getFront()==Neighbor.OTHER)	
			return Critter.Action.INFECT;
		else if (info.getFront() == Neighbor.EMPTY)
			return Action.HOP;
		else
			return Critter.Action.LEFT;
	}

	/**
	 * toString method to represent the critter on the table.
	 * every step the character changes form / to \ and repeat  
	 * @return returns the character that is assigned to the critter
	 */
	public String toString() {
		if (countSteps % 2 == 0)
			return "\\";
		else
			return "/";
	}
}
