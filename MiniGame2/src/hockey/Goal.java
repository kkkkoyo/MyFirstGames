package hockey;

import java.awt.Color;
import java.awt.Graphics;

public class Goal {
	/**Goal Position X*/
	private double goalpositionx;
	/**Goal Position Y*/
	private double goalpositiony;
	/**Goal Color*/
	private static final Color Goal_Color = Color.WHITE;
	/**Goal Width*/
	private double goalwidth;
	/**Goal Height*/
	private double goalheight;
	/**Goal Constructor*/
	public Goal(double goalpositionx, double goalpositiony, double goalwidth, double goalheight) {
		this.goalpositionx = goalpositionx;
		this.goalpositiony = goalpositiony;
		this.goalwidth = goalwidth;
		this.goalheight = goalheight;
	}
	/**Goal Graphics
	 * @param g Graphics Class*/
	public void goalGraphics(Graphics g) {
		g.setColor(Goal_Color);
		g.fillRect((int)goalpositionx, (int)goalpositiony, (int)goalwidth, (int)goalheight);
	}
	public double getGoalpositionx() {
		return goalpositionx;
	}
	public double getGoalpositiony() {
		return goalpositiony;
	}
	public double getGoalwidth() {
		return goalwidth;
	}
	public double getGoalheight() {
		return goalheight;
	}

}
