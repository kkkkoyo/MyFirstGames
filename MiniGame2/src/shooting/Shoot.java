package shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.Timer;

import gameListener.GameKeyLisener;
import panels.MainFrame;

public class Shoot {
	private GameKeyLisener key;
	private MainFrame mf;
	private Game2 game2;
	private Player player;
	private int y=490;
	private int x;
	private Boolean flag;
	private int rensya=0;
	private Teki teki;
	BufferStrategy image;
	//private BufferImage image;
	ArrayList mytama;
	public Shoot(MainFrame mf,Player play,Teki teki,Game2 game2) {
		// TODO Auto-generated constructor stub
		this.mf=mf;
		this.player=play;
		this.teki=teki;
		this.game2=game2;
		key=new GameKeyLisener();
		this.mf.addKeyListener(key);
		mytama = new ArrayList();
		
	}
	
	public void shootmain(Graphics g){

		
		if(key.isPlayerA_left_key_Pressed()&&rensya==0){			
			Tama tama =new Tama(mf,player,g,teki,game2);
			
			mytama.add(tama);
			
			
		}
		rensya+=1;
		if(rensya>4) rensya=0;
		//表示
		//plaey.draw(g.mf);
		for(int i=0;i<mytama.size();i=i+1){
		Tama tm=(Tama)mytama.get(i);
		tm.shootGraphics(g);
		System.out.println(i);
		}

		Iterator it = mytama.iterator();
		while(it.hasNext()==true){
			
			Tama tam=(Tama)it.next();
			tam.shootGraphics(g);
			if(tam.soto()==true)it.remove();
		}

	}
	
	
	public void genkai(){
		if(player.getX()<0) player.setX(0);
	  	else if(player.getX()>650) player.setX(650);
		}
	public int getY(){
		return this.y;
	}
	
}
	

