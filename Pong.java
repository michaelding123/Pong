package pong;

import processing.core.PApplet;
import processing.core.PFont;

public class Pong extends PApplet {

	float ballX = 145;
	float ballY = 260;
	float rectX;
	float rectY = 470;
	float speedX = 4;
	float speedY = -5;
	private float rectHeight = 10;
	private float rectWidth = 60;
	int score = 0;
	PFont f;

	public void setup() {
		f = createFont("Arial", 16, true);
	}

	public void settings() {
		size (300, 500);
	}

	public void draw() {
		background(255, 255, 255);	
		ball();
		rectangle();
		textFont(f, 20);
		fill(0);
		text("Score:" + score, 20, 20);
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
		
		if(collision()) {
			speedX *= -1;
			speedY *= -1;
		}
	}
	
	public boolean collision() {
		//System.out.println("weghuqwerug");
		if(ballX >= rectX && ballX <= rectX + rectWidth && ballY >= rectY && ballY <= rectY + rectHeight) {
			score++;
			System.out.println("L:" + ballX);
			System.out.println(ballY);
			System.out.println(rectX);
			System.out.println(rectY);
			return true;
		}
		return false;
	}

	public void rectangle() {
		rect(rectX, rectY, rectWidth, rectHeight);
	}

	public static void main(String[] args) {
		PApplet.main("pong.Pong");
	}
	
	public void mouseMoved() {
		rectX = mouseX - 30;
	}

}








































