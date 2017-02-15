import java.awt.*;

/**
 * 
 * @author Matt W
 * @date 3-23-15
 * @version 1.0
 * 
 * Movable shape interface allows shapes to be drawn and moved
 * 
 */
public interface MoveableShape {

	/**
	 * Draws the shape
	 * @param g2 the graphics context
	 */
	void draw(Graphics2D g2);
	
	/**
	 * Moves the shape by a given amount
	 * @param dx the amount to translate in the x-direction
	 * @param dy the amount to translate in the y-direction
	 */
	void translate(int dx, int dy);
}
