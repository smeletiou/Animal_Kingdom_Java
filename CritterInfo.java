package smelet01.hw3;

/** The CritterInfo interface defines a set of methods for querying the
* state of a critter simulation. 
*/
public interface CritterInfo {
    public Critter.Neighbor getFront();
    public Critter.Neighbor getBack();
    public Critter.Neighbor getLeft();
    public Critter.Neighbor getRight();
    public Critter.Direction getDirection();
    public boolean frontThreat();
    public boolean backThreat();
    public boolean leftThreat();
    public boolean rightThreat();
}
