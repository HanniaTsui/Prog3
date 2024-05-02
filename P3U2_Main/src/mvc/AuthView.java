package mvc;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;


public class AuthView {
	JPanel panel;
	AuthModel modelo;
	public AuthView() {
		// TODO Auto-generated constructor stub
		panel = new JPanel();
		modelo = new AuthModel();
		
	}
	
	public JPanel login() {
		//Diseño de login 
		

	//	contentPane.setLayout(new BorderLayout(0, 0));
		
		panel.setName("Inicio de sesión");
		panel.setBackground(new Color(129, 192, 192));
		panel.setLayout(null);
		panel.setBorder(new LineBorder(new Color(64, 128, 128), 10));
					
		JLabel titulo = new JLabel("INICIO DE SESIÓN");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(140,30,187,45);
		panel.add(titulo);
		
		
		JLabel labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelUsuario.setBounds(85, 237, 80, 45);
		panel.add(labelUsuario);	
		
		JTextField nombres = new JTextField();
		nombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombres.setBounds(85, 275, 265, 30);
        nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panel.add(nombres);	
		
		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelPassword.setBounds(85, 304, 100, 45);
		panel.add(labelPassword);	
		
		JPasswordField password = new JPasswordField();
		password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		password.setBounds(85, 341, 225, 30);
		password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panel.add(password);
		
		
		JButton botonAcceder = new JButton("Acceder");
		botonAcceder.setBorderPainted(false);
		botonAcceder.setForeground(new Color(255, 255, 255));
		botonAcceder.setBackground(new Color(0, 128, 128));
		botonAcceder.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		botonAcceder.setBorder(new LineBorder(new Color(0, 189, 189), 5));
		botonAcceder.setBounds(158, 500, 120, 30);
		botonAcceder.setFocusable(false);
		botonAcceder.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		System.out.println(nombres.getText());
        		System.out.println(password.getPassword());
        		String pwd = new String (password.getPassword());
        		if( modelo.login(nombres.getText(), pwd))
        			System.out.println("Bienvenido");
        		else
        			System.out.println("Verificar los datos");
			}});      
		
		panel.add(botonAcceder);
		
		JCheckBox botonRecordar = new JCheckBox("Recordarme");
		botonRecordar.setFocusable(false);
		botonRecordar.setBackground(null);
		botonRecordar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		botonRecordar.setBounds(85, 377, 100, 21);
		panel.add(botonRecordar);
		
		JLabel labelPregunta = new JLabel("¿Es tu primera vez?");
		labelPregunta.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		labelPregunta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		labelPregunta.setBounds(100, 75, 150, 16);
		panel.add(labelPregunta);
		
		JButton botonRegistro = new JButton("<html><u>Regístrate</u></html>");
		botonRegistro.setBorder(null);
		botonRegistro.setBackground(new Color(129, 192, 192));
		botonRegistro.setForeground(new Color(0, 64, 64));
		botonRegistro.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		botonRegistro.setFocusPainted(false);
		botonRegistro.setFocusable(false);
		botonRegistro.setContentAreaFilled(false);
		botonRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		botonRegistro.setBounds(227, 72, 95, 21);
		panel.add(botonRegistro);
		
		JButton botonOlvidaste = new JButton("<html><u>¿Olvidaste tu contraseña?</u></html>");
		botonOlvidaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		botonOlvidaste.setForeground(new Color(0, 64, 64));
		botonOlvidaste.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		botonOlvidaste.setFocusable(false);
		botonOlvidaste.setFocusPainted(false);
		botonOlvidaste.setContentAreaFilled(false);
		botonOlvidaste.setBorder(null);
		botonOlvidaste.setBackground(new Color(129, 192, 192));
		botonOlvidaste.setBounds(135, 425, 165, 21);
		panel.add(botonOlvidaste);
		
		return panel;
	}
	
	public JPanel registro() {
		//Diseño de registro 
		panel.setBackground(Color.blue);
		return panel;
	}

}
