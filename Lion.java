package smelet01.hw3;

import java.awt.*;
import java.util.Random;

/**
 * Lion class represents the critter Lion on the table.
 * Implements his color , moves/actions and the display name on the table 
 * 
 * @author Sotiris Rafail Meletiou AM941797
 *
 */
public class Lion extends Critter {
	private Color lColor;
	private int countSteps;
	Random rng = new Random();

	/**
	 * Lion constructor.
	 * initializes step counter
	 */
	public Lion() {
		this.countSteps=0;
	}

	/**
	 * Gets color for the critter.
	 * The lion changes color randomly every three steps from red to blue to green
	 * @return returns the random color 
	 */
	public Color getColor() {
		if (countSteps % 3 == 0) { 
			int cstep = 0;
			while (cstep == 0) {// 0=Red 1=Green 2=Black
				int numC = rng.nextInt(3); 
				if (numC == 0 && this.lColor != Color.RED) 
					this.lColor = Color.RED;
				
				if (numC == 1 && this.lColor != Color.GREEN) 
					this.lColor = Color.GREEN;
				
				if (numC == 2 && this.lColor != Color.BLUE) 
					this.lColor = Color.BLUE;
				
				cstep++;
			}
		}
		return lColor;
	}

	/**
	 * Action center.
	 * Infect if an enemy is in front 
	 * Otherwise if a wall is in front or to the right, then turn left 
	 * Otherwise if a fellow Lion is in front, then turn right 
	 * Otherwise hop
	 *@return returns the actions that the critter will do on every step 
	 */
	public Action getMove(CritterInfo info) {
		countSteps++;
		//if (info.frontThreat())
		if(info.getFront()==Neighbor.OTHER)	
			return Critter.Action.INFECT;
		else if (info.getFront() == Neighbor.WALL || info.getRight() == Neighbor.WALL)
			return Critter.Action.LEFT;
		else if (info.getFront() == Neighbor.SAME)
			return Critter.Action.RIGHT;
		else
			return Critter.Action.HOP;
	}


	/**
	 * toString method to represent the critter on the table.
	 * @return returns the character that is assigned to the critter
	 */
	public String toString() {
		return "L";
	}
}