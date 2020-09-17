import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

public class Brick {
	private static final int X = 150;
	private static final int Y = 100;
	private static final int WITH = 200;
	private static final int HEIGHT = 200;
	int x = 0;
	int xa = 0;
	private Game game;
	
	public int getX() {
		return X;
	}
	public int getY() {
		return Y;
	}
	public int getWith() {
		return WITH;
	}
	public int getHeight() {
		return HEIGHT;
	}

	public Brick(Game game) {
		this.game = game;
	}

	/*public void move() {
		if (x + xa > 0 && x + xa < game.getWidth() - WITH)
			x = x + xa;
	}*/

	public void paint(Graphics2D g) {
		g.fillRect(X, Y, WITH, HEIGHT);
	}

	/*public void keyReleased(KeyEvent e) {
		xa = 0;
	}*/

	/*public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT)
			xa = -5;
		if (e.getKeyCode() == KeyEvent.VK_RIGHT)
			xa = 5;
	}*/

	public Rectangle getBounds() {
		return new Rectangle(X, Y, WITH, HEIGHT);
	}

	public int getTopY() {
		return Y - HEIGHT;
	}
}
