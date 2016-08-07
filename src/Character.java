
public class Character {
private int x;
private int y;
private int xv;
private int yv;

public Character() {
	this.x = 0;
	this.y = 294;
}
public int getx(){
	return x;
}
public int gety(){
	return y;
}
public void setxv(int v){
	xv = v;
}
public void setyv(int v){
	if (Main.flying) {
		yv = v;
	}
	if(y==294){
		yv = v;
	}
}
public void setx(int x) {
	this.x = x;
}
public void sety(int y) {
	this.y = y;
}
public void update(){
	//System.out.println(y+" "+yv);
	y=y+yv;
	yv = yv+3;
	if(y>294){
		y=294;
		yv = 0;
	}
}
}
