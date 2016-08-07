import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.Font;

public class Screen extends Canvas implements KeyListener{
	private Character c;
	private Obstacle o;
	
public void paint(Graphics g) {
	//System.out.println("Test");
		g.setColor(Color.BLUE);
		//g.fillRect(0, 0, 683, 384);
		((Graphics2D) g).drawImage(Main.screenImage, 0, 0, 683, 384, null);

		g.setColor(Color.GREEN);
		//g.fillRect(c.getx(), c.gety(), 31, 62);
		((Graphics2D) g).drawImage(Main.characterImage, c.getx(), c.gety(), null);
		
		//g.setColor(Color.GREEN);
		//g.fillRect(o.getx(), o.gety(), 50, 50);
		((Graphics2D) g).drawImage(Main.obstacleImage, o.getx(), o.gety(), 50, 50, null);
		
		g.setColor(Color.BLACK);
		g.setFont(g.getFont().deriveFont(15.0f));
		((Graphics2D) g).drawString("Score: " + Main.score, 5, 14);
		((Graphics2D) g).drawString("Flying " + (Main.flying ? "Enabled" : "Disabled"), 5, 30);
		
		if (!Main.gameGoing) {
			g.setColor(Color.RED);
			g.setFont(g.getFont().deriveFont(80.0f).deriveFont(Font.BOLD));
			((Graphics2D) g).drawString("GAME OVER", 85, 180);
			g.setFont(g.getFont().deriveFont(40.0f).deriveFont(Font.PLAIN));
			((Graphics2D) g).drawString("Press R to reset", 175, 250);
		}
	}
public Screen(Character c, Obstacle o){
	super();
	addKeyListener(this);
	this.c = c;
	this.o = o;
}

//public Screen(Obstacle o){
//	super();
//	addKeyListener(this);
//	this.o = o;
//}

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getKeyCode( ) == KeyEvent.VK_SPACE){
		c.setyv(-35);
		//System.out.println("Test");
	}
	if (arg0.getKeyCode() == KeyEvent.VK_HOME) {
		Main.flying = !Main.flying;
	}
	if (arg0.getKeyCode() == KeyEvent.VK_R) {
		Main.reset();
	}
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
}

