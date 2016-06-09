package shooting;

import java.awt.Color;
import java.awt.Graphics;

import panels.MainFrame;

public class Wall {
	
	private int x;
	private int y;
	
	
	public Wall(int x,int y){
	
		this.x=x;
		this.y=y;
	}
	public void wallGraphics(Graphics g) {
		g.setColor(Color.gray);
		g.fillRect(this.x,this.y,60,20);
	}
	
}
