package hockey;


import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;
import panels.MainFrame;
public class Ball2 {
	
		/**Ball Position X*/
		protected double ballpositionx;
		/**Ball Position Y*/
		private double ballpositiony;
		
		
		/**Main Frame Class*/
		protected Game1 mp;
		/**Ball Size*/
		private double Ball_Size;
		/**Ball Move Left and Right*/
		protected boolean reflectionleftright;
		/**Ball Move Up and Down*/
		private boolean reflectionupdown;
		/**Ball Speed*/
		private  int Ball_Speed;
		/**Score Player A*/
		private int score_playerA;
		/**Score Player B*/
		private int score_playerB;
		
		private boolean isscoreopen=false;
	
		
		
		
		/**Goal Class*/
		private Goal goala;
		/**Goal Class*/
		private Goal goalb;

		public Ball2(Game1 mp, Goal goala, Goal goalb, int Ball_size, int Ball_Speed) {
			
			this.Ball_Size=Ball_size;
			this.Ball_Speed=Ball_Speed;
			
			ballpositionx = mp.getPanelmarginwide() / 2;
			ballpositiony = mp.getPanelmarginheight() / 2;
			
			this.mp = mp;
			score_playerA = 0;
			score_playerB = 0;
			reflectionleftright = false;
			reflectionupdown = false;
			this.goala = goala;
			this.goalb = goalb;
		}
		
		public void setBallSize(int size){
			this.Ball_Size=size;
		}
		public void setBallSpeed(int speed){
			this.Ball_Speed=speed;
		
		}
		public int getBallSize(){
			return (int)Ball_Size;
		}
		public int getBallSpeed(){
			return this.Ball_Speed;
		
		}
		public void resetBall() {
			
			ballpositionx = mp.getPanelmarginwide() / 2;
			ballpositiony = mp.getPanelmarginheight() / 2;
			
		}
		/**Move Ball
		 * @param player Player Class*/
		public void moveBall(Player player) {
			if(reflectionleftright == true) {
				ballpositionx += Ball_Speed;
			} else {
				ballpositionx -= Ball_Speed;
			}
			if(reflectionupdown == true) {
				ballpositiony += Ball_Speed;
			} else {
				ballpositiony -= Ball_Speed;
			}
			if(ballpositionx <= 5) {
				reflectionleftright = !reflectionleftright;//true
			}
			if(ballpositionx >= mp.getPanelmarginwide()) {
				reflectionleftright = !reflectionleftright;//false;
			}
			reflectionBall(player);
			goalBall();
		}
		/**Reflection Ball
		 * @param player Player Class*/
		private void reflectionBall(Player player) {
			reflectionPlayer(player);
			reflectionWall();
		}
		/**Reflection Ball Player
		 * @param player Player Class*/
		
		//当たり判定
		private void reflectionPlayer(Player player) {
			if(ballpositiony >= player.getPlayerAPositionY() && ballpositiony <= player.getPlayerAPositionY() + player.getPlayerHeight()) {
				if(ballpositionx >= player.getPlayerAPositionX() && ballpositionx <= player.getPlayerAPositionX() + player.getPlayerWidth()) {
					reflectionleftright = true;
					
				}
			}
			
			if(ballpositiony >= player.getPlayerBPositionY() - 10 && ballpositiony <= player.getPlayerBPositionY() + player.getPlayerHeight() + 10) {
				if(ballpositionx >= player.getPlayerBPositionX() - Ball_Size && ballpositionx <= player.getPlayerBPositionX() + player.getPlayerWidth() + 10) {
					reflectionleftright = false;
					
				}
			
			}}
		
		/**Goal Ball*/
		private void goalBall() {
		
			
			if(ballpositiony >= goala.getGoalpositiony() && ballpositiony <= goala.getGoalpositiony() + goala.getGoalheight()) {
				if(ballpositionx >= goala.getGoalpositionx() && ballpositionx <= goala.getGoalpositionx() + goala.getGoalwidth()) {
					score_playerB++;
					resetBall();
					isscoreopen=true;
					
				}
			}
			if(ballpositiony >= goalb.getGoalpositiony() && ballpositiony <= goalb.getGoalpositiony() + goalb.getGoalheight()) {
				if(ballpositionx >= goalb.getGoalpositionx() && ballpositionx <= goalb.getGoalpositionx() + goalb.getGoalwidth()) {
					score_playerA++;
					resetBall();
					isscoreopen=true;
					
				}
			}
			
		}
		public boolean getscore(){
			return isscoreopen;
		}
		public void setscore(boolean a){
			this.isscoreopen=a;
			
		}
		
		/**Reflection Ball Wall*/
		private void reflectionWall() {
			if(ballpositiony <= 5) {
				reflectionupdown = !reflectionupdown;
			} else if(ballpositiony >= mp.getPanelmarginheight()) {
				reflectionupdown = !reflectionupdown;
			}
		}
		/**Ball Graphics
		 * @param g Graphics Class*/
		public void ballGraphics(Graphics g) {
		
			g.setColor(Color.green);
			g.fillOval((int)ballpositionx, (int)ballpositiony, (int)Ball_Size, (int)Ball_Size);
			
		}
		public int getScore_playerA() {
			return score_playerA;
		}
		public int getScore_playerB() {
			return score_playerB;
		}
	}



