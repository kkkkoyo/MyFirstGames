package hockey;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import gameListener.GameKeyLisener;
import panels.Main;
import panels.MainFrame;
import panels.SubPanel;

public class Game1 extends JPanel{
	/**Default Serial ID*/
	private static final long serialVersionUID = 1L;
	/**GameKeyListener Class*/
	private GameKeyLisener key;
	/**Ball Class*/
	private Ball ball;
	
	private Ball2 ball2;
	/**Goal Class*/
	private Goal goala;
	/**Goal Class*/
	private Goal goalb;
	
	private SettingPanel sp;
	
	/**Panel Margin Wide*/
	private double panelmarginwide;
	/**Panel Margin Height*/
	private double panelmarginheight;
	/**Player Class*/
	private Player player;
	/**Match Point*/

	private  int Match_Point;
	private Image image;
	private boolean aKati;
	private boolean bKati;
	private boolean title;
	private JButton btn;
	private MainFrame mf;
	private Game1 gamePanel;
	private String str;
	private SettingPanel setp;
	
	public Game1(MainFrame mf,String s,int Match_point, int BallSize, int BallSpeed, int BallSize2, int BallSpeed2) {
		this.setName("Game1");
		this.mf = mf;
		str=s;
		this.Match_Point=Match_point;
		gamePanel = this;
		this.setLayout(null);
		this.setSize(700, 600);
		
		System.out.println(this.mf.getWidth());
		//ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("C.png"));
		ImageIcon icon = new ImageIcon("C.png");
		image = icon.getImage();
		key=new GameKeyLisener();
		this.mf.addKeyListener(key);
		this.mf.requestFocusInWindow();
		panelmarginwide = this.mf.getWidth() - 25;
		panelmarginheight = this.mf.getHeight() - 30;
		player = new Player(this.mf, this, key);
		goala = new Goal(10, 200, 10, 200);
		goalb = new Goal(670, 200, 10, 200);
		ball = new Ball(this, goala, goalb,BallSize,BallSpeed);
		ball2 = new Ball2(this, goala, goalb,BallSize2,BallSpeed2);
	}
	
	public void run(){
		if(key.isEnterKeyPressed()){
			mf.setAtai(3);
            mf.PanelChange(gamePanel, "mp");
		}
		if (ball.getScore_playerA()+ball2.getScore_playerA() == Match_Point || ball.getScore_playerB()+ball2.getScore_playerB() == Match_Point) {

			if(ball.getScore_playerA()+ball2.getScore_playerA() ==Match_Point){
				aKati=true;
			}
			else if(ball.getScore_playerB() +ball2.getScore_playerB()==Match_Point){
				bKati=true;
			}
			
		        btn=new JButton("メニューへ戻る");
		        btn.setBounds(275, 370, 150, 40);
		        btn.addActionListener(new ActionListener(){
		            public void actionPerformed(ActionEvent e){
		            	mf.setAtai(3);
		                mf.PanelChange(gamePanel,"mp");
				        Match_Point=0;
				        
		            }
		        });  this.add(btn);		        
     
		}else {
			player.movePlayer();
			ball.moveBall(player);
			if(mf.getAtai()==2) ball2.moveBall(player);
			
		}		

	}
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		g.setColor(Color.WHITE);
		g.drawImage(image,0,0,700,600,null);
			ball.ballGraphics(g);
			if(mf.getAtai()==2) ball2.ballGraphics(g);
			player.playerGraphics(g);
			goala.goalGraphics(g);
			goalb.goalGraphics(g);
			
			g.setColor(Color.GRAY);
			g.fillRect((int)panelmarginwide/2-110,5, 240, 30);
			g.setColor(Color.RED);
			 g.setFont(new Font("Sanserif",Font.BOLD,20));
			g.drawString("Player1 " ,(int)panelmarginwide/2-100, 25);
			g.setColor(Color.BLACK);
			g.setFont(new Font("Sanserif",Font.BOLD,30));
			g.drawString((ball.getScore_playerA()+ball2.getScore_playerA())+"-"+(ball.getScore_playerB()+ball2.getScore_playerB()),(int)panelmarginwide/2-17, 30);
			g.setColor(Color.BLUE);
			g.setFont(new Font("Sanserif",Font.BOLD,20));
			g.drawString(" Player2",(int)panelmarginwide/2+40, 25);

			if(aKati){
				g.setColor(Color.RED);
				 g.setFont(new Font("Sanserif",Font.BOLD,100));
				g.drawString("Win", 71, 150);
				g.setColor(Color.BLUE);
				g.drawString("Lose", 371, 150);
			}
			else if(bKati){
				g.setColor(Color.RED);
				 g.setFont(new Font("Sanserif",Font.BOLD,100));
				g.drawString("Lose", 71, 150);
				g.setColor(Color.BLUE);
				g.drawString("Win", 401, 150);
			}
					
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

