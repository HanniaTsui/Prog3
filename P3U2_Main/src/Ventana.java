import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ventana extends JFrame{

	public Ventana() {
		// TODO Auto-generated constructor stub
		this.setVisible(true); 
		this.setTitle("Mi ventana");
		this.setSize(920,560);
		this.setLocation(120,120);
		this.setLocationRelativeTo(null);
		this.setMaximumSize(new Dimension (600,600));
		this.setMinimumSize(new Dimension (250,250));
		//ventana.setResizable(false);
		this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
	}
	
	public void iniciarComponentes()
	{
		JPanel login = new JPanel();
		login.setSize(this.getWidth()/2, this.getHeight());
		login.setBackground(Color.gray);
		login.setLayout(null);
		
		JLabel loginTitulo = new JLabel("ACCEDER", 0);
		loginTitulo.setFont(new Font("Cambria", Font.BOLD, 18));
		loginTitulo.setForeground(Color.white);
		loginTitulo.setSize(300,80);
		loginTitulo.setLocation(100,20);
		loginTitulo.setOpaque(true);
		loginTitulo.setBackground(Color.blue);
		login.add(loginTitulo);
		
		JPanel registro = new JPanel(); // Agregar otro panel
		registro.setSize(this.getWidth()/2, this.getHeight());
		registro.setLocation(500,0);
		registro.setBackground(Color.green);
		
		this.add(login);
		this.add(registro);
		
		
	
		
	}

}
