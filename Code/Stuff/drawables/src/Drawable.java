import java.awt.*;

/*
 * Class contains all variables and methods which are common to BOTH the
 * Class and Relationship diagrams. 
 */
public abstract class Drawable {
	protected int x, y;
	protected ObjectData data;
	
	//Generalised abstract method must be implemented
	//Tells the program how to draw this drawable to the canvas
	public abstract void paint(Graphics g);
	
	public void setData(ObjectData d) {
		data = d;
	}
	
	public ObjectData getData() {
		return data;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
}
