import java.awt.*;
import java.awt.geom.*;

/**
 * 
 * @author Matt W
 * @date 3-23-15
 * @version 1.0
 * 
 * PlaneShape class creates a plane to be added to the ArrayList and painted on the icon
 * 
 */	
public class PlaneShape implements MoveableShape {

	/**
	 * Set the location of the plane shape and it's width
	 * @param x the x coordinate to be drawn at
	 * @param y the y coordinate to be drawn at
	 * @param width the width of the plane shape
	 */
	public PlaneShape(int x, int y, int width){
		this.x = x;
		this.y = y;
		this.width = width;
	}
	
	/**
	 * move the plane shape across the screen
	 * @param dx the speed at which the shape is moved across the x-axis
	 * @param dy the speed at which the shape is moved across the y-axis
	 */
	public void translate(int dx, int dy){
		//makes the plane wrap around the screen
		if (x > 420){
			x = -50;
		}
		x += dx;
		y += dy;
	}
	
	/**
	 * draws the plane by plotting points and drawing lines.
	 * @param g2 the graphics context
	 */
	public void draw(Graphics2D g2){
		//draw the plane using points
		GeneralPath p = new GeneralPath(GeneralPath.WIND_EVEN_ODD);
		p.moveTo(x, y - 10);
		p.lineTo(x + 10, y + 20);
		p.lineTo(x + 50, y + 20);
		p.lineTo(x + 60, y + 25);
		p.lineTo(x + 50, y + 30);
		p.lineTo(x + 10, y + 30);
		p.lineTo(x, y + 60);
		p.lineTo(x, y + 30);
		p.lineTo(x - 20, y + 30);
		p.lineTo(x - 30, y + 40);
		p.lineTo(x - 25, y + 30);
		p.lineTo(x - 25, y + 20);
		p.lineTo(x - 30, y + 10);
		p.lineTo(x - 20, y + 20);
		p.lineTo(x, y + 20);
		p.lineTo(x, y - 10);
		
		//draws and sets the plane to multiple colors using shapes within
		g2.draw(p);
		g2.setPaint(Color.BLUE);
		g2.fill(p);
		g2.setPaint(Color.RED);
		g2.fillRect(x, y + 20, 20, 10);
		g2.setPaint(Color.GREEN);
		g2.fillRect(x + 20, y + 20, 20, 10);
	}
	
	//int variables to hold the location and width of the shape
	private int x;
	private int y;
	private int width;
}
