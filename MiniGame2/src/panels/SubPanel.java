package panels;
 
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import hockey.Game1;
import hockey.SettingPanel;
 
public class SubPanel extends JPanel {
    JButton btn,btn2,btn3;
    MainFrame mf;
    String str;
    Game1 mp ;
    private Image image;
    public SubPanel(MainFrame m,String s){
        mf = m;
        str = s;
        this.setName("Sub1");
        this.setName(s);
        this.setLayout(null);
        this.setSize(700, 600);
        this.setBackground(Color.GRAY);
        //ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("gamemenu1.png"));
        ImageIcon icon = new ImageIcon("gamemenu1.png");
		image = icon.getImage();
		
		
		
        btn=new JButton("Pack1");
        btn.setBounds(150, 300, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
 
             pc(mf.PanelNames[2]);
            }
        });
        this.add(btn);
       
        
        btn=new JButton("Pack2");
        btn.setBounds(400, 300, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[3]);
            }
        });
        this.add(btn);
        
        btn2=new JButton("setting");
        btn2.setBounds(150, 370, 150, 40);
        btn2.setForeground(Color.RED);
        btn2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[5]);
            }
        });
        this.add(btn2);
        
        
       
        
        
        btn=new JButton("メニューへ戻る");
        btn.setBounds(400, 370, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);
                System.out.println(mf.PanelNames[0]);
            }
        });
        this.add(btn);
       
       
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
