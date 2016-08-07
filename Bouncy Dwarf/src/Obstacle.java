
public class Obstacle {

private int x;
private int y;
private int xv;
private int yv;

private boolean addedScore = false;

public Obstacle() {
	this.x = 683;
	this.y = 294;
	this.xv = -8;
}
public int getx(){
	return x;
}
public int gety(){
	return y;
}
public void setyv(int v){
	yv = v;
}
public void setxv(int v){
	xv = v;	
	if(x==683){
		xv = v;
	}
}
public void setx(int x) {
	this.x = x;
}
public void sety(int y) {
	this.y = y;
}
public void update(){
	//System.out.println(x+" "+xv);
	x=x+xv;
	if (x < 0) {
		if (Main.c.gety() <= 244 && !addedScore) {
			Main.score += 5;
		} else {
			if (!addedScore) {
				Main.gameOver();
			}
		}
		addedScore = true;
	}
	if(x<-50){
		x=683;
		xv = -8;
		addedScore = false;
	}
}
}
