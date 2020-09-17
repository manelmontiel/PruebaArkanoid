
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	private static final int DIAMETER = 30;
	int x = 0;
	int y = 0;
	int xa = 2;	//1
	int ya = 2;	//1
	private Game game;
	private Brick brick;

	public Ball(Game game) {
		this.game= game;
	}

	void move() {
		if (x + xa < 0)
			xa = 2;	//1
		if (x + xa > game.getWidth() - DIAMETER)
			xa = -2;	//-1
		if (y + ya < 0)
			ya = 2; //1
		if (y + ya > game.getHeight() - DIAMETER)
			game.gameOver();
		if (collision()){
			ya = -2; //-1
			y = game.racquet.getTopY() - DIAMETER;
		}
		if (collisionBrick()) {
			if(y + DIAMETER - 2 <= game.brick.getY()) {
				ya=-2;
			}else if(y >= game.brick.getY()) {	// - game.brick.getHeight()
				ya=2;
			}
			if(x<= game.brick.getX()) {	// + DIAMETER - 2 
				xa=-2;
			}if(x >= game.brick.getX()) {	// + game.brick.getWith()
				xa=2;
				
			}
		}
		/*if(y+ya < (game.brick.getY() + game.brick.getHeight()) && x == game.brick.getX() + game.brick.getWith()) {
			ya = -2;
		}
		if(y+ya > (game.brick.getY() + game.brick.getHeight()) && x == game.brick.getX() + game.brick.getWith()) {
			ya = 2;
		}
		if(x+xa < (game.brick.getX() + game.brick.getWith()) && y == game.brick.getY() + game.brick.getHeight()){
			xa= 2;
		}
		if(x+xa > (game.brick.getX() + game.brick.getWith()) && y == game.brick.getY() + game.brick.getHeight()){
			xa= -2;
		}*/
		/*if (collisionBrick2()) {
			ya = 2;
		}
		if (collisionBrick3()) {
			xa = -2;
		}
		if (collisionBrick4()) {
			xa = 2;
		}*/
		/*if(y + ya > brick.getBounds().getMinY()) {
			ya = 2;
			y = game.brick.getTopY() - DIAMETER;
		}*/
		/*if(x + xa == game.brick.getTopY() - DIAMETER) {
			xa = -2;
			x = game.brick.getTopY() - DIAMETER;
		}*/
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}
	
	private boolean collisionBrick() {
		return game.brick.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
}
