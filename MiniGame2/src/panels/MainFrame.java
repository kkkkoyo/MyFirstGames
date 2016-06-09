package panels;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JPanel;

import hockey.Game1;
import hockey.SettingPanel;
import shooting.Game2;

public class MainFrame extends JFrame{

	public String[] PanelNames = {"mp","Sub1","Game1","Game1.2","Sub3","Set","Game2"};
	private  MainPanel mp;
	private SubPanel sp;
	private Game1 game;
	private Game2 game2;
	private SubSubPanel sp3;
	private SettingPanel setp;
	private int atai =0;

	public MainFrame(){

		this.setBounds(10, 10, 700, 600);
		setResizable(false);                         
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		
		setTitle("Game");
		mp = new MainPanel(this,PanelNames[0]);
		this.add(mp);mp.setVisible(true);
		mp.setFocusable(true);
        mp.requestFocus();
        setAtai(3); 
		sp = new SubPanel(this,PanelNames[1]);
		this.add(sp);sp.setVisible(false);
		sp3 = new SubSubPanel(this,PanelNames[4]);
		this.add(sp3);sp3.setVisible(false);
		
		setp = new SettingPanel(this,PanelNames[5]);
		this.add(setp);setp.setVisible(false);
	}
	public void PanelChange(JPanel jp, String str){

		System.out.println(jp.getName());
		String name = jp.getName();
		if(name==PanelNames[0]){
			mp = (MainPanel)jp;
			mp.setVisible(false);
		}else if(name==PanelNames[1]){
			sp = (SubPanel)jp;
			sp.setVisible(false);
		}
		else if(name==PanelNames[2]){
			 game = (Game1)jp;
	        game.setVisible(false);
		}
		else if(name==PanelNames[4]){
			sp3 = (SubSubPanel)jp;
			sp3.setVisible(false);
		}
		else if(name==PanelNames[5]){
			setp = (SettingPanel)jp;
			setp.setVisible(false);
		}
		else if(name==PanelNames[6]){
		      game2 = (Game2)jp;
		      game2.setVisible(false);
		  }

		if(str==PanelNames[0]){
			mp.setVisible(true);
			mp.setFocusable(true);
	        mp.requestFocus();
		}else if(str==PanelNames[1]){
			sp.setVisible(true);
		}
		else if(str==PanelNames[2]){
			game = new Game1(this,str,setp.getMp(),setp.getBallSize(),setp.getBallSpeed(),setp.getBall2Size(),setp.getBall2Speed());
			this.add(game);
			game.setVisible(true);  
			setAtai(1);  
		}
		else if(str==PanelNames[3]){
			game = new Game1(this,str,setp.getMp(),setp.getBallSize(),setp.getBallSpeed(),setp.getBall2Size(),setp.getBall2Speed());
			this.add(game);
			game.setVisible(true); 
			setAtai(2);   
		}
		else if(str==PanelNames[4]){
			sp3.setVisible(true);
		}
		else if(str==PanelNames[5]){
			setp.setVisible(true);
		}
		else if(str==PanelNames[6]){
			System.out.println("aaa");
			game2 = new Game2(this,str);
			this.add(game2);
			game2.setVisible(true); 
			setAtai(4);
		      }
	}public void setAtai(int i) {
		// TODO Auto-generated method stub
		this.atai=i;
	}
	/**Run Process*/

	public int getAtai(){
		return this.atai;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(1000 / 60);
				if(atai==3){
					mp.xy();
					mp.repaint();
				}
				if(atai==1||atai==2){
					game.run();
					game.repaint();
				}
				if(atai==4){
					game2.run();
					game2.repaint();
				}
			} catch (Exception e) {
			}
		}
	}
}


