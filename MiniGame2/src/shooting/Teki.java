package shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Teki {
		
	private int tekix=600;
	private boolean flag;
	private int i=0;
	private Game2 game2;
	private int y=200;
	public Teki(Game2 game2) {

		// TODO Auto-generated constructor stub
		this.game2=game2;
	}
	
	public void move(){
		
		
		if(flag)tekix+=5;
		else tekix-=5;
		  Random r = new Random();
		boolean b = r.nextBoolean(); 
		if(i==0)flag=b;
		if(tekix<0){
			tekix=0;flag=true;
			}
		else if(tekix>650){
			tekix=650;flag=false;
			}
		i++;
		if(i>30) i=0;
	}
	
	public int getX(){
		return tekix;
	}
	
	public void tekiGraphics(Graphics g) {
		
		g.setColor(Color.BLUE);
		g.fillRect(tekix,y, 60, 10);
		g.setColor(Color.RED);
		g.fillRect(tekix+20,y,20, 10);
	}

}
