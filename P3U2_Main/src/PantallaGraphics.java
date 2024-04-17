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
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PantallaGraphics frame = new PantallaGraphics();
					frame.requestFocus();
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
		
		JPanel panelDibujo = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.setColor(Color.BLUE);
                g.fillRect((getWidth() - 150) / 2,  (getHeight() - 80) / 2, 150, 80);
            }
        };
		panelDibujo.setBounds(0, 0, 636, 550);
		panelDibujo.setBackground(new Color(129, 192, 192));
		panelDibujo.setLayout(null);
		panelDibujo.setBorder(new LineBorder(new Color(64, 128, 128), 10));
		contentPane.add(panelDibujo);
		
		JPanel panelBoton = new JPanel();
		panelBoton.setBounds(0, 550, 636, 63);
		panelBoton.setBackground(new Color(185, 185, 255));
		panelBoton.setLayout(null);
		panelBoton.setBorder(BorderFactory.createLineBorder(new Color(81, 81, 255),10));
		contentPane.add(panelBoton);
		
		JButton btnReiniciar = new JButton("Reiniciar");
		btnReiniciar.setBounds(275, 21, 85, 21);
		btnReiniciar.setForeground(new Color(255, 255, 255));
		btnReiniciar.setBackground(new Color(0, 128, 192));
		btnReiniciar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		btnReiniciar.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		btnReiniciar.setFocusable(false);
		btnReiniciar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
