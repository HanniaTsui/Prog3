import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	public Ventana() {
		// TODO Auto-generated constructor stub
		this.setVisible(true); 
		this.setTitle("Mi ventana");
		this.setSize(500,300);
		this.setLocation(100,100);
		this.setLocationRelativeTo(null);
		this.setMaximumSize(new Dimension (750,750));
		this.setMinimumSize(new Dimension (250,250));
		//ventana.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
	}
	
	public void iniciarComponentes()
	{
		JPanel login = new JPanel();
		login.setSize(this.getWidth(), this.getHeight());
		login.setBackground(Color.red);
		this.add(login);
		
	}

}
