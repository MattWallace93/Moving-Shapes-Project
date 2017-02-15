import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * @author Matt W
 * @date 3-23-15
 * @version 1.0
 * 
 * BoatShape class creates a plane to be added to the ArrayList and painted on the icon
 * 
 */	
public class BoatShape implements MoveableShape {

	/**
	 * Set the location of the boat shape and it's width
	 * @param x the x coordinate to be drawn at
	 * @param y the y coordinate to be drawn at
	 * @param width the width of the boat shape
	 */
	public BoatShape(int x, int y, int width){
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	/**
	 * move the boat shape across the screen
	 * @param dx the speed at which the shape is moved across the x-axis
	 * @param dy the speed at which the shape is moved across the y-axis
	 */
	public void translate(int dx, int dy){
		//makes the boat wrap around the screen
		if (x > 420){
			x = -50;
		}
		x += dx;
		y += dy;
	}

	/**
	 * draws the boat by combining shapes with plotted points and drawn lines
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2) {
		//draw the triangular sale for the boat
		GeneralPath p = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		p.moveTo(x + 20, y - 30);
		p.lineTo(x + 40, y - 10);
		p.lineTo(x + 20, y - 10);
		
		//sets the sale to yellow
		g2.setColor(Color.YELLOW);
		g2.fill(p);
		g2.draw(p);
		
		//draw a red mask for the boat
		g2.setPaint(Color.RED);
		g2.fillRect(x + 20, y - 30, 2, 30);
		
		//draw a magenta bottom for the boat
		g2.setPaint(Color.magenta);
		g2.fillArc(x + 5, y - 20, 35, 35, 180, 180);
	}
	
	//int variables for the location and width of the shape
	private int x;
	private int y;
	private int width;
}
