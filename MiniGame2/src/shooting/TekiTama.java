package shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import gameListener.GameKeyLisener;
import panels.MainFrame;

public class TekiTama {
	
	private GameKeyLisener key;
	private MainFrame mf;
	private Game2 game2;
	private Player player;
	private int y=200;
	private int x;
	boolean tflag=false;
	private int bollx=0;
	private Teki teki;
	private int xleft;
	private int xright;

	
	BufferStrategy image1;
	BufferStrategy s;
	
	public TekiTama(MainFrame mf,Teki teki,Graphics g,Game2 game2,Player player) {
		// TODO Auto-generated constructor stub
		this.mf=mf;
		key=new GameKeyLisener();
		this.teki=teki;
		this.game2=game2;
		this.mf.addKeyListener(key);
		this.player=player;
		bollx=this.teki.getX();
		xleft=bollx+10;
		xright=bollx+30;
		x=this.player.getX();
		//shootGraphics(g);
	}


public void shootGraphics(Graphics g) {
	//System.out.println("py:x="+player.getX()+" >= "+(xleft-3));
	//System.out.println("py:x="+player.getX()+" < "+(xleft+3));
	if((player.getX()>=xleft-30&&player.getX()<xleft&&y+25>500&&y+25<530)||(player.getX()>=xright-30&&player.getX()<xright&&y+25>505&&y+25<530)||
			(player.getX()>=bollx-10&&player.getX()<bollx+10&&y+25>505&&y+25<530)){
	if(game2.getLife()>0){ 
	game2.setLife(-1);
	}
	}else{
	g.setColor(Color.BLUE);
	g.fillRect(xleft,y+25, 3, 10);
	g.fillRect(xright,y+25, 3, 10);
	g.fillRect(bollx+20,y+25, 3, 10);
	xleft-=1;
	xright+=1;
	y+=2;
	}
	}

public Boolean soto(){
	if ( y>550){
		return true;
	} else {
		return false;
	}
}
}