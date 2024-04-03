import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.Color;

public class PuzzleNumero extends JFrame{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static JButton[] botones;
	JPanel _botones; 
	private JPanel panel_1;
	private List<Integer> numeros = new ArrayList<>();

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

		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 97, 253));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		 
		 
		setContentPane(contentPane);
		
		_botones = new JPanel();
		_botones.setBackground(new Color(219, 209, 235));
		contentPane.add(_botones, BorderLayout.CENTER);
		_botones.setBorder(new LineBorder(new Color(180, 97, 253), 10));
		_botones.setLayout(new GridLayout(4, 0, 0, 0));
		
		botones = new JButton[16];

        for (int i = 1; i <= 16; i++) 
        {
            numeros.add(i);
        }
        
        Collections.shuffle(numeros);
        for (int i = 0; i < botones.length; i++) {
            if (i == botones.length-1) //Boton 16
            {
                botones[i] = new JButton("");
            } else {
                botones[i] = new JButton(numeros.get(i) + "");
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
                    click(btn);
                }

            });
            _botones.add(botones[i]);

        }
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(180, 97, 253));
		contentPane.add(panel_1, BorderLayout.SOUTH);
		 
		 JButton botonReiniciar = new JButton();
		 botonReiniciar = new JButton("Reiniciar");
		 botonReiniciar.setFocusable(false);
		 botonReiniciar.setBackground(new Color(221, 183, 255));
		 botonReiniciar.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					reiniciarJuego();
				}
		 });
		 
		 panel_1.add(botonReiniciar);

	}
	
	public void verificarGanador()
	{
		
	}
	
	
	
	public void click(JButton btn)
	{
	//El movimiento solo se puede hacer a donde este vacio el boton	
			
	}
	
	public void reiniciarJuego()
	{
		
	}

	
}
