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
 
public class SubSubPanel extends JPanel {
    JButton btn,btn2,btn3;
    MainFrame mf;
    String str;
    Game1 mp ;
    private Image image;
    public SubSubPanel(MainFrame m,String s){
        mf = m;
        str = s;
        this.setName(s);
        this.setLayout(null);
        this.setSize(700, 600);
        this.setBackground(Color.GRAY);
        //ImageIcon icon = new ImageIcon(getClass().getClassLoader().getResource("gamemenu1.png"));
        ImageIcon icon = new ImageIcon("gamemenu1.png");
		image = icon.getImage();
		
        btn=new JButton("Level1");
        btn.setBounds(150, 300, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
 
             pc(mf.PanelNames[2]);
            }
        });
        this.add(btn);
        btn=new JButton("Level2");
        btn.setBounds(400, 300, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[3]);
            }
        });
        this.add(btn);
       
        btn=new JButton("メニューへ戻る");
        btn.setBounds(280, 370, 150, 40);
        btn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                pc(mf.PanelNames[0]);
                System.out.println("あ"+mf.PanelNames[0]);
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
