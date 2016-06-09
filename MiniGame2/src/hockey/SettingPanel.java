package hockey;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import hockey.Game1;
import panels.MainFrame;
 
public class SettingPanel extends JPanel {
   
	protected static final MainFrame MainFrame = null;
	private JButton btn,btn2,btn3;
    private MainFrame mf;
    private String str;
    private Image image;
    private int x=260;
    private Game1 mp;
    private int j;
    private int MatchPoint=5;
	private int BallSize=21;
	private int Ball2Size=21;
	private int BallSpeed=-5;
	private int Ball2Speed=5;
	
    
    public SettingPanel(MainFrame mf,String s){
 
    	this.mf=mf;
    	str=s;
    	this.setName("Set");
        this.setLayout(null);
        this.setSize(700, 600);
        this.setBackground(Color.GRAY);
        //ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("setmenu.png"));
        ImageIcon icon = new ImageIcon("setmenu.png");
		image = icon.getImage();
		
//        btn=new JButton("Pack1");
//        btn.setBounds(150, 300, 150, 40);
//     //   btn.getBackground(Color.WHITE);
//        btn.addActionListener(new ActionListener(){
//            public void actionPerformed(ActionEvent e){
// 
//             pc(mf.PanelNames[2]);
//            }
//        });
//        this.add(btn);
			JLabel l0=new JLabel("     Ball Size");
			l0.setOpaque(true);
			l0.setBounds(100, 240, 100, 20);
			l0.setForeground(Color.BLACK);
			l0.setBackground(Color.GRAY);
			this.add(l0);
		
		    JLabel l1=new JLabel("     Ball Speed");
			l1.setOpaque(true);
	        l1.setBounds(300, 240, 100, 20);
	        l1.setForeground(Color.BLACK);
	        l1.setBackground(Color.GRAY);
	        this.add(l1);
	       
	        JLabel l2=new JLabel("   Match Point");
			l2.setOpaque(true);
	        l2.setBounds(500, 240, 100, 20);
	        l2.setForeground(Color.BLACK);
	        l2.setBackground(Color.GRAY);
	        this.add(l2);
	        
	        JRadioButton []rn0 = new JRadioButton[5];
		       rn0[0] = new JRadioButton("小さい");
		 	   rn0[1] = new JRadioButton("やや小さい");
		 	   rn0[2]= new JRadioButton("ふつう",true);
		 	   rn0[3]= new JRadioButton("やや大きい");
		 	   rn0[4]= new JRadioButton("大きい");
	        
	       JRadioButton []rn = new JRadioButton[5];
	       rn[0] = new JRadioButton("おそい");
	 	   rn[1] = new JRadioButton("ややおそい");
	 	   rn[2]= new JRadioButton("ふつう",true);
	 	   rn[3]= new JRadioButton("ややはやい");
	 	   rn[4]= new JRadioButton("はやい");
	 	  JRadioButton []rn2 = new JRadioButton[5];
	 	   rn2[0] = new JRadioButton(" 1");
	 	   rn2[1] = new JRadioButton(" 3");
	 	   rn2[2] = new JRadioButton(" 5",true);
	 	   rn2[3]= new JRadioButton(" 7");
	 	   rn2[4] = new JRadioButton(" 9");
	 	    
	 	   for(int i=0;i<=4;i++){
	    rn0[i].setForeground(Color.WHITE);
	 	rn[i].setForeground(Color.WHITE);
	 	rn2[i].setForeground(Color.WHITE);
	 	rn0[i].setBackground(Color.BLACK);
	 	rn[i].setBackground(Color.BLACK);
	 	rn2[i].setBackground(Color.BLACK);
	 	

	 	rn0[i].setBounds(100,x,100,30);
	 	rn[i].setBounds(300,x,100,30);
	    rn2[i].setBounds(500,x,100,30);
	    x+=30;
	 	   }
	 	ButtonGroup group0 = new ButtonGroup() ;
	    ButtonGroup group1 = new ButtonGroup() ;
	    ButtonGroup group2 = new ButtonGroup() ;
	    
	    for(int i=1;i<=5;i++){
	     rn0[i-1].addActionListener(new ActionListener(){
	       public void actionPerformed(ActionEvent e){
	    	   String num = e.getActionCommand();
	    	   j=Integer.parseInt(num);
	    	    BallSize=7*j;
	   	        Ball2Size=7*j;     
	             }
	         });rn0[i-1].setActionCommand(String.valueOf(i));
	         
	    rn[i-1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	String num = e.getActionCommand();
 	    	   j=Integer.parseInt(num);
 	    	 BallSpeed=-(j+2);
 	         Ball2Speed=j+2;  
            }
        });rn[i-1].setActionCommand(String.valueOf(i));
	 
	    rn2[i-1].addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	String num = e.getActionCommand();
  	    	   j=Integer.parseInt(num);

            MatchPoint=2*j-1;
            }
        });rn2[i-1].setActionCommand(String.valueOf(i));
	    }
	    for(int i=0;i<5;i++){
	    	group0.add(rn0[i]);
	    	this.add(rn0[i]);
	    	group1.add(rn[i]);
	    	this.add(rn[i]);
	    	group2.add(rn2[i]);
	    	this.add(rn2[i]);
	    }
        btn=new JButton("OK");
        btn.setBounds(330, 420, 70, 20);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	System.out.println("MatchPoint:"+MatchPoint+"   BallSize:"+BallSize+"   BallSpeed:"+BallSpeed);
                pc(mf.PanelNames[1]);
                System.out.println(mf.PanelNames[1]);
            }
        });
        this.add(btn);
       
    }
    public int getMp(){
    	return MatchPoint;
    }
	public int getBallSize(){
		return BallSize;
	}
	public int getBall2Size(){
		return Ball2Size;
	}
	public int getBallSpeed(){
		return BallSpeed;
	}
	public int getBall2Speed(){
		return Ball2Speed;
	}
    
    
    
   public void pc(String str){
	   mf.PanelChange((JPanel)this,str);
    }
   @Override
  	public void paintComponent(Graphics g) {
  		// TODO Auto-generated method stub
  		super.paintComponent(g);
  		g.drawImage(image,0,0,700,600,null);
  		
   }
}

