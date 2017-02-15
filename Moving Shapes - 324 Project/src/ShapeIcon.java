import java.awt.*;
import java.util.*;

import javax.swing.*;

/**
 * 
 * @author Matt W
 * @date 3-23-15
 * @version 1.0
 * 
 * ShapeIcon class implements the Icon class. This class creates and sets the size
 * of the icon. Shapes are added to this Icon and stored in an ArrayList.
 * 
 */	
public class ShapeIcon implements Icon{

	/**
	 * Sets the size of the Icon
	 * @param width the width of the icon
	 * @param height the height of the icon
	 */
	public ShapeIcon(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	/**
	 * Getter method to return the width of the icon
	 */
	public int getIconWidth(){
		return width;
	}
	
	/**
	 * Getter method to return the height of the icon
	 */
	public int getIconHeight(){
		return height;
	}
	
	/**
	 * Paints the icon onto the label and begins drawing the shapes in the ArrayList
	 */
	public void paintIcon(Component c, Graphics g, int x, int y){
		Graphics2D g2 = (Graphics2D) g;
		
		//paints the shapes within the ArrayList using a for loop
		for (MoveableShape shape: ShapeList){
			shape.translate(1, 0);
			shape.draw(g2);
		}
		
	}
	
	/**
	 * Adds shapes to an ArrayList
	 * @param shape the shape to be added to the ArrayList
	 */
	public void AddShapes(MoveableShape shape){
		ShapeList.add(shape);
		
	}
	
	/**
	 * Removes shapes from the ArrayList
	 */
	public void RemoveShapes(){
		//checks to see if there is something to be removed
		if (ShapeList.size() > 0){
		ShapeList.remove(ShapeList.size() -1);
		}
	}
	
	/**
	 * Clears the ArrayList
	 */
	public void Reset(){
		ShapeList.clear();
	}
	
	//int variables for the size of the icon
	private int width;
	private int height;
	
	//instantiate a new ArrayList of MovableShapes
	private ArrayList<MoveableShape> ShapeList = new ArrayList<MoveableShape>();
}
