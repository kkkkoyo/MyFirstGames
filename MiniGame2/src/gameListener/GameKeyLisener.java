package gameListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameKeyLisener implements KeyListener{
	/**PlayerA_UP_KEY*/
	private static final int PlayerA_UP_KEY = KeyEvent.VK_W;
	/**PlayerA_DOWN_KEY*/
	private static final int PlayerA_DOWN_KEY = KeyEvent.VK_S;
	
	private static final int PlayerA_RIGHT_KEY = KeyEvent.VK_D;    //NEW
	/**PlayerA_DOWN_KEY*/
	private static final int PlayerA_LEFT_KEY = KeyEvent.VK_A;  //NEW
	
	
	/**PlayerB_UP_KEY*/
	private static final int PlayerB_UP_KEY = KeyEvent.VK_UP;
	/**PlayerB_DOWN_KEY*/
	private static final int PlayerB_DOWN_KEY = KeyEvent.VK_DOWN;
	
	private static final int PlayerB_RIGHT_KEY = KeyEvent.VK_RIGHT;  //NEW
	/**PlayerB_DOWN_KEY*/
	private static final int PlayerB_LEFT_KEY = KeyEvent.VK_LEFT;   //NEW
	/**Enter Key*/
	private static final int ENTER_KEY = KeyEvent.VK_ENTER;
	/**PlayerA_UP_KEY Pressed*/
	private boolean playerA_up_key_Pressed;
	/**PlayerA_DOWN_KEY Pressed*/
	private boolean playerA_down_key_Pressed;
	
	private boolean playerA_right_key_Pressed;
	/**PlayerA_DOWN_KEY Pressed*/
	private boolean playerA_left_key_Pressed;
	
	
	/**PlayerB_UP_KEY Pressed*/
	private boolean playerB_up_key_Pressed;
	/**PlayerB_DOWN_KEY Pressed*/
	private boolean playerB_down_key_Pressed;
	
	private boolean playerB_right_key_Pressed;
	/**PlayerB_DOWN_KEY Pressed*/
	private boolean playerB_left_key_Pressed;
	
	
	/**Enter Key Flag*/
	private boolean enterKeyPressed;
	/**Game Key Listener Constructor*/
	public GameKeyLisener() {
		playerA_up_key_Pressed = false;
		playerA_down_key_Pressed = false;
		playerA_right_key_Pressed=false;
		playerA_left_key_Pressed=false;
		
		playerB_up_key_Pressed = false;
		playerB_down_key_Pressed = false;
		playerB_right_key_Pressed = false;
		playerB_left_key_Pressed = false;
		
		enterKeyPressed = false;
	}
	/**Key Typed Process
	 * @param e KeyEvent*/
	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyCode() == ENTER_KEY) {
			enterKeyPressed = true;
		}
	}
	/**Key Pressed Process
	 * @param e KeyEvent*/
	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.getKeyCode() == PlayerA_UP_KEY) {
			playerA_up_key_Pressed = true;
		} else if (e.getKeyCode() == PlayerA_DOWN_KEY) {
			playerA_down_key_Pressed = true;
		}
		if (e.getKeyCode() == PlayerA_RIGHT_KEY) {
			playerA_right_key_Pressed = true;
		}
		else if (e.getKeyCode() == PlayerA_LEFT_KEY) {
			playerA_left_key_Pressed = true;
		}
		
		
		if (e.getKeyCode() == PlayerB_UP_KEY) {
			playerB_up_key_Pressed = true;
		} else if (e.getKeyCode() == PlayerB_DOWN_KEY) {
			playerB_down_key_Pressed = true;
		}
		if (e.getKeyCode() == PlayerB_RIGHT_KEY) {
				playerB_right_key_Pressed = true;
			}
		 else if (e.getKeyCode() == PlayerB_LEFT_KEY) {
				playerB_left_key_Pressed = true;
			}
		
		if (e.getKeyCode() == ENTER_KEY) {
			enterKeyPressed = true;
		}
	}
	/**Key Released Process
	 * @param e KeyEvent*/
	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == PlayerA_UP_KEY) {
			playerA_up_key_Pressed = false;
		} else if (e.getKeyCode() == PlayerA_DOWN_KEY) {
			playerA_down_key_Pressed = false;
		}
		if (e.getKeyCode() == PlayerA_RIGHT_KEY) {
			playerA_right_key_Pressed = false;
		} else if (e.getKeyCode() == PlayerA_LEFT_KEY) {
			playerA_left_key_Pressed = false;
		}
		
		
		if (e.getKeyCode() == PlayerB_UP_KEY) {
			playerB_up_key_Pressed = false;
		} else if (e.getKeyCode() == PlayerB_DOWN_KEY) {
			playerB_down_key_Pressed = false;
		}
		if (e.getKeyCode() == PlayerB_LEFT_KEY) {
			playerB_left_key_Pressed = false;
		} else if (e.getKeyCode() == PlayerB_RIGHT_KEY) {
			playerB_right_key_Pressed = false;
		}
		
		
		if (e.getKeyCode() == ENTER_KEY) {
			enterKeyPressed = false;
		}
	}
	public boolean isPlayerA_up_key_Pressed() {
		return playerA_up_key_Pressed;
	}
	public boolean isPlayerA_down_key_Pressed() {
		return playerA_down_key_Pressed;
	}
	public boolean isPlayerA_left_key_Pressed() {
		return playerA_left_key_Pressed;
	}
	public boolean isPlayerA_right_key_Pressed() {
		return playerA_right_key_Pressed;
	}
	
	
	public boolean isPlayerB_up_key_Pressed() {
		return playerB_up_key_Pressed;
	}
	public boolean isPlayerB_down_key_Pressed() {
		return playerB_down_key_Pressed;
	}
	public boolean isPlayerB_right_key_Pressed() {
		return playerB_right_key_Pressed;
	}
	public boolean isPlayerB_left_key_Pressed() {
		return playerB_left_key_Pressed;
	}
	
	
	public boolean isEnterKeyPressed() {
		return enterKeyPressed;
	}

}
