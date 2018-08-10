package pong;

import java.util.Random;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Pong extends PApplet {
	
	PImage bg;
	int y;
	int low = 150;
	int high = 300;
	Random r = new Random();
	float ballX = r.nextInt(high - low) + low;
	float ballY = r.nextInt(high - low) + low;
	float rectX;
	float rectY = 480;
	float speedX = 9;
	float speedY = -8;
	private float rectHeight = 10;
	private float rectWidth = 60;
	int score = 0;
	PFont f;

	public void setup() {
		f = createFont("Arial", 16, true);
		bg = loadImage("wallpaper.jpg");
	}

	public void settings() {
		size (300, 500);
	}

	public void draw() {
		//background(255, 255, 255);	
		background(bg);
		ball();
		rectangle();
		textFont(f, 20);
		fill(75, 244, 66);
		text("Score:" + score, 20, 20);
	}

	public void ball() {
		stroke(75, 244, 66);
		fill(75, 244, 66);
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
			//System.out.println("L:" + ballX);
			//System.out.println(ballY);
			//System.out.println(rectX);
			//System.out.println(rectY);
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








































