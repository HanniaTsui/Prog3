import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class JuegoGato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static boolean turno;
	public static boolean ganador;
	public static JButton[] botones;
	JPanel _botones; 
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnNewButton_9;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private static int victoriasX = 0;
    private static int victoriasO = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		turno=false;
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoGato frame = new JuegoGato();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JuegoGato() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		 
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		lblNewLabel = new JLabel("X: "+victoriasX);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("O: "+victoriasO);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel_1);
		 
		setContentPane(contentPane);
		
		_botones = new JPanel();
		_botones.setBackground(new Color(192, 192, 192));
		contentPane.add(_botones);
		_botones.setLayout(new GridLayout(3, 3, 0, 0));
		
		botones = new JButton[9];
		for(int i=0; i<botones.length; i++)
		{
			botones[i]=new JButton ("");
			botones[i].setFont(new Font("Arial Black", Font.BOLD, 28));
			botones[i].setFocusable(false);
			botones[i].setBackground(null);
			botones[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JButton btn=((JButton) e.getSource());
					click(btn);
				}
				
			});
			_botones.add(botones[i]);
			 			
		}
		
	
		 panel_1 = new JPanel();
		 contentPane.add(panel_1, BorderLayout.SOUTH);
		 
		 btnNewButton_9 = new JButton("Reiniciar");
		 btnNewButton_9.setFocusable(false);
		 btnNewButton_9.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					reiniciarJuego();
				}
		 });
		 
		 panel_1.add(btnNewButton_9);
		

	}
	
	public void click(JButton btn)
	{
		if(btn.getText().equals(""))
		{
			//2 turno
			if(turno) {
				btn.setText("        O");
				JLabel logo = new JLabel();
				logo.setIcon(new ImageIcon(getClass().getResource("o.png")));
				btn.add(logo);
				btn.setBackground(new Color(245, 149, 129));
				turno=false;
				verificarGanador();
			} else {
				btn.setText("X");
				btn.setFont(new Font("Arial", Font.PLAIN,4 ));
		//		btn.setText("O");
				JLabel logo = new JLabel();
				logo.setIcon(new ImageIcon(getClass().getResource("x.png")));
				btn.add(logo);
				btn.setBackground(new Color(129, 231, 245));
				turno=true;
				verificarGanador();
			}
		}
			
	}
	
	public void verificarGanador() {
	    // Combinaciones ganadoras en el arreglo de índices
	    int[][] combinacionesGanadoras = {
	        {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // Filas
	        {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // Columnas
	        {0, 4, 8}, {2, 4, 6} // Diagonales
	    };

	    // Iterar sobre todas las combinaciones ganadoras
	    for(int i = 0; i < combinacionesGanadoras.length; i++)
	    {
	    	int[] combinacion = combinacionesGanadoras[i];
	        JButton boton1 = botones[combinacion[0]];
	        JButton boton2 = botones[combinacion[1]];
	        JButton boton3 = botones[combinacion[2]];

	        // Verificar si los botones en la combinación tienen el mismo texto y no están vacíos
	        if (!boton1.getText().isEmpty() && 
	            boton1.getText().equals(boton2.getText()) && 
	            boton2.getText().equals(boton3.getText())) {
	            // Hay un ganador
	        	 String ganador = boton1.getText();
	                JOptionPane.showMessageDialog(this, "¡Ganador: " + ganador + "!");
	                if (ganador.equals("X")) {
	                    victoriasX++;
	                } else {
	                    victoriasO++;
	                }
	                contadores();
		            reiniciarJuego(); // Reiniciar el juego
		            return;
	        }
	    }

	   // Verificar si todos los botones están llenos (empate)
	    boolean tableroLleno = true;
	   for (JButton boton : botones) {
	        if (boton.getText().isEmpty()) {
	            tableroLleno = false;
	            break;
	        }
	    }
	    if (tableroLleno) {
	        JOptionPane.showMessageDialog(this, "¡Empate!");
	        reiniciarJuego(); 
	    }
	}
	
	public void reiniciarJuego()
	{
		for(JButton boton : botones) {
			boton.setText("");
			boton.setBackground(null);
			boton.removeAll();
		}
	    
	    turno = false;
	}
	

	public void contadores()
	{
		lblNewLabel.setText("X: " + victoriasX);
	    lblNewLabel_1.setText("O: " + victoriasO);
	}
    

}
