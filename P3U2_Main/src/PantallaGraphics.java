import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.SwingConstants;

public class PantallaGraphics extends JFrame implements KeyListener  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,  panelDibujo, panelBoton;
	int x= 10;
    int y = 13;
    JLabel cron;
    private Timer tiempo;
    private int h,m,s;
    Jugador j1 = new Jugador(x,y,15,15, "#E8FF41");
    Jugador meta = new Jugador(610,510,20,40, "#FFFFFF");
    Jugador[] obs;
    private JLabel labelNivel;
    public JCheckBox itemSonido;
    Sonido sonidoVictoria; 
    boolean tiempoCorriendo=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGraphics frame = new PantallaGraphics();
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
	public PantallaGraphics() {
		setTitle("Laberinto");
		setResizable(false);
		setSize(650,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Menu");
		menuBar.add(mnNewMenu);

		itemSonido = Sonido.crearBotonSonido();
		itemSonido.setForeground(new Color(0, 0, 0));
		mnNewMenu.add(itemSonido);
		
		JMenuItem itemAyuda = new JMenuItem("Ayuda");
		itemAyuda.setForeground(new Color(0, 0, 0));
		itemAyuda.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        ayuda();
        	}
        });
		mnNewMenu.add(itemAyuda);
		
		
		Sonido sonido = new Sonido ("src/Pista1.wav");

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDibujo = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.decode(j1.getColor()));
                g.fillRect(j1.getX(), j1.getY(), j1.getW(), j1.getH());
                
                
                
                g.setColor(Color.decode(meta.getColor()));
                g.fillRect(meta.getX(), meta.getY(), meta.getW(), meta.getH());
                
                for (Jugador obs : obs) {
                	 g.setColor(Color.decode(obs.getColor()));
                	 g.fillRect(obs.getX(), obs.getY(), obs.getW(), obs.getH());
                }
                
                g.setColor(Color.BLACK);
                g.fillRect(615,510,5,5); g.fillRect(625,510,5,5);
                g.fillRect(610,515,5,5); g.fillRect(620,515,5,5);
                g.fillRect(615,520,5,5); g.fillRect(625,520,5,5);
                g.fillRect(610,525,5,5); g.fillRect(620,525,5,5);
                g.fillRect(615,530,5,5); g.fillRect(625,530,5,5);
                g.fillRect(610,535,5,5); g.fillRect(620,535,5,5);
                g.fillRect(615,540,5,5); g.fillRect(625,540,5,5);     
                 
            }
        };
		panelDibujo.setBounds(0, 0, 636, 550);
		panelDibujo.setBackground(Color.black);
		panelDibujo.setLayout(null);
		panelDibujo.setBorder(new LineBorder(new Color(81, 81, 255), 8));
		contentPane.add(panelDibujo);
		
		
		
		panelBoton = new JPanel();
		panelBoton.setBounds(0, 550, 636, 40);
		panelBoton.setBackground(new Color(81, 81, 255));
		panelBoton.setLayout(null);
		contentPane.add(panelBoton);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(269,  7, 100, 25);
		btnReiniciar.setForeground(new Color(0, 0, 0));
		btnReiniciar.setBackground(new Color(197,255,246));
		btnReiniciar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReiniciar.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		btnReiniciar.setFocusable(false);
		btnReiniciar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				j1.setX(10);
				j1.setY(13);
				repaint();
				tiempo.stop();
				reiniciarTiempo();
				
			}
	
		});
		panelBoton.add(btnReiniciar);
		
	    cron = new JLabel("  00:00:00");
	    cron.setFont(new Font("Tahoma", Font.BOLD, 14));
	    cron.setForeground(new Color(0, 0, 0));
		cron.setBounds(511, 13, 89, 13);
		panelBoton.add(cron);
		
		labelNivel = new JLabel("Nivel: 1");
		labelNivel.setFont(new Font("Tahoma", Font.BOLD, 14));
		labelNivel.setForeground(new Color(0, 0, 0));
		labelNivel.setBounds(48, 13, 55, 13);
		panelBoton.add(labelNivel);
		
	//	sonidoVictoria = new Sonido("src/ganar.wav");
		Sonido.bucle();
		cronometro();
		tiempo.stop();
		nivel1();
		

				
	}
	
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyCode()+" "+e.getKeyChar());
		int prevX=j1.getX();
		int prevY=j1.getY();
		
		
		switch (e.getKeyCode()) { //El tiempo empieza a correr cuand se presiona alguna de estas teclas
        case 37: 
        case 65:
        case 39:
        case 68:
        case 38:
        case 87:
        case 40:
        case 83:
        	if (!tiempo.isRunning()) {
    	        cronometro();
    	    }
            break;
        default:
            return;
		}
		
		
		switch (e.getKeyCode()) {
        case 37: 
        case 65:	//a - Izquierda
        		j1.setX(j1.getX()-3);
            break;
        case 39:
        case 68:	// d - derecha
        		j1.setX(j1.getX()+3);
            break;
        case 38:
        case 87: // w - arriba
        		j1.setY(j1.getY()-3);
            break;
        case 40:
        case 83:	// s - abajo
        		j1.setY(j1.getY()+3);
            break;
        default:
            return;
		}

		for (Jugador obs : obs)
		{
			if(j1.getX() + j1.getW() > obs.getX() && 
			   j1.getX() < obs.getX()+ obs.getW()  &&
		       j1.getY() + j1.getH() > obs.getY() &&
		       j1.getY() < obs.getY() + obs.getH())
			{
				System.out.println("Colision");
				j1.setX(prevX);
				j1.setY(prevY);
			//	tiempo.stop();
			//	finJuego("¡Perdiste!"); //Si chocas pierdes  (el movimiento debe ser 1)
				break; 
			}
		}
		
		if(j1.getX() <=6 || j1.getX() >= 610 || j1.getY() <= 6 || j1.getY() >= 525)
		{
			System.out.println("Colision");
			j1.setX(prevX);
			j1.setY(prevY);
			//tiempo.stop();
			//finJuego("¡Perdiste!"); //Si chocas pierdes (el movimiento debe ser 1)		
		}
		
		if(j1.getX() + j1.getW() > meta.getX() && 
		   j1.getX() < meta.getX()+ meta.getW()  &&
		   j1.getY() + j1.getH() > meta.getY() &&
		   j1.getY() < meta.getY() + meta.getH())
		  {
				System.out.println("Ganaste");
				tiempo.stop();
				finJuego("¡Felicidades, Ganaste!");
				nivel1();
		  }		 
		this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void reiniciarTiempo() {
        h = 0;
        m = 0;
        s = 0;
        String tiempoNuevo = String.format("  %02d:%02d:%02d", h, m, s);
        cron.setText(tiempoNuevo);
    }
	
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
        cron.setText(tiempoNuevo);
    }
    
    // Método para iniciar el cronómetro
    public void cronometro() {
        tiempo = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarTiempo();
            }
        });
        tiempo.start();
    }

 

	
	public void finJuego(String mensaje)
	{
		int segT = h * 3600 + m * 60 + s; // Convierte tiempo a segundos
	    int horas = segT / 3600;
	    int min = (segT % 3600) / 60;
	    int seg = segT % 60;
	    Sonido.stop();
	    Sonido.cambiarPista("src/ganar.wav");
	    String duracionPartida = String.format("%02d:%02d:%02d", horas, min, seg);
	    JOptionPane.showMessageDialog(this, mensaje + "\nDuración de la partida: " + duracionPartida, "Fin del Juego", JOptionPane.INFORMATION_MESSAGE);  
	
	    
	    reiniciarJuego();
	}
	
	public void reiniciarJuego() {
	    j1.setX(10);
	    j1.setY(13);
	    repaint();
	    reiniciarTiempo();
	    Sonido.cambiarPista("src/Pista1.wav");
	    Sonido.bucle();
	}
	
	
	public void nivel1()
	{
		obs = new Jugador[] { 
				 new Jugador (0, 35, 55, 20, "#980035"),
		         new Jugador (35, 55, 20, 45, "#980035"),
		         new Jugador (83, 0, 20, 176, "#980035"),
		         new Jugador (103, 35, 50, 20, "#980035"),
		         new Jugador (35, 128, 168, 20, "#980035"),
		         new Jugador (0, 176, 55, 20, "#980035"),
		         new Jugador (35, 196, 20, 28, "#980035"),
		         new Jugador (55, 204, 145, 20, "#980035"),
		         new Jugador (35, 252, 20, 100, "#980035"),
		         new Jugador (0, 332, 55, 20, "#980035"),
		         new Jugador (131, 176, 20, 28, "#980035"),
		         new Jugador (35, 380, 20, 132, "#980035"),
		         new Jugador (55, 492, 28, 20, "#980035"),
		         new Jugador (83, 352, 20, 160, "#980035"),
		         new Jugador (83, 332, 160, 20, "#980035"),
		         new Jugador (180, 352, 20, 28, "#980035"), 
		         new Jugador (131, 380, 20, 170, "#980035"), 
		         new Jugador (55, 280, 100, 20, "#980035"),
		         new Jugador (87, 250, 20, 30, "#980035"),
		         new Jugador (182, 0, 20, 98, "#980035"),
		         new Jugador (132, 80, 70, 20, "#980035"),
		         new Jugador (183, 148, 20, 28, "#980035"),
		         new Jugador (203, 156, 50, 20, "#980035"),
		         new Jugador (233, 172, 20, 32, "#980035"),
		         new Jugador (233, 204, 50, 20, "#980035"),
		         new Jugador (283, 128, 20, 96, "#980035"),
		         new Jugador (303, 128, 30, 20, "#980035"),
		         new Jugador (180, 222, 20, 79, "#980035"),
		         new Jugador (200, 250, 249, 20, "#980035"),
		         new Jugador (180, 407, 20, 112, "#980035"),
		         new Jugador (228, 455, 20, 100, "#980035"),
		         new Jugador (276, 407, 20, 112, "#980035"),
		         new Jugador (180, 407, 100, 20, "#980035"),
		         new Jugador (228, 300, 20, 120, "#980035"),
		         new Jugador (276, 300, 20, 79, "#980035"),
		         new Jugador (248, 300, 40, 20, "#980035"),
		         new Jugador (233, 35, 20, 91, "#980035"),
		         new Jugador (253, 80, 79, 20, "#980035"),
		         new Jugador (283, 0, 20, 80, "#980035"),
		         new Jugador (331, 35, 270, 20, "#980035"),
		         new Jugador (359, 55, 20, 95, "#980035"),
		         new Jugador (359, 130, 88, 20, "#980035"),
		         new Jugador (427, 80, 55, 20, "#980035"),
		         new Jugador (427, 100, 20, 30, "#980035"),
		         new Jugador (475, 80, 20, 98, "#980035"),
		         new Jugador (331, 176, 270, 20, "#980035"),
		         new Jugador (528, 55, 20, 95, "#980035"),
		         new Jugador (581, 83, 20, 95, "#980035"),
		         new Jugador (331, 224, 20, 96, "#980035"),
		         new Jugador (390, 194, 20, 28, "#980035"),
		         new Jugador (490, 224, 200, 20, "#980035"),
		         new Jugador (473, 224, 20, 96, "#980035"),
		         new Jugador (379, 300, 110, 20, "#980035"),
		         new Jugador (581, 244, 20, 28, "#980035"), 
		         new Jugador (526, 270, 20, 96, "#980035"),
		         new Jugador (546, 298, 120, 20, "#980035"),
		         new Jugador (574, 346, 60, 20, "#980035"),
		         new Jugador (473, 346, 73, 20, "#980035"),
		         new Jugador (331, 346, 114, 20, "#980035"),
		         new Jugador (331, 394, 114, 20, "#980035"),
		         new Jugador (331, 490, 66, 20, "#980035"),
		         new Jugador (379, 320, 20, 94, "#980035"),
		         new Jugador (425, 414, 20, 101, "#980035"),
		         new Jugador (377, 442, 20, 120, "#980035"),
		         new Jugador (473, 442, 20, 120, "#980035"),
		         new Jugador (295, 442, 54, 20, "#980035"),
		         new Jugador (473, 394, 72, 20, "#980035"),
		         new Jugador (525, 414, 20, 102, "#980035"),
		         new Jugador (574, 476, 60, 20, "#980035"),
		         new Jugador (574, 366, 20, 28, "#980035"),
		         new Jugador (540, 424, 60, 20, "#980035"),};
	}
	
	public void ayuda()
	{
		tiempo.stop();
		boolean tiempoPrevioCorriendo = tiempo.isRunning();
	    tiempoCorriendo = tiempoCorriendo || tiempoPrevioCorriendo || (h == 0 && m == 0 && s == 0);

		JPanel panelAyuda = new JPanel();
		panelAyuda.setBounds(0, 0, 636, 590);
		panelAyuda.setBackground(Color.black);
		panelAyuda.setLayout(null);
		panelAyuda.setBorder(new LineBorder(new Color(81, 81, 255), 8));
		contentPane.add(panelAyuda);
		
		JLabel info = new JLabel("Objetivo: Encontrar la meta en el menor tiempo posible", 0);
		info.setForeground(Color.white);
		info.setFont(new Font("Tahoma", Font.PLAIN, 16));
		info.setBounds(0, 150, 636, 20);
		panelAyuda.add(info);
		
		JLabel ins = new JLabel ("Utiliza las teclas de flecha o WASD para moverte.",0);
		ins.setForeground(Color.white);
		ins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ins.setBounds(0, 180, 636, 20);
		panelAyuda.add(ins);
		
		JLabel logo4 = new JLabel();
		logo4.setBounds(55, 200, 256, 256);
		panelAyuda.add(logo4);
		logo4.setIcon(new ImageIcon(getClass().getResource("flechas.png")));
		
		JLabel logo5 = new JLabel();
		logo5.setBounds(326, 206, 256, 256);
		panelAyuda.add(logo5);
		logo5.setIcon(new ImageIcon(getClass().getResource("wasd.png")));
		
		JButton btnVolver = new JButton ("Volver");
		btnVolver.setBounds(269,  500, 100, 25);
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setBackground(new Color(197,255,246));
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnVolver.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		btnVolver.setFocusable(false);
		btnVolver.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				if (!tiempoCorriendo) {
	                tiempo.start();
	            }
		        getContentPane().add(panelDibujo);
		        getContentPane().add(panelBoton);
		        revalidate();
		        repaint();  
			}
		});
		panelAyuda.add(btnVolver);	
	}
}
