import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JCheckBox;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class PantallaGraphics extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,  panelDibujo, panelBoton, panelPausa, panelAyuda;
	int x= 10;
    int y = 13;
//	int x=500;	int y=500;
    JLabel cron, logo, labelNivel, labelPuntuacion;
    private Timer tiempo, timerPuntos, timerMovimiento;
    private int h,m,s;
    private int puntuacion=5000, nuevaPuntuacion, randomX, randomY, snitchX, snitchY;
    Jugador j1 = new Jugador(x,y,15,15, "#E8FF41");
    Jugador meta = new Jugador(610,510,20,40, "#FFFFFF");
    Jugador[] obs;
    Jugador objSnitch = new Jugador (snitchX, snitchY, 5,5,"#A8D8E3" ); 
    public JCheckBox itemSonido;
    Sonido sonidoVictoria; 
    boolean tiempoCorriendo=false;
    private List<Point> puntosNegros;
    private List<Point> puntosVerdes;
    private List<Point> puntosCafes;
    JLabel snitch;
    boolean  snitchA, sonidoActivado=true;

	/**
	 * Launch the application.
	 * 
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
		setTitle("Laberinto - Harry Potter");
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
		itemSonido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (itemSonido.isSelected()) {
                	sonidoActivado=true; 
                	System.out.println("SA");
                    Sonido.cambiarPista("src/songHarryContinuar.wav");
                } else {
                	sonidoActivado=false; 

                	System.out.println("DES");
                } 
                itemSonido.setSelected(sonidoActivado);
            }
        });
		mnNewMenu.add(itemSonido);
		
		JMenuItem itemAyuda = new JMenuItem("Ayuda");
		itemAyuda.setForeground(new Color(0, 0, 0));
		itemAyuda.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
		        ayuda();
        	}
        });
		mnNewMenu.add(itemAyuda);
		
	
		
		Sonido sonido = new Sonido ("src/songHarry.wav");
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDibujo = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                
                for (Point punto : puntosCafes) {
                    g.setColor(Color.decode("#5F5100"));
                    g.fillRect(punto.x, punto.y, 1, 1);
                }
                
                g.setColor(Color.black); // Meta
                g.fillRect(meta.getX(), meta.getY(), meta.getW(), meta.getH());
                
                for (Jugador obs : obs) {
                	 g.setColor(Color.decode(obs.getColor()));
                	 g.fillRect(obs.getX(), obs.getY(), obs.getW(), obs.getH());
                }
                
                for (Point punto : puntosNegros) {
                	g.setColor(Color.black);
                    g.fillRect(punto.x, punto.y, 1, 1);
                }
                
                for (Point punto : puntosVerdes) {
                    g.setColor(Color.decode("#7ADA66"));
                    g.fillRect(punto.x, punto.y, 1, 1);
                }
                g.setColor(Color.decode(j1.getColor()));
                g.fillRect(j1.getX(), j1.getY(), j1.getW(), j1.getH());
                
                
                g.setColor(Color.decode(objSnitch.getColor()));
                g.fillRect(objSnitch.getX(), objSnitch.getY(), objSnitch.getW(), objSnitch.getH());
            
            }
        };
		panelDibujo.setBounds(0, 0, 636, 550);
		panelDibujo.setBackground(Color.black);
		panelDibujo.setLayout(null);
		panelDibujo.setBorder(new LineBorder(new Color(10, 77, 23), 8));
		contentPane.add(panelDibujo);
		
		
		logo = new JLabel();
		logo.setBounds(7, 10, 20, 20);
		panelDibujo.add(logo);
		logo.setIcon(new ImageIcon(getClass().getResource("harry.png")));
		
		JLabel logoB = new JLabel();
		logoB.setBounds(600, 500, 30, 40);
		panelDibujo.add(logoB);
		logoB.setIcon(new ImageIcon(getClass().getResource("copa.png")));
		
		
		puntosNegros = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            randomX = (int) (Math.random() * 636); 
            randomY = (int) (Math.random() * 550); 
            puntosNegros.add(new Point(randomX, randomY));
        }
        
        puntosCafes = new ArrayList<>();
        for (int i = 0; i < 2500; i++) {
            randomX = (int) (Math.random() * 636); 
            randomY = (int) (Math.random() * 610); 
            puntosCafes.add(new Point(randomX, randomY));
        }
        
      
		panelBoton = new JPanel();
		panelBoton.setBounds(0, 550, 636, 40);
		panelBoton.setBackground(new Color(10, 77, 23));
		panelBoton.setLayout(null);
		contentPane.add(panelBoton);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(268, 6, 100, 25);
		btnReiniciar.setForeground(new Color(0, 0, 0));
		btnReiniciar.setBackground(new Color(115, 105, 50));
		btnReiniciar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReiniciar.setBorder(new LineBorder(new Color(88, 3, 0), 4));
		btnReiniciar.setFocusable(false);
		btnReiniciar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				timerPuntos.stop();
				j1.setX(10);
				j1.setY(13);
				if (objSnitch.getX() ==-20 && objSnitch.getY() ==-20 )
			    {
			    	generarSnitch();
			    }
				logo.setBounds(7, 10, 20, 20);
				nuevaPuntuacion = 5000;
			    actualizarPuntuacion(); 
				repaint();
				tiempo.stop();
				reiniciarTiempo();
				
			}
	
		});
		panelBoton.add(btnReiniciar);
		
		JButton btnPausa = new JButton();
		btnPausa.setBounds(430, 6, 25, 25);
		btnPausa.setBackground(new Color(10, 77, 23));
		btnPausa.setFocusable(false);
		btnPausa.setBorder(null);
		btnPausa.setContentAreaFilled(false);
		btnPausa.setIcon(new ImageIcon(getClass().getResource("pausa.png")));
		btnPausa.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				pausar();   	
			}
	
		});
		panelBoton.add(btnPausa);
		
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
		
		labelPuntuacion = new JLabel("Puntos: " + puntuacion);
        labelPuntuacion.setFont(new Font("Tahoma", Font.BOLD, 14));
        labelPuntuacion.setForeground(new Color(0, 0, 0));
        labelPuntuacion.setBounds(135, 13, 150, 13);
        panelBoton.add(labelPuntuacion);
        
		Sonido.bucle();
		cronometro();
		tiempo.stop();
		nivel1();
		
	    puntosVerdes = new ArrayList<>();
        for (Jugador obs : obs) 
        {
    	    for (int i = 0; i < 100; i++) { // Genera 100 puntos verdes por obstáculo
    		    randomX = (int) (Math.random() * obs.getW()) + obs.getX();
                randomY = (int) (Math.random() * obs.getH()) + obs.getY();
                puntosVerdes.add(new Point(randomX, randomY));
            }
	    }	
        
        nuevaPuntuacion = puntuacion; 
        timerPuntos = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                reducirPuntuacion(10); 
            }
        });
        timerPuntos.stop(); 
        
        generarSnitch();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	
	@Override
	public void keyPressed(KeyEvent e) {
	    System.out.println(e.getKeyCode() + " " + e.getKeyChar());
	    int prevX = j1.getX();
	    int prevY = j1.getY();

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
    	        timerPuntos.start();
        	}
            break;
        default:
            return;
		}
	    if (timerMovimiento != null && timerMovimiento.isRunning()) {
	        timerMovimiento.stop();
	    }
	    
	    snitch();
	    
	    switch (e.getKeyCode()) {
	        case 37:
	        case 65:    // a - Izquierda
	            timerMovimiento = new Timer(10, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    j1.setX(j1.getX() - 1); // Mueve hacia la izquierda
	                    logo.setLocation(logo.getX() -1, logo.getY());
	                    if (hayColision()) { 
	                    	logo.setLocation(logo.getX() +1, logo.getY());
	                    	 j1.setX(j1.getX() + 1);// Si hay colisión, detiene el timer
	                        ((Timer) e.getSource()).stop();
	                    }
	                    ganador();
	                    repaint();
	                }
	            });
	            timerMovimiento.start();
	            break;
	        case 39:
	        case 68:    // d - derecha
	        	timerMovimiento= new Timer(10, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    j1.setX(j1.getX() + 1); // Mueve hacia la derecha
	                    logo.setLocation(logo.getX() +1, logo.getY());
	                    if (hayColision()) { 
	                    	 j1.setX(j1.getX() - 1);// Si hay colisión, detiene el timer
	                    	 logo.setLocation(logo.getX() -1, logo.getY());
	                        ((Timer) e.getSource()).stop();
	                    }
	                    ganador();
	                    repaint();
	                }
	            });
	        	timerMovimiento.start();
	            break;
	        case 38:
	        case 87:    // w - arriba
	        	timerMovimiento = new Timer(10, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    j1.setY(j1.getY() - 1); // Mueve hacia arriba
	                    logo.setLocation(logo.getX(), logo.getY()-1);
	                    if (hayColision()) { 
	                    	 j1.setY(j1.getY() + 1);// Si hay colisión, detiene el timer
	                    	 logo.setLocation(logo.getX(), logo.getY()+1);
	                        ((Timer) e.getSource()).stop();
	                    }
	                    ganador();
	                    repaint();
	                }
	            });
	        	timerMovimiento.start();
	            break;
	        case 40:
	        case 83:    // s - abajo
	        	timerMovimiento = new Timer(10, new ActionListener() {
	                @Override
	                public void actionPerformed(ActionEvent e) {
	                    j1.setY(j1.getY() + 1); // Mueve hacia abajo
	                    logo.setLocation(logo.getX(), logo.getY()+1);
	                    if (hayColision()) { 
	                    	 j1.setY(j1.getY() - 1);// Si hay colisión, detiene el timer
	                    	 logo.setLocation(logo.getX(), logo.getY()-1);
	                        ((Timer) e.getSource()).stop();
	                    }
	                    ganador();
	                    repaint();
	                }
	            });
	        	timerMovimiento.start();
	            break;
	        default: 
	            return;
	    }


	    actualizarPuntuacion();
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
		ImageIcon icono = new ImageIcon("src/harryAyuda.png");
		int segT = h * 3600 + m * 60 + s; // Convierte tiempo a segundos
	    int horas = segT / 3600;
	    int min = (segT % 3600) / 60;
	    int seg = segT % 60;
	    Sonido.stop();
	    timerPuntos.stop();
	    Sonido.cambiarPista("src/harryWinner.wav");
	    String duracionPartida = String.format("%02d:%02d:%02d", horas, min, seg);
	    int opcion = JOptionPane.showConfirmDialog(this, mensaje + "\nPuntuación: " + nuevaPuntuacion + "\nDuración de la partida: " + duracionPartida + "\n¿Desea volver a jugar?", "Fin del Juego", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono);
	    if (opcion == JOptionPane.YES_OPTION) {
	        reiniciarJuego();
	    } else {
	        System.exit(0);
	    }
	}
	
	
	public void reiniciarJuego() {
	    j1.setX(10);
	    j1.setY(13);
	    logo.setBounds(7, 10, 20, 20);
	    nuevaPuntuacion = 5000;
	    if (timerMovimiento != null && timerMovimiento.isRunning()) {
	        timerMovimiento.stop();
	    }
	    actualizarPuntuacion(); 
	    nivel1();
	    if (objSnitch.getX() ==-20 && objSnitch.getY() ==-20 )
	    {
	    	generarSnitch();
	    }
	    repaint();
	    reiniciarTiempo();
	    if(sonidoActivado) {
    	    Timer timer = new Timer(000, new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            Sonido.cambiarPista("src/songHarry.wav");
    	            Sonido.bucle();
    	        }
    	    });
    	    timer.setRepeats(false); 
    	    timer.start();
    	   }
	}
	
	public void generarSnitch() {
		snitch = new JLabel();
		snitchA=false;
		snitch.setIcon(new ImageIcon(getClass().getResource("snitchA.png")));
	    boolean dentroDeObstaculo;
	    do {
	        dentroDeObstaculo = false;
	        objSnitch.setX((int) (Math.random() * 616));
	        objSnitch.setY((int) (Math.random() * 520));
	        // Verifica si la posición está dentro de los límites de algún obstáculo
	        for (Jugador obs : obs) {
	            if (objSnitch.getX() + 20 > obs.getX() && objSnitch.getX() < obs.getX() + obs.getW() &&
	                objSnitch.getY() + 25 > obs.getY() && objSnitch.getY() < obs.getY() + obs.getH()) {
	                dentroDeObstaculo = true;
	                break; // Salir del bucle si el objeto está dentro de un obstáculo
	            }
	        }
	        if (objSnitch.getX() <= 6 || objSnitch.getX() >= 617 || objSnitch.getY() <= 6 || objSnitch.getY() >= 529) {
	            dentroDeObstaculo = true; // Verificar si el objeto está fuera de los límites del panel
	        }
	    } while (dentroDeObstaculo);
	    snitch.setBounds(objSnitch.getX(), objSnitch.getY()-8, 15, 15);
	    panelDibujo.add(snitch);
	}


	
	public void nivel1() {
		obs = new Jugador[] { 
				 new Jugador (0, 35, 55, 20, "#199301"),
		         new Jugador (35, 55, 20, 45, "#199301"),
		         new Jugador (83, 0, 20, 176, "#199301"),
		         new Jugador (103, 35, 50, 20, "#199301"),
		         new Jugador (35, 128, 168, 20, "#199301"),
		         new Jugador (0, 176, 55, 20, "#199301"),
		         new Jugador (35, 196, 20, 28, "#199301"),
		         new Jugador (55, 204, 145, 20, "#199301"),
		         new Jugador (35, 252, 20, 100, "#199301"),
		         new Jugador (0, 332, 55, 20, "#199301"),
		         new Jugador (131, 176, 20, 28, "#199301"),
		         new Jugador (35, 380, 20, 132, "#199301"),
		         new Jugador (55, 492, 28, 20, "#199301"),
		         new Jugador (83, 352, 20, 160, "#199301"),
		         new Jugador (83, 332, 160, 20, "#199301"),
		         new Jugador (180, 352, 20, 28, "#199301"), 
		         new Jugador (131, 380, 20, 170, "#199301"), 
		         new Jugador (55, 280, 100, 20, "#199301"),
		         new Jugador (87, 250, 20, 30, "#199301"),
		         new Jugador (182, 0, 20, 98, "#199301"),
		         new Jugador (132, 80, 70, 20, "#199301"),
		         new Jugador (183, 148, 20, 28, "#199301"),
		         new Jugador (203, 156, 50, 20, "#199301"),
		         new Jugador (233, 172, 20, 32, "#199301"),
		         new Jugador (233, 204, 50, 20, "#199301"),
		         new Jugador (283, 128, 20, 96, "#199301"),
		         new Jugador (303, 128, 30, 20, "#199301"),
		         new Jugador (180, 222, 20, 79, "#199301"),
		         new Jugador (200, 250, 249, 20, "#199301"),
		         new Jugador (180, 407, 20, 112, "#199301"),
		         new Jugador (228, 455, 20, 100, "#199301"),
		         new Jugador (276, 407, 20, 112, "#199301"),
		         new Jugador (180, 407, 100, 20, "#199301"),
		         new Jugador (228, 300, 20, 120, "#199301"),
		         new Jugador (276, 300, 20, 79, "#199301"),
		         new Jugador (248, 300, 40, 20, "#199301"),
		         new Jugador (233, 35, 20, 91, "#199301"),
		         new Jugador (253, 80, 79, 20, "#199301"),
		         new Jugador (283, 0, 20, 80, "#199301"),
		         new Jugador (331, 35, 270, 20, "#199301"),
		         new Jugador (359, 55, 20, 95, "#199301"),
		         new Jugador (359, 130, 88, 20, "#199301"),
		         new Jugador (427, 80, 55, 20, "#199301"),
		         new Jugador (427, 100, 20, 30, "#199301"),
		         new Jugador (475, 80, 20, 98, "#199301"),
		         new Jugador (331, 176, 270, 20, "#199301"),
		         new Jugador (528, 55, 20, 95, "#199301"),
		         new Jugador (581, 83, 20, 95, "#199301"),
		         new Jugador (331, 224, 20, 96, "#199301"),
		         new Jugador (390, 194, 20, 28, "#199301"),
		         new Jugador (490, 224, 200, 20, "#199301"),
		         new Jugador (473, 224, 20, 96, "#199301"),
		         new Jugador (379, 300, 110, 20, "#199301"),
		         new Jugador (581, 244, 20, 28, "#199301"), 
		         new Jugador (526, 270, 20, 96, "#199301"),
		         new Jugador (546, 298, 120, 20, "#199301"),
		         new Jugador (574, 346, 60, 20, "#199301"),
		         new Jugador (473, 346, 73, 20, "#199301"),
		         new Jugador (331, 346, 114, 20, "#199301"),
		         new Jugador (331, 394, 114, 20, "#199301"),
		         new Jugador (331, 490, 66, 20, "#199301"),
		         new Jugador (379, 320, 20, 94, "#199301"),
		         new Jugador (425, 414, 20, 101, "#199301"),
		         new Jugador (377, 442, 20, 120, "#199301"),
		         new Jugador (473, 442, 20, 120, "#199301"),
		         new Jugador (295, 442, 54, 20, "#199301"),
		         new Jugador (473, 394, 72, 20, "#199301"),
		         new Jugador (525, 414, 20, 102, "#199301"),
		         new Jugador (574, 476, 60, 20, "#199301"),
		         new Jugador (574, 366, 20, 28, "#199301"),
		         new Jugador (540, 424, 60, 20, "#199301"),};
	}
	
	public void ayuda()
	{
		contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
		tiempo.stop();
		timerPuntos.stop();
	    tiempoCorriendo = tiempo.isRunning() || (h == 0 && m == 0 && s == 0);
	    
		 if (timerMovimiento != null && timerMovimiento.isRunning()) {
	        timerMovimiento.stop();
	    }
	    
		panelAyuda = new JPanel(){
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                for (Point punto : puntosCafes) {
                    g.setColor(Color.decode("#5F5100"));
                    g.fillRect(punto.x, punto.y, 1, 1);
                }
            }
        };
		panelAyuda.setBounds(0, 0, 636, 590);
		panelAyuda.setBackground(Color.black);
		panelAyuda.setLayout(null);
		panelAyuda.setBorder(new LineBorder(new Color(10, 77, 23), 8));
		contentPane.add(panelAyuda);
		
		JLabel info = new JLabel("Objetivo: Ayuda a Harry a llegar a la Copa en el menor tiempo posible.", 0);
		info.setForeground(Color.white);
		info.setFont(new Font("Tahoma", Font.PLAIN, 16));
		info.setBounds(0, 170, 636, 20);
		panelAyuda.add(info);
		
		JLabel ins = new JLabel ("Utiliza las teclas de flecha o WASD para moverte.",0);
		ins.setForeground(Color.white);
		ins.setFont(new Font("Tahoma", Font.PLAIN, 16));
		ins.setBounds(0, 200, 636, 20);
		panelAyuda.add(ins);
		
		JLabel extra = new JLabel ("Atrapar la Snitch te sumará 100 puntos.",0);
		extra.setForeground(Color.white);
		extra.setFont(new Font("Tahoma", Font.PLAIN, 16));
		extra.setBounds(0, 450, 636, 20);
		panelAyuda.add(extra);
		
		JLabel logo4 = new JLabel();
		logo4.setBounds(55, 200, 256, 256);
		panelAyuda.add(logo4);
		logo4.setIcon(new ImageIcon(getClass().getResource("flechas.png")));
		
		JLabel logo5 = new JLabel();
		logo5.setBounds(326, 206, 256, 256);
		panelAyuda.add(logo5);
		logo5.setIcon(new ImageIcon(getClass().getResource("wasd.png")));
		
		JLabel logo6 = new JLabel();
		logo6.setBounds(238, 30, 160, 120);
		panelAyuda.add(logo6);
		logo6.setIcon(new ImageIcon(getClass().getResource("harryAyuda.png")));
		
		JButton btnVolver = new JButton ("Volver");
		btnVolver.setBounds(268,  500, 100, 25);
		btnVolver.setForeground(new Color(0, 0, 0));
		btnVolver.setBackground(new Color(115,105,50));
		btnVolver.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnVolver.setBorder(new LineBorder(new Color(88,0,4), 4));
		btnVolver.setFocusable(false);
		btnVolver.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
				if (!tiempoCorriendo) {
	                tiempo.start();
	                timerPuntos.start();
	                timerMovimiento.start();
				}
		        getContentPane().add(panelDibujo);
		        getContentPane().add(panelBoton);
		        revalidate();
		        repaint();  
			}
		});
		panelAyuda.add(btnVolver);	
	}

	private boolean hayColision() {
	    for (Jugador obs : obs) {
	        if (j1.getX() + j1.getW() > obs.getX() && 
	            j1.getX() < obs.getX() + obs.getW() &&
	            j1.getY() + j1.getH() > obs.getY() &&
	            j1.getY() < obs.getY() + obs.getH()) {
	        	System.out.println("Colision");
	        	//tiempo.stop();
				//finJuego("¡Perdiste!"); //Si chocas pierdes (el movimiento debe ser 1)		
	            return true; // Hay colisión
	        }
	    }
	    if(j1.getX() <=6 || j1.getX() >= 617 || j1.getY() <= 6 || j1.getY() >= 529)
		{
			System.out.println("Colision");
			//tiempo.stop();
			//finJuego("¡Perdiste!"); //Si chocas pierdes (el movimiento debe ser 1)		
			return true; // Hay colision 
		}
	    return false;  // No hay colision 
	
	}

	
	 private void reducirPuntuacion(int puntos) 
	 {
		 nuevaPuntuacion-=puntos; 
	     if (nuevaPuntuacion < 0)
	         nuevaPuntuacion = 0; 
	     actualizarPuntuacion(); 
	 }
	 
	private void actualizarPuntuacion() {
        labelPuntuacion.setText("Puntos: " + nuevaPuntuacion);
    }

	public void ganador()
	{
		if(j1.getX() + j1.getW() > meta.getX() && 
		   j1.getX() < meta.getX()+ meta.getW()  &&
		   j1.getY() + j1.getH() > meta.getY() &&
		   j1.getY() < meta.getY() + meta.getH())
		  {
			System.out.println("Ganaste");
			tiempo.stop();
			finJuego("¡Felicidades, Ganaste!");
		  }	
	}
	
	public void snitch()
	{
	    snitchA=false; 
		if(Math.abs(j1.getCenterX() - ( objSnitch.getX() + objSnitch.getW() / 2)) <= j1.getW() + objSnitch.getW() / 2 &&
		   Math.abs(j1.getCenterY() - (objSnitch.getY() + objSnitch.getH() / 2)) <= j1.getW() + objSnitch.getW() / 2)
		  {
			Sonido.stop();
			Sonido.cambiarPista("src/sonidoSnitch.wav");
    	    nuevaPuntuacion += 100;
    	    System.out.println("Puntos");
    	    actualizarPuntuacion();
    	    snitchA = true;
    	    objSnitch.setX(-20);
    	    objSnitch.setY(-20);
    	    panelDibujo.remove(snitch);
    	    panelDibujo.revalidate();
    	    panelDibujo.repaint();
    	    if(sonidoActivado) {
    	    Timer timer = new Timer(1000, new ActionListener() {
    	        public void actionPerformed(ActionEvent e) {
    	            Sonido.cambiarPista("src/songHarryContinuar.wav");
    	        }
    	    });
    	    timer.setRepeats(false); 
    	    timer.start();
    	    }
		  }	
	}
	
	public void pausar()
	{
		ImageIcon icono = new ImageIcon("src/pausa.png");
		contentPane.removeAll();
        contentPane.revalidate();
        contentPane.repaint();
		tiempo.stop();
		timerPuntos.stop();
	    tiempoCorriendo = tiempo.isRunning() || (h == 0 && m == 0 && s == 0);
	    
		if (timerMovimiento != null && timerMovimiento.isRunning()) {
	        timerMovimiento.stop();
	    }
		panelPausa = new JPanel(){
	            @Override
	            public void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                for (Point punto : puntosCafes) {
	                    g.setColor(Color.decode("#5F5100"));
	                    g.fillRect(punto.x, punto.y, 1, 1);
	                }
	            }
	        };
        panelPausa.setBounds(0, 0, 636, 590);
        panelPausa.setBackground(Color.black);
        panelPausa.setLayout(null);
        panelPausa.setBorder(new LineBorder(new Color(10, 77, 23), 8));
		contentPane.add(panelPausa);
		int option = JOptionPane.showOptionDialog(null, "¿Deseas salir del juego?", "Pausa",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, icono,
                new String[] { "Continuar", "Salir" }, // Los textos de los botones
                "Continuar");
        if (option == JOptionPane.YES_OPTION) {
        	contentPane.removeAll();
	        contentPane.revalidate();
	        contentPane.repaint();
        	if (!tiempoCorriendo) {
                tiempo.start();
                timerPuntos.start();
                timerMovimiento.start();

			}
        	getContentPane().add(panelDibujo);
	        getContentPane().add(panelBoton);
	        revalidate();
	        repaint();
        } else {
            System.exit(0); // Salir del juego
        }
	}
}

