package shooting;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

import javax.swing.Timer;

import gameListener.GameKeyLisener;
import panels.MainFrame;

public class TekiShoot {
	private GameKeyLisener key;
	private MainFrame mf;
	private Game2 game2;
	private Player player;
	private int y=490;
	private int x;
	private Boolean flag;
	private Teki teki;
	private int rensya=0;
	BufferStrategy image;
	//private BufferImage image;
	ArrayList tama2;
	public TekiShoot(MainFrame mf,Teki teki,Game2 game2,Player player) {
		// TODO Auto-generated constructor stub
		this.mf=mf;
		this.game2=game2;
		this.player=player;
		key=new GameKeyLisener();
		this.mf.addKeyListener(key);
		tama2 = new ArrayList();
		this.teki=teki;
	}
	
	public void shootmain(Graphics g){
		if(rensya==0){
		TekiTama tekitama =new TekiTama(mf,teki,g,game2,player);
		tama2.add(tekitama);

		}
		rensya+=1;
		System.out.println(rensya);
		Random r = new Random();
		int j = r.nextInt(10);
		if(rensya>20&&j==0) rensya=-40;
		if(rensya>20) rensya=0;
		
		for(int i=0;i<tama2.size();i=i+1){
		TekiTama tm2=(TekiTama)tama2.get(i);
		System.out.println(i);
		tm2.shootGraphics(g);
		}
		Iterator it2 = tama2.iterator();
		
		while(it2.hasNext()==true){
			TekiTama tam2=(TekiTama)it2.next();
			tam2.shootGraphics(g);
			if(tam2.soto()==true)it2.remove();
		}
	}
	public int getY(){
		return this.y;
	}
	
}
	

