package smelet01.hw3;

import java.awt.*;

/**
 * Giant class represents the critter Giant on the table.
 * Implements his color , moves/actions and the display name on the table 
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Giant extends Critter {
	private int countSteps;
	private int count4Name;
	private Color GColor;

	/**
	 * Giant constructor.
	 * initializes to counters one the general step counter and one counter so it knows when the name will change
	 */
	public Giant() {
		this.count4Name=1;
		this.countSteps=1;
	}

	/**
	 * Gets color for the critter.
	 * The Giant stays the same color grey
	 * @return returns color 
	 */
	public Color getColor() {
		return this.GColor=Color.GRAY;
	}

	/**
	 * Action center.
	 * Infect if an enemy is in front
	 * Otherwise hop if possible
	 * Otherwise turn right.
	 *@return returns the actions that the critter will do on every step 
	 */
	public Action getMove(CritterInfo info) {
		countSteps++;
		//if (info.frontThreat())
		if(info.getFront()==Neighbor.OTHER)	
			return Action.INFECT;
		else if (info.getFront() == Neighbor.EMPTY)
			return Action.HOP;
		else
			return Action.RIGHT;
	}

	/**
	 * toString method to represent the critter on the table.
	 * every 6 steps the character changes form fee to fie to foe to fum and repeat  
	 * @return returns the character that is assigned to the critter
	 */
	public String toString() {
		if (countSteps <= 6)
			return "fee";
		else if (countSteps <= 12)
			return "fie";
		else if (countSteps <= 18)
			return "foe";
		else {
			count4Name++;
			if (count4Name % 6 == 0) // this resets steps so it can start again from the "fee"
				countSteps = 1;
			return "fum";
		}
	}

}
