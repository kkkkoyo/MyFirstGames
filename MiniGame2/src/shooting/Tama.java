package shooting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import gameListener.GameKeyLisener;
import panels.MainFrame;

public class Tama {
	private GameKeyLisener key;
	private MainFrame mf;
	private Game2 game2;
	private Player player;
	private int x;
	boolean tflag=false;
	private int bollx;
	private int bolly;
	private Teki teki;
	private int y=490;
	private int tekix;
	private boolean flag=false;
	BufferStrategy image1;
	BufferStrategy s;
	//private BufferStrategy bstrategy;

	
	public Tama(MainFrame mf,Player play,Graphics g,Teki teki,Game2 game2) {
		// TODO Auto-generated constructor stub
		this.mf=mf;
		this.player=play;
		this.teki=teki;
		this.game2=game2;
		
		key=new GameKeyLisener();
		this.mf.addKeyListener(key);
		bollx=player.getX();
		shootGraphics(g);
	}

public void shootGraphics(Graphics g) {
	if(tekix>=bollx-3&&tekix<=bollx+3&&y>190&&y<210) {
		game2.setFinish(true);
		
	}else{
		tekix=this.teki.getX();
		g.setColor(Color.red);
		y-=4;
		g.fillRect(bollx+25,y, 5, 10);
	}
	}
	
public Boolean soto(){
	if (y<100){
		return true;
	} else {
		return false;
	}
}
}

