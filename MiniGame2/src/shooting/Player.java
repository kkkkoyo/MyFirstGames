package shooting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import gameListener.GameKeyLisener;
import panels.MainFrame;

public class Player {
	/**GameKeyListener Class*/
	private GameKeyLisener key;
	private MainFrame mf;
	private Game2 game2;
	private int x=320;
	private int y=490;
	private int f=1;
	private int i=0;
	private Shoot shoot;
	private Player player;
	public Player(MainFrame mf,Game2 gp) {
		key=new GameKeyLisener();
		this.mf=mf;
		this.mf.addKeyListener(key);
		this.game2 = gp;
	}
	public void move(){
		if(key.isPlayerB_left_key_Pressed()){
			x-=5;
		}
		if(key.isPlayerB_right_key_Pressed()){
			x+=5;
		}
		
	}
	public int getX(){
		
		return this.x;
	}
public int getY(){
		y-=3;
		return this.y;
	}
public void setX(int x){
		
		this.x=x;
}
	public void playerGraphics(Graphics g) {

		g.setColor(Color.RED);
		g.fillRect(x,500, 50, 50);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Sanserif",Font.BOLD,40));
		g.drawString("a",x+15,535);
	}
	
}
