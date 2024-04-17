import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Graphics;

public class PantallaGraphics extends JFrame implements KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane,  panelDibujo;
	int x= 200;
    int y = 200;

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
		setTitle("Pantalla Graphics");
		setResizable(false);
		setSize(650,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panelDibujo = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(new Color(134,153,255));
                g.fillRect(x,  y, 20, 20);
            }
        };
		panelDibujo.setBounds(0, 0, 636, 550);
		panelDibujo.setBackground(Color.black);
		panelDibujo.setLayout(null);
		panelDibujo.setBorder(new LineBorder(new Color(81, 81, 255), 10));
		contentPane.add(panelDibujo);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBounds(0, 550, 636, 63);
		panelBoton.setBackground(new Color(81, 81, 255));
		panelBoton.setLayout(null);
		contentPane.add(panelBoton);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds((panelBoton.getWidth() - 100) / 2,  (panelBoton.getHeight()-30) / 2, 100, 25);
		btnReiniciar.setForeground(new Color(0, 0, 0));
		btnReiniciar.setBackground(new Color(197,255,246));
		btnReiniciar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 16));
		btnReiniciar.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		btnReiniciar.setFocusable(false);
		btnReiniciar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
	
		});
		panelBoton.add(btnReiniciar);
				
	}
	
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode()+" "+e.getKeyChar());
		
		 switch (e.getKeyCode()) {
	        case 37: 
	        case 65:	//a - Izquierda
	        	x -= 10;
	            break;
	        case 39:
	        case 68:	// d - derecha
	        	x += 10;
	            break;
	        case 38:
	        case 87: // w - arriba
	        	y -=10;
	            break;
	        case 40:
	        case 83:	// s - abajo
	        	y += 10;
	            break;
	        default:
	            return;
	    }
		 this.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
