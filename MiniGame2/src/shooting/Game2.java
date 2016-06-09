package shooting;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import gameListener.GameKeyLisener;
import panels.Main;
import panels.MainFrame;
import panels.SubPanel;

public class Game2 extends JPanel{
	/**Default Serial ID*/
	private static final long serialVersionUID = 1L;
	/**GameKeyListener Class*/
	private GameKeyLisener key;
	/**Ball Class*/

	/**Panel Margin Wide*/
	private double panelmarginwide;
	/**Panel Margin Height*/
	private double panelmarginheight;
	private  int Match_Point;
	private Image image;
	private boolean aKati;
	private boolean bKati;
	private boolean title;
	private JButton btn;
	private MainFrame mf;
	private Game2 game2Panel;
	private String str;
	private int x;
	private Player player;
	private Shoot shoot;
	private TekiShoot shoot2;
	private TekiShoot tekishoot;
	private Game2 game2;
	private Wall wall0;
	private Wall wall;
	private Wall wall2;
	private Wall wall3;
	private Teki teki;
	private int score=0;
	private int scorecount=0;
	private int life=50;
	private boolean finish=false;
	public Game2(MainFrame mf,String s) {
		this.setName("Game2");
		this.mf = mf;
		game2=this;
		str=s;
		
		key=new GameKeyLisener();
		this.mf.addKeyListener(key);
		this.mf.requestFocusInWindow();
		player=new Player(mf,this);
		teki=new Teki(this);
		shoot=new Shoot(mf, player,teki,this);
		wall0=new Wall(100,400);
		wall=new Wall(250,400);
		wall2=new Wall(400,400);
		wall3=new Wall(550,400);
		shoot2=new TekiShoot(mf, teki,this,player);
	}
	
	public void run(){
		
		if(finish){
				
		        btn=new JButton("メニューへ戻る");
		        btn.setBounds(275, 370, 150, 40);
		        btn.addActionListener(new ActionListener(){
		            public void actionPerformed(ActionEvent e){
		            	mf.setAtai(3);
		                mf.PanelChange(game2,"mp");
		            }
		        });  this.add(btn);		        
     
		}else{
		shoot.genkai();
		teki.move();
		player.move();
		if(key.isEnterKeyPressed()){
			mf.setAtai(3);
            mf.PanelChange(game2, "mp");
		}
		}
	}
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawImage(image,0,0,700,600,null);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sanserif",Font.BOLD,30));
			scorecount++;
			g.drawString("Score:"+score+"   Life Point:"+life,180, 100);
			player.playerGraphics(g);
			if(finish==false){
			if(scorecount>=10){
				score++;
				scorecount=0;
				}
			shoot.shootmain(g);
			shoot2.shootmain(g);
			}
			if(finish==true){
			g.setColor(Color.RED);
			g.setFont(new Font("Sanserif",Font.BOLD,50));
			g.drawString("Total Score:"+(score*(life+1)),180, 270);
			}
			wall0.wallGraphics(g);
			wall.wallGraphics(g);
			wall2.wallGraphics(g);
			wall3.wallGraphics(g);
			teki.tekiGraphics(g);
			
	}
	public void setFinish(boolean finish){
		
		this.finish=true;
	}
public void setLife(int life){
		
		this.life+=life;
		if(this.life==0) finish=true;
	}
public int getLife(){
	
	return life;
}
public boolean getFinish(){
		
		return this.finish;
	}
	/**Get Panel Margin Wide
	 * @return panelmarginwide*/
	public double getPanelmarginwide() {
		return panelmarginwide;
	}
	/**Get Panel Margin Height
	 * @return panelmarginhide*/
	public double getPanelmarginheight() {
		return panelmarginheight;
	}
}

