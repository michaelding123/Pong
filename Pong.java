package pong;

import processing.core.PApplet;

public class Pong extends PApplet {

	boolean moving = false;
	float ballX = 145;
	float ballY = 260;
	float rectX;
	float rectY = 480;
	float speedX = 4;
	float speedY = -5;
	private float rectHeight = 10;
	private float rectWidth = 80;

	public void setup() {

	}

	public void settings() {
		size (300, 500);
	}

	public void draw() {
		background(255, 255, 255);
		ball();
		rectangle();
	}

	public void ball() {
		stroke(0);
		fill(0);
		ellipse(ballX, ballY, 10, 10);
		ballX += speedX;
		ballY += speedY;
		
		if(ballX >= 295 || ballX <= 5) {
			speedX *= -1;	
		} 
		if(ballY <= 5) {
			speedY *= -1;
		}
		if(ballY >= 493) {
			speedX = 0;
			speedY = 0;
		}
		
		/*if(collision()) {
			speedX *= -1;
			speedY *= -1;
		}*/
	}
	
	/*public boolean collision() {
		if(ballX >= rectX && ballX <= rectX + height && ballY >= rectY && ballY <= rectY + width) {
			return true;
		}
		return false;
	}*/

	public void rectangle() {
		rect(rectX, rectY, rectWidth, rectHeight);
	}

	public static void main(String[] args) {
		PApplet.main("pong.Pong");
	}
	
	public void mouseMoved() {
		rectX = mouseX - 40;
	}

}








































