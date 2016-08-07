import java.awt.Toolkit;
import java.io.File;
import java.net.MalformedURLException;

import javax.swing.JFrame;

public class Window extends JFrame {
	private Screen s;
	
public Window(Character c, Obstacle o) throws MalformedURLException{
	super();
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setSize(683, 384);
	this.setVisible(true);
	this.setResizable(false);
	
	this.add(s = new Screen(c, o));
	s.createBufferStrategy(2);

	    this.setIconImage(Toolkit.getDefaultToolkit().getImage(new File("title.png").toURL()));
	    this.setTitle("Bouncy Dwarf");
	
}

public void Paintscreen(){
	s.paint(s.getBufferStrategy().getDrawGraphics());
	s.getBufferStrategy().show();
}
}
