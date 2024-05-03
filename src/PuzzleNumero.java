import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.Timer;

public class PuzzleNumero extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel contentPane_1;
	public static JButton[] botones;
	JPanel _botones; 
	private JPanel panel_1;
	private List<Integer> numeros = new ArrayList<>();
	private List<String> numOrdenados = new ArrayList<>();
	private Timer tiempo;
	private int h,m,s;
	private JLabel labelTiempo, fondoBorroso;
	private boolean juegoTerminado = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleNumero frame = new PuzzleNumero();
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
	public PuzzleNumero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		contentPane_1 = new JPanel();
		contentPane_1.setBackground(new Color(180, 97, 253));
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setLayout(new BorderLayout(0, 0));
		 
		 
		setContentPane(contentPane_1);
		
		_botones = new JPanel();
		_botones.setBackground(new Color(219, 209, 235));
		contentPane_1.add(_botones, BorderLayout.CENTER);
		_botones.setBorder(new LineBorder(new Color(180, 97, 253), 10));
		_botones.setLayout(new GridLayout(4, 0, 0, 0));
		
		
		
		botones = new JButton[16];

        for (int i = 1; i <= 16; i++) 
        {
            numeros.add(i);
        }
        
        Collections.shuffle(numeros);
        for (int i = 0; i < botones.length; i++) {
        	if(numeros.get(i) !=16) {
        		botones[i] = new JButton(numeros.get(i) + "");
                botones[i].setFont(new Font("Arial Black", Font.BOLD, 28));  
            } else {
            	botones[i] = new JButton("");
            	botones[i].setFont(new Font("Arial Black", Font.BOLD, 28));
            }
            botones[i].setFocusable(false);
            botones[i].setBackground(null);
            botones[i].setBorderPainted(true);
            botones[i].setBorder(BorderFactory.createLineBorder(new Color(180, 97, 253), 5));
            botones[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    JButton btn = ((JButton) e.getSource());
                    moverBoton(btn);
                    if (!juegoTerminado) {
                        tiempo.start(); // Inicia el cronómetro solo si el juego no ha terminado
                    }
                   
                }

            });
            _botones.add(botones[i]);

        }
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(180, 97, 253));
		contentPane_1.add(panel_1, BorderLayout.SOUTH);
		 
		 JButton botonReiniciar = new JButton();
		 botonReiniciar = new JButton("Reiniciar");
		 botonReiniciar.setFocusable(false);
		 botonReiniciar.setBackground(new Color(221, 183, 255));
		 botonReiniciar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					reiniciarJuego();
					
					for (int i = 0; i < botones.length; i++) {
						botones[i].setEnabled(true);
			        	
			 		}
					
				}
		 });
		 
		 panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		 
		 labelTiempo = new JLabel("  00:00:00");
		 labelTiempo.setForeground(new Color(0, 0, 0));
		 labelTiempo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		 panel_1.add(labelTiempo);
		 
		 JLabel lblNewLabel_1 = new JLabel(" ");
		 panel_1.add(lblNewLabel_1);
		 
		 panel_1.add(botonReiniciar);
		 
		 JLabel lblNewLabel = new JLabel("    ");
		 panel_1.add(lblNewLabel);
		 
		 JPanel panel = new JPanel();
		 panel.setBackground(new Color(180, 97, 253));
		 contentPane_1.add(panel, BorderLayout.NORTH);
		 
		 JButton btnReanudar = new JButton("Reanudar");
		 btnReanudar.setFocusable(false);
		 btnReanudar.setBackground(new Color(225, 192, 255));
		 btnReanudar.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent e) {
			 		tiempo.start();
			 		juegoTerminado=false; 
			 		for (int i = 0; i < botones.length; i++) {
			        	botones[i].setEnabled(true);
			        	
			 		}
			 	}
			 });
		 panel.add(btnReanudar);
		 
		 
		 JButton btnPausa = new JButton("Pausa");
		 btnPausa.setFocusable(false);
		 btnPausa.setBackground(new Color(225, 192, 255));
		 btnPausa.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		tiempo.stop();
		 		for (int i = 0; i < botones.length; i++) {
		        	botones[i].setEnabled(false);
		        	
		 		}
		 		
		 		
		 	}
		 });
		 panel.add(btnPausa);
		 
		 cronometro();
		 
		 

	}
	
	public void verificarGanador()
	{
		for (int i = 1; i <= 15; i++) {
	        numOrdenados.add(i+"");
	    }
		
		boolean ganador = true;
	    for (int i = 0; i < botones.length - 1; i++) {
	        if (!botones[i].getText().equals(numOrdenados.get(i))) {
	            ganador = false;
	            
	            break;
	        }
	    }

	    if (ganador) {
	    	juegoTerminado=true;
	    	tiempo.stop();
	    	JOptionPane.showMessageDialog(this, "¡Has ganado el juego!");
	    	//reiniciarJuego();
	    	for (int i = 0; i < botones.length; i++) {
	        	botones[i].setEnabled(false);	
	        	
	 		}
	    	reiniciarTiempo();
	    }

	}
	
	public void reiniciarTiempo() {
        h = 0;
        m = 0;
        s = 0;
        String tiempoNuevo = String.format("  %02d:%02d:%02d", h, m, s);
        labelTiempo.setText(tiempoNuevo);

    }
	
	
	
	
	public void moverBoton (JButton btn) {
		
		 
		    
		int botonSeleccionado=-1; // Indice de boton
		for (int i = 0; i < botones.length; i++) {
			if (botones[i]==btn)
			{
				botonSeleccionado=i;
				break;
			}
			
		}
		int botonVacio= -1; //Indice de boton
		for (int i = 0; i < botones.length; i++) {
			if (botones[i].getText().isEmpty())
			{
				botonVacio=i;
				break;
			}
			
		}
		
		//Movimientos
		if(movimientoValido(botonSeleccionado, botonVacio))
		{
			String valor = botones[botonSeleccionado].getText();
		    botones[botonSeleccionado].setText(botones[botonVacio].getText());
		    botones[botonVacio].setText(valor);
		    verificarGanador();
		    
		    
		}
		
		
	}
	
	private boolean movimientoValido(int botonSeleccionado, int botonVacio) {
	    // Verificar si los botones están en la misma fila o columna
	    if (botonSeleccionado / 4 == botonVacio / 4 || botonSeleccionado % 4 == botonVacio % 4) {
	        // Verificar si los botones están adyacentes
	        return Math.abs(botonSeleccionado - botonVacio) == 1 || Math.abs(botonSeleccionado - botonVacio) == 4;
	    }
	    return false;
	}
	
	public void reiniciarJuego()
	{	
		tiempo.stop(); // Detener el cronómetro al reiniciar el juego
		h=0; m=0;  s=0; // Reiniciar tiempo
		String tiempoNuevo = String.format("  %02d:%02d:%02d", h, m, s);
		labelTiempo.setText(tiempoNuevo);
		juegoTerminado = false; // Establecer que el juego no ha terminado

		Collections.shuffle(numeros);
		for (int i = 0; i < botones.length; i++) {
        	if(numeros.get(i) !=16) {
        		botones[i].setText(numeros.get(i) + "");
        		botones[i].setFont(new Font("Arial Black", Font.BOLD, 28));
            } 
        	else {
                botones[i].setText("");
                botones[i].setFont(new Font("Arial Black", Font.BOLD, 28));
            }
        	
		}
		
	//	tiempo.start();
	}
	
	
	// Método para actualizar el contador de tiempo
    public void actualizarTiempo() {
        s++;
        if (s == 60) {
            m++;
            s = 0;
        }
        if (m == 60) {
            h++;
            m = 0;
        }
        String tiempoNuevo = String.format("  %02d:%02d:%02d", h, m, s);
        labelTiempo.setText(tiempoNuevo);
    }
    
    // Método para iniciar el cronómetro
    public void cronometro() {
        tiempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTiempo();
            }
        });
       // tiempo.start();
    }
    

}

