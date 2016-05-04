package controller.builder;

/**
 * This is abstract class for builder move.
 * @author Team Nastes
 *
 */
public abstract class BuilderMove {
	
	/**
	 * Execute the move
	 * @return if the move can be executed or not
	 */
	abstract public boolean doMove();
	
	/**
	 * Undo the move
	 * @return true
	 */
	abstract public boolean undo();
	/**
	 * Check if the move is valid
	 * @return if the move is valid
	 */
	abstract public boolean valid();
}
