import java.awt.image.BufferedImage;
import java.io.File;
import java.net.MalformedURLException;
import java.util.Timer;
import java.util.TimerTask;

import javax.imageio.ImageIO;

public class Main {

	private static int totalFrameCount = 0;
	public static BufferedImage characterImage = null;
	public static BufferedImage obstacleImage = null;
	public static BufferedImage screenImage = null;
	
	public static int score = 0;
	public static Character c;
	public static Obstacle o;
	
	public static boolean flying = false;
	
	public static boolean gameGoing = true;
	
	public static void main(String[] args) throws InterruptedException, MalformedURLException {
		// TODO Auto-generated method stub
		try {
			characterImage = ImageIO.read(new File("pogojump2.png"));
			obstacleImage = ImageIO.read(new File("rock.png"));
			screenImage = ImageIO.read(new File("forest.png"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Could not load image.");
		}
		
c = new Character();
o = new Obstacle();
Window w = new Window(c, o);

//while (true){
	//c.update();
	//o.update();
	//w.Paintscreen();
	//Thread.sleep(10);
//}

TimerTask updateFPS = new TimerTask() {
    public void run() {

System.out.println(totalFrameCount);
totalFrameCount = 0;
    }
};

Timer t = new Timer();
t.scheduleAtFixedRate(updateFPS, 1000, 1000);
boolean running = true;

while (running) {
	if (gameGoing) {
		c.update();
		o.update();
	}
	w.Paintscreen();
	Thread.sleep(10);
    totalFrameCount++;
}
	}

	public static void gameOver() {
		gameGoing = false;
	}
	
	public static void reset() {
		if (!gameGoing) {
			o.setx(683);
			o.sety(294);
			o.setxv(o.getRockVelocity());
			c.setx(0);
			c.sety(294);
			c.setyv(0);
			gameGoing = true;
			score = 0;
		}
	}
}
