import java.awt.Point;

public class Jugador {

	private int x;
    private int y;
    private int w;
    private int h;
   // private Color color= new Color(134,153,255);

    
    private String color;
    public Jugador(int x, int y, int w, int h, String color) {
        this.x=x;
        this.y=y;
        this.w=w;
        this.h=h;
        this.color=color; 
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



	public int getW() {
		return w;
	}



	public void setW(int w) {
		this.w = w;
	}



	public int getH() {
		return h;
	}



	public void setH(int h) {
		this.h = h;
	}



	public String getColor() {
		return color;
	}



	public void setColor(String color) {
		this.color = color;
	}
	
	public int getCenterX() {
	    return x + w / 2;  
	}

	public int getCenterY() {
	    return y + h / 2;
	}
	
	
}
