package hockey;

import gameListener.GameKeyLisener;
import panels.MainFrame;
import java.awt.Color;
import java.awt.Graphics;


	public class Player {
		/**GameKeyListener Class*/
		private GameKeyLisener key;
		/**Main Frame Class*/
		private Game1 mp;
		/**PlayerA Position X*/
		private double player_a_position_x;
		/**PlayerB Position X*/
		private double player_b_position_x;
		/**PlayerA Position Y*/
		private double player_a_position_y;
		/**PlayerB Position Y*/
		private double player_b_position_y;
		/**PlayerA Color*/
		private static final Color PlayerA_Color = Color.RED;
		/**PlayerB Color*/
		private static final Color PlayerB_Color = Color.BLUE;
		/**Player Width*/
		private double player_width;
		/**Player Height*/
		private double player_height;
		/**Player Constructor
		 * @param mf MainFrame Class
		 * @param mp MainPanel Class
		 * @param key GameKeyListener Class*/
		public Player(MainFrame mf, Game1 mp, GameKeyLisener key) {
			this.mp = mp;
			this.key = key;
			player_width = 10;
			player_height = 100;
			player_a_position_y = mp.getPanelmarginheight() / 3;
			player_b_position_y = mp.getPanelmarginheight() / 3;
			player_a_position_x = mp.getPanelmarginwide() / 10;
			player_b_position_x = mp.getPanelmarginwide() * 9 / 10;
		}
		/**Move Player*/
		public void movePlayer() {
		
			 
			
			if (key.isPlayerA_down_key_Pressed()) {
				
				if(player_a_position_y < mp.getPanelmarginheight() - player_height) {
					player_a_position_y += 6;
				}
			}else if (key.isPlayerA_up_key_Pressed()) {
				if(player_a_position_y > 6) {
					player_a_position_y -= 6;
				}
			}
			
			if (key.isPlayerA_right_key_Pressed()) {
				if(player_a_position_x < (mp.getPanelmarginwide() - player_width)/2) {          //NEW
					player_a_position_x += 6;
				}
			}else if (key.isPlayerA_left_key_Pressed()) {
				if(player_a_position_x > mp.getPanelmarginwide() /10-40) {
					player_a_position_x -= 6;
				}
			}
			
			if (key.isPlayerB_down_key_Pressed()) {
				if(player_b_position_y < mp.getPanelmarginheight() - player_height) {
					player_b_position_y += 6;
				}
			}else if (key.isPlayerB_up_key_Pressed()) {
				if(player_b_position_y > 6)	{
					player_b_position_y -= 6;
				}
			}
			if (key.isPlayerB_right_key_Pressed()) {
				if(player_b_position_x < mp.getPanelmarginwide() * 9 /10+45) {          //NEW
					player_b_position_x += 6;
				}
			}else if (key.isPlayerB_left_key_Pressed()) {
				if(player_b_position_x > ( mp.getPanelmarginwide() + player_width)/2+10) {
					player_b_position_x -= 6;
				}
			}
		}
		/**Player Graphics
		 * @param g Graphics Class*/
		public void playerGraphics(Graphics g) {
			g.setColor(PlayerA_Color);
			g.fillRect((int)player_a_position_x, (int)player_a_position_y, (int)player_width, (int)player_height);
			g.setColor(PlayerB_Color);
			g.fillRect((int)player_b_position_x, (int)player_b_position_y, (int)player_width, (int)player_height);
		}
		public double getPlayerAPositionX() {
			return player_a_position_x;
		}
		public double getPlayerBPositionX() {
			return player_b_position_x;
		}
		public double getPlayerAPositionY() {
			return player_a_position_y;
		}
		public double getPlayerBPositionY() {
			return player_b_position_y;
		}
		public double getPlayerWidth() {
			return player_width;
		}
		public double getPlayerHeight() {
			return player_height;
		}
	}