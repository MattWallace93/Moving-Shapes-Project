import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

/**
 * 
 * @author Matt W
 * @date 3-23-15
 * @version 1.0
 * 
 * MultiShapeTest test creates the GUI and paints shapes onto
 * a panel using a timer to move them.
 * 
 */	
public class MultiShapeTest implements ActionListener{
	
	//Instantiate JFrames and JPanel
	private JFrame frame = new JFrame();
	private JFrame sub = new JFrame();
	private JPanel main = new JPanel(null);	
	
	//Instantiate JButton
	private JButton Show = new JButton("Show");
	private JButton Add = new JButton("Add");
	private JButton Remove = new JButton("Remove");
	private JButton Exit = new JButton("Exit");
	private JButton Hide = new JButton("Hide");
	private JButton SubExit = new JButton("Exit");
	
	//Instantiate JCheckBoxes
	private JCheckBox PlaneBox = new JCheckBox("Plane");
	private JCheckBox BoatBox = new JCheckBox("Boat");
	private JCheckBox ClockBox = new JCheckBox("Clock");
	
	//Instantiate an icon
	private ShapeIcon icon = new ShapeIcon(ICON_WIDTH, ICON_HEIGHT);
	
	//Instantiate a JLabel with the icon attached to it
	final private JLabel label = new JLabel(icon);
	
	//int variables to set the size of the icon
	private static final int ICON_WIDTH = 400;
	private static final int ICON_HEIGHT = 800;
	private static final int WIDTH = 100;
	
	//Declare a MoveableShape
	private MoveableShape shape;
	
	//Instantiate a random number generator 
	private Random rand = new Random();
	
	/**
	 * MultiShapeTest constructor creates the GUI and adds an ActionListener to it's components.
	 * It also creates a timer that repaints and moves the shape.
	 */
	public MultiShapeTest(){
	
		//Set various aspects of the JFrames
		frame.setSize(600, 400);
		frame.setTitle("Moving Shapes");
		sub.setSize(400, 800);
		sub.setLocation(500, 300);
		sub.setLayout(null);
		frame.add(main);
		
		//add buttons to the second JFrame
		sub.add(Hide);
		sub.add(SubExit);
		sub.add(label);
		
		//add buttons to the original JFrame
		main.add(Show);
		main.add(Add);
		main.add(Remove);
		main.add(Exit);
		main.add(PlaneBox);
		main.add(BoatBox);
		main.add(ClockBox);
		
		//set the location and size of the GUI's components
		label.setBounds(0, 30, 400, 800);
		Show.setBounds(50, 30, 100, 30);
		Add.setBounds(175, 30, 100, 30);
		Remove.setBounds(300, 30, 100, 30);
		Exit.setBounds(425, 30, 100, 30);
		PlaneBox.setBounds(100, 275, 100, 100);
		BoatBox.setBounds(250, 275, 100, 100);
		ClockBox.setBounds(400, 275, 100, 100);
		
		Hide.setBounds(75, 30, 100, 30);
		SubExit.setBounds(200, 30, 100, 30);
		
		//close the frame on exit
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//allow the frame to be seen
		frame.setVisible(true);
		
		//The plane box is selected by default
		PlaneBox.setSelected(true);
		
		//add ActionListener's to the buttons
		Show.addActionListener(this);
		Add.addActionListener(this);
		Remove.addActionListener(this);
		Exit.addActionListener(this);
		Hide.addActionListener(this);
		SubExit.addActionListener(this);
		
		//set a delay in milliseconds for the timer
		final int DELAY = 1;
		//Instantiate the timer using the delay and an actionPerformed method inside that continuously repaints the shape
		Timer timer = new Timer(DELAY, new ActionListener(){
			
			/**
			 * actionPerformed method repaints the shapes constantly
			 */
			public void actionPerformed(ActionEvent event){
				
				label.repaint();
			}
		});
		timer.start();
	}

	/**
	 * actionPerformed method checks which buttons are pressed using an ActionListener
	 * and performs certain tasks depending on the button.
	 */
	public void actionPerformed(ActionEvent e) {

		//if the show button is clicked the second JFrame becomes visible
		if (e.getSource() == Show){
			sub.setVisible(true);
			sub.setSize(400, 800);
		}
		
		//if the add button is clicked a shape is added according to which checkbox is selected
		if (e.getSource() == Add){
			sub.setVisible(true);
			
			//if the plane checkbox is selected a new plane shape is instantiated and added to an ArrayList. Then is painted onto the screen.
			if (PlaneBox.isSelected()){
			shape = new PlaneShape(0, rand.nextInt(570) + 30, WIDTH);
			icon.AddShapes(shape);
			label.repaint();
			}
			
			//if the plane checkbox is selected a new plane shape is instantiated and added to an ArrayList. Then is painted onto the screen.
			if (BoatBox.isSelected()){
			shape = new BoatShape(0, rand.nextInt(570) + 30, WIDTH);
			icon.AddShapes(shape);
			label.repaint();
			}
			
			//if the plane checkbox is selected a new plane shape is instantiated and added to an ArrayList. Then is painted onto the screen.
			if (ClockBox.isSelected()){
			shape = new ClockShape(0, rand.nextInt(570) + 30, WIDTH);
			icon.AddShapes(shape);
			label.repaint();
			}
		}
		
		//if remove button is clicked the most recent shape is removed from the screen and the ArrayList
		if (e.getSource() == Remove){
			
			//if the second JFrame isn't visible then shapes can't be removed
			if (sub.isVisible() == true){
			icon.RemoveShapes();
			label.repaint();
			}
		}
		
		//if Exit is clicked on the original JFrame the program terminates
		if (e.getSource() == Exit){
			System.exit(0);
		}
		
		//if the hide button is clicked the second JFrame is hidden from veiw and shapes halt
		if (e.getSource() == Hide){
			sub.setVisible(false);
		}
		
		//if the exit button is clicked on the second JFrame only the second JFrame closes and is reset with no shapes
		if (e.getSource() == SubExit){
			sub.setVisible(false);
			icon.Reset();
			label.repaint();
		}
		
	}

	
}
