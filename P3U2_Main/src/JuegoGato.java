import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

public class JuegoGato extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public static boolean turno;
	public static boolean ganador;
	public static JButton btnNewButton;
	public static JButton btnNewButton_1;
	public static JButton btnNewButton_2;
	public static JButton btnNewButton_3;
	public static JButton btnNewButton_5;
	public static JButton btnNewButton_4;
	public static JButton btnNewButton_6;
	public static JButton btnNewButton_7;
	public static JButton btnNewButton_8;
	JPanel panel; 
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

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(3, 3, 3, 3));
		panel.setBackground(new Color(192, 192, 192));
		contentPane.add(panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		btnNewButton = new JButton("");	
		btnNewButton_3 = new JButton("");
		btnNewButton_1 = new JButton("");
		btnNewButton_2 = new JButton("");	
		btnNewButton_4 = new JButton("");	
		btnNewButton_6 = new JButton("");
		btnNewButton_5 = new JButton("");	
		btnNewButton_7 = new JButton("");
		btnNewButton_8 = new JButton("");
		
		btnNewButton.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_1.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_2.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_3.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_4.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_5.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_6.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_7.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton_8.setFont(new Font("Arial Black", Font.BOLD, 26));
		btnNewButton.setFocusable(false); btnNewButton_1.setFocusable(false); btnNewButton_2.setFocusable(false); 
		btnNewButton_3.setFocusable(false); btnNewButton_4.setFocusable(false); btnNewButton_5.setFocusable(false); 
		btnNewButton_6.setFocusable(false); btnNewButton_7.setFocusable(false); btnNewButton_8.setFocusable(false);
		
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		btnNewButton_8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				click(btn);
			}
		});
		
		panel.add(btnNewButton); panel.add(btnNewButton_3); panel.add(btnNewButton_1); 
		panel.add(btnNewButton_2); panel.add(btnNewButton_4); panel.add(btnNewButton_5);
		panel.add(btnNewButton_6); panel.add(btnNewButton_7); panel.add(btnNewButton_8);
	}
	
	public void click(JButton btn)
	{
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton btn=((JButton) e.getSource());
				//1-. si el boton esta libre
				if(btn.getText().equals("")){
					//2 turno
					if(turno) {
						btn.setText("O");
						btn.setBackground(new Color(245, 149, 129));
						turno=false;
						verificarGanador();
					}else {
						btn.setText("X");
						btn.setBackground(new Color(129, 231, 245));
						turno=true;
						verificarGanador();
					}
				}
				
			}
			
		});
	}
	
	public void verificarGanador() {
	        if (!btnNewButton.getText().isEmpty() && 
	            btnNewButton.getText().equals(btnNewButton_1.getText()) && 
	            btnNewButton_1.getText().equals(btnNewButton_3.getText())) {
	            System.out.println("Ganador");
	            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton.getText()+"!");
	            desactivarBotones();
	            return;
	        }
	        
	        if (!btnNewButton_2.getText().isEmpty() && 
		            btnNewButton_2.getText().equals(btnNewButton_4.getText()) && 
		            btnNewButton_4.getText().equals(btnNewButton_5.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton_2.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	        
	        if (!btnNewButton_6.getText().isEmpty() && 
		            btnNewButton_6.getText().equals(btnNewButton_7.getText()) && 
		            btnNewButton_7.getText().equals(btnNewButton_8.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton_6.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	        
	        if (!btnNewButton_2.getText().isEmpty() && 
		            btnNewButton_2.getText().equals(btnNewButton.getText()) && 
		            btnNewButton.getText().equals(btnNewButton_6.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton_2.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	        
	        if (!btnNewButton_3.getText().isEmpty() && 
		            btnNewButton_3.getText().equals(btnNewButton_4.getText()) && 
		            btnNewButton_4.getText().equals(btnNewButton_7.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton_3.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	
	        if (!btnNewButton_1.getText().isEmpty() && 
		            btnNewButton_1.getText().equals(btnNewButton_8.getText()) && 
		            btnNewButton_8.getText().equals(btnNewButton_5.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton_1.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	        
	        if (!btnNewButton.getText().isEmpty() && 
		            btnNewButton.getText().equals(btnNewButton_8.getText()) && 
		            btnNewButton_8.getText().equals(btnNewButton_4.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	        
	        if (!btnNewButton_6.getText().isEmpty() && 
		            btnNewButton_6.getText().equals(btnNewButton_1.getText()) && 
		            btnNewButton_1.getText().equals(btnNewButton_4.getText())) {
		            System.out.println("Ganador");
		            JOptionPane.showMessageDialog(this, "¡Ganador "+ btnNewButton_1.getText()+"!");
		            desactivarBotones();
		            return;
		    }
	        
	        if (!btnNewButton.getText().isEmpty() && !btnNewButton_1.getText().isEmpty() && !btnNewButton_2.getText().isEmpty() &&
	                !btnNewButton_3.getText().isEmpty() && !btnNewButton_4.getText().isEmpty() && !btnNewButton_5.getText().isEmpty() &&
	                !btnNewButton_6.getText().isEmpty() && !btnNewButton_7.getText().isEmpty() && !btnNewButton_8.getText().isEmpty()) {
	                JOptionPane.showMessageDialog(this, "¡Empate!");
	                desactivarBotones();
	                return;
	            }
 
	        
	}
	
	public void desactivarBotones()
	{
		btnNewButton.setEnabled(false);
		btnNewButton_1.setEnabled(false);
		btnNewButton_2.setEnabled(false);
		btnNewButton_3.setEnabled(false);
		btnNewButton_4.setEnabled(false);
		btnNewButton_5.setEnabled(false);
		btnNewButton_6.setEnabled(false);
		btnNewButton_7.setEnabled(false);
		btnNewButton_8.setEnabled(false);
	}
	
		    


}
