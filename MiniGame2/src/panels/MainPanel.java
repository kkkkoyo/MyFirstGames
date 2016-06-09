package panels;
 
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gameListener.GameKeyLisener;
import hockey.SettingPanel;
 
public class MainPanel extends JPanel {
    private JButton btn,btn2;
    private JLabel paneltitle;
    private MainFrame mf;
    private String str;
    private Image image;
    private int x1=150;
    private int x2=400;
    private int y1=300;
    private int y2=300;
    private GameKeyLisener key;
    
    
    public MainPanel(MainFrame m,String s){
        mf = m;
        str = s;
        key =new GameKeyLisener();
        
        this.setName("mp");
        this.setLayout(null);
        this.setSize(700, 600);
        //ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("gamemenu.png"));
        ImageIcon icon = new ImageIcon("gamemenu.png");
        image = icon.getImage();
        paneltitle = new JLabel("どちらかのゲームを選んでください");
        paneltitle.setForeground(Color.WHITE);
        paneltitle.setBounds(260, 230, 400, 40);
        this.add(paneltitle);
        
        btn = new JButton("ホッケーゲーム");
        btn.setBounds(x1, y1, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[1]);
            }
        });
        this.add(btn);
        
        btn2 = new JButton("ShootingA");
        btn2.setBounds(x2, y2, 150, 40);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[6]);
            }
        });
        this.add(btn2);

        this.setBackground(Color.GRAY);
        this.addKeyListener(key); 
    }
    
    public void pc(String str){
        mf.PanelChange((JPanel)this, str);
    }

    public void xy(){
//    	Random r1 = new Random();
//    	x2+=(int)r1.nextInt(100)-50;
//    	y2+=(int)r1.nextInt(100)-50;
//    	if(x2<0) x2=0;
//      	else if(x2>700) x2=700;
//    	if(y2<0) y2=0;
//      	else if(y2>600) y2=600;
//    	 btn2.setBounds(x2, y2, 150, 40);
    	if(key.isEnterKeyPressed()){
      	 Random r = new Random();
      	x1+=(int)r.nextInt(20)-10;
      	x2+=(int)r.nextInt(20)-10; 
      	y1+=(int)r.nextInt(20)-10; 
      	y2+=(int)r.nextInt(20)-10; 
      	if(x1<120) x1=120;
      	else if(x1>180) x1=180;
      	if(x2<370) x2=370;
      	else if(x2>430) x2=430;
      	if(y1<270) y1=270;
      	else if(y1>330) y1=330;
      	if(y2<270) y2=270;
      	else if(y2>330) y2=330;
      	btn.setBounds(x1, y1, 150, 40);
        btn2.setBounds(x2, y2, 150, 40);
    	}
    	if(key.isPlayerA_left_key_Pressed()) {
    		x1=150;
    		x2=400;
    		y1=300;
    		y2=300;
    		btn.setBounds(x1, y1, 150, 40);
            btn2.setBounds(x2, y2, 150, 40);
    	}
    }

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(image,0,0,700,600,null);
		g.setColor(Color.WHITE);
		Font font2 = new Font("ＭＳ 明朝", Font.BOLD, 13);
	    g.setFont(font2);
	    g.drawString("-SECRET COMMAND-",286, 405);
	    Font font3 = new Font("ＭＳ 明朝", Font.BOLD, 15);
	    g.setFont(font3);
		g.drawString("Push:(Enter)  Return:(A)",260, 430);
		
//			ball.ballGraphics(g);
//			player.playerGraphics(g);
//			goala.goalGraphics(g);
//			goalb.goalGraphics(g);
//			
//			g.setColor(Color.BLACK);
//			 g.setFont(new Font("Sanserif",Font.BOLD,80));
//			g.drawString(ball.getScore_playerA()+"-"+ball.getScore_playerB(), 271, 250);
    }
    
}