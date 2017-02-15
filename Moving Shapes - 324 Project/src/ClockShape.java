import java.awt.*;

/**
 * 
 * @author Matt W
 * @date 3-23-15
 * @version 1.0
 * 
 * ClockShape class creates a clock to be added to the ArrayList and painted on the icon
 * 
 */	
public class ClockShape implements MoveableShape {

	/**
	 * set the location of the clock shape and it's width
	 * @param x the x coordinate for the shape
	 * @param y the y coordinate for the shape
	 * @param width the width of the shape
	 */
	public ClockShape(int x, int y, int width){
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	/**
	 * move the clock shape across the screen
	 * @param dx the speed at which the shape is moved across the x-axis
	 * @param dy the speed at which the shape is moved across the y-axis
	 */
	public void translate(int dx, int dy){
		//makes the clock wrap around the screen
		if (x > 420){
			x = -50;
		}
		x += dx;
		y += dy;
	}

	/**
	 * draws the clock using shapes
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2) {
		//creates a circle for the background of the clock
		g2.setColor(Color.WHITE);
		g2.fillArc(x, y, 70, 70, 360, 360);
		//creates minute hand using rectangle
		g2.setColor(Color.black);
		g2.fillRect(x + 34, y + 10, 2, 30);
		//creates hour hand using rectangle
		g2.setColor(Color.ORANGE);
		g2.fillRect(x + 34, y + 35, 23, 2);
		
	}
	
	//int variables for the location and width of the shape
	private int x;
	private int y;
	private int width;
}
