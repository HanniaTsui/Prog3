import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.Component;

public class Sesion_Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombres;
	private JTextField apellidos;
	private JTextField email;
	private JCheckBox terminos;
	private JPasswordField password;
	private JPasswordField confPassword;
	private JLabel labelUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Sesion_Registro frame = new Sesion_Registro();
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
	public Sesion_Registro() {
		//setResizable(false);
	//	setTitle("Ventana");
		setSize(450,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
	//	this.login();
	//	this.registro();
		this.recuperarCuenta();
	//	menu();
		
	
	}
	
	public void menu() {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(450, 15));
		contentPane.add(panel, BorderLayout.NORTH);
		//panel.setLayout(null);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 0, 240, 22);
		panel.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("Cuenta");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem item1 = new JMenuItem("Iniciar Sesión");
		item1.addActionListener(new ActionListener()
		{
			
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        login();
        	}
        });
		mnNewMenu_1.add(item1);
		
		JMenuItem item2 = new JMenuItem("Registrarse");
		item2.addActionListener(new ActionListener()
		{
			
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        registro();
        	}
        });
		mnNewMenu_1.add(item2);
		
		JMenuItem item3 = new JMenuItem("Recuperar cuenta");
		item3.addActionListener(new ActionListener()
		{
			
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        recuperarCuenta();
        	}
        });
		mnNewMenu_1.add(item3);
		
		JMenu mnNewMenu = new JMenu("Usuarios");
		menuBar_1.add(mnNewMenu);
		
		JMenuItem item4 = new JMenuItem("Alta");
		mnNewMenu.add(item4);
		
		JMenuItem item5 = new JMenuItem("Baja");
		mnNewMenu.add(item5);
		
		JMenuItem item6 = new JMenuItem("Consultar");
		mnNewMenu.add(item6);
		
		JMenu mnNewMenu_6 = new JMenu("Ayuda");
		menuBar_1.add(mnNewMenu_6);
		
		JMenuItem item7 = new JMenuItem("¿Cómo crear un usuario?");
		mnNewMenu_6.add(item7);
		
		JMenuItem item8 = new JMenuItem("¿Cómo acceder al sistema?");
		mnNewMenu_6.add(item8);
		
		JMenuItem item9 = new JMenuItem("¿Qué pasa si olvide mi contraseña?");
		mnNewMenu_6.add(item9);
		
		
	}
	
	public void login()
	{
		// LOGIN
		menu();
		setTitle("Inicio de sesión");
		JPanel panelLogin = new JPanel();
		panelLogin.setFocusable(false);
		panelLogin.setBackground(new Color(129, 192, 192));
		panelLogin.setLayout(null);
		panelLogin.setBorder(new LineBorder(new Color(64, 128, 128), 10));
		contentPane.add(panelLogin, BorderLayout.CENTER);
		
		
		JLabel titulo = new JLabel("INICIO DE SESIÓN");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(140,30,187,45);
		panelLogin.add(titulo);
		
		JLabel logo4 = new JLabel();
		logo4.setIcon(new ImageIcon(getClass().getResource("usuarioSesion.png")));
		logo4.setBounds(118,41,24,24);
		panelLogin.add(logo4);
		
		JLabel logo5 = new JLabel();
		logo5.setIcon(new ImageIcon(getClass().getResource("usuarioInicio.png")));
		logo5.setBounds(150,112,128,128);
		panelLogin.add(logo5);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelUsuario.setBounds(85, 237, 80, 45);
		panelLogin.add(labelUsuario);
		
		
		nombres = new JTextField();
		nombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombres.setBounds(85, 275, 250, 30);
        nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelLogin.add(nombres);
		
		
		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelPassword.setBounds(85, 304, 100, 45);
		panelLogin.add(labelPassword);
		
		
		password = new JPasswordField();
		password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		password.setBounds(85, 341, 210, 30);
		password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelLogin.add(password);
		
		JLabel logo2 = new JLabel();
		logo2.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logo2.setBounds(303,346,24,24);
		panelLogin.add(logo2); 
		
		JButton boton = new JButton("Acceder");
		boton.setBorderPainted(false);
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(0, 128, 128));
		boton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		boton.setBorder(new LineBorder(new Color(0, 189, 189), 5));
		boton.setBounds(158, 500, 120, 30);
		boton.setFocusable(false);
		boton.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		String usr = nombres.getText();
				String pwd = new String (password.getPassword());
				
				
				if (usr.length()<=0)
				{
					nombres.setBorder(BorderFactory.createLineBorder(Color.red,5));
				} else {
					 nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
				}
				if(pwd.length()<=0) {
					password.setBorder(BorderFactory.createLineBorder(Color.red,5));
				} else
				{
					 password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
				}
				
				if(usr.equals("Yo"))
				{
					if(pwd.equals("123"))
					{
						JOptionPane.showMessageDialog(null, "Bienvenido");
					}
					else {
		                JOptionPane.showMessageDialog(null, "Contraseña incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
		            }
				}else {
					JOptionPane.showMessageDialog(null, "Usuario no encontrado","Error", JOptionPane.WARNING_MESSAGE);
				}
                
			}});      
		
		panelLogin.add(boton);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Recordarme");
		chckbxNewCheckBox.setFocusable(false);
		chckbxNewCheckBox.setBackground(null);
		chckbxNewCheckBox.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		chckbxNewCheckBox.setBounds(85, 377, 100, 21);
		panelLogin.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("¿Es tu primera vez?");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		lblNewLabel.setBounds(100, 75, 150, 16);
		panelLogin.add(lblNewLabel);
		
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
				
				contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        
		        // Mostrar el panel de registro
		        registro();
			//System.out.print("hola");
			}
		});
		
		JButton botonRegistro_1 = new JButton("<html><u>¿Olvidaste tu contraseña?</u></html>");
		botonRegistro_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		botonRegistro_1.setForeground(new Color(0, 64, 64));
		botonRegistro_1.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		botonRegistro_1.setFocusable(false);
		botonRegistro_1.setFocusPainted(false);
		botonRegistro_1.setContentAreaFilled(false);
		botonRegistro_1.setBorder(null);
		botonRegistro_1.setBackground(new Color(129, 192, 192));
		botonRegistro_1.setBounds(135, 425, 165, 21);
		panelLogin.add(botonRegistro_1);
		botonRegistro.setBounds(227, 72, 95, 21);
		panelLogin.add(botonRegistro);
			
	}
	
	public void registro()
	{
		menu();
		setTitle("Registro");
		JPanel panelRegistro = new JPanel();
		panelRegistro.setBackground(new Color(185, 185, 255));
		panelRegistro.setSize(this.getWidth(), this.getHeight());
		panelRegistro.setLayout(null);
		panelRegistro.setBorder(BorderFactory.createLineBorder(new Color(81, 81, 255),10));
			
		contentPane.add(panelRegistro);
		
		JLabel titulo = new JLabel("REGISTRARSE");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		
		titulo.setBounds(153,23,135,45);
		panelRegistro.add(titulo);
		
		JLabel logo3 = new JLabel();
		logo3.setIcon(new ImageIcon(getClass().getResource("usuarioReg.png")));
		logo3.setBounds(118,34,24,24);
		panelRegistro.add(logo3);
		
		
		
		JLabel labelNombre = new JLabel("Nombre(s)");
		labelNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelNombre.setBounds(100, 67, 80, 45);
		panelRegistro.add(labelNombre);
		
		
		nombres = new JTextField();
		nombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombres.setBounds(100, 104, 220, 30);
        nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(nombres);
		
		
		/////
		
		JLabel labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelApellidos.setBounds(100, 142, 80, 45);
		panelRegistro.add(labelApellidos);
		
		apellidos = new JTextField();
		apellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		apellidos.setBounds(100, 179, 220, 30);
		apellidos.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(apellidos);
		
		////
		
		
		JLabel labelEmail = new JLabel("Correo Electrónico");
		labelEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelEmail.setBounds(100, 217, 220, 45);
		panelRegistro.add(labelEmail);
		
		email = new JTextField();
		email.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		email.setBounds(100, 254, 220, 30);
		email.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
        
		panelRegistro.add(email);
		
		///// 
		
		JLabel labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelPassword.setBounds(100, 292, 100, 45);
		panelRegistro.add(labelPassword);
		
		
		password = new JPasswordField();
		password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		password.setBounds(100, 329, 180, 30);
		password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(password);
		
		JLabel logo2 = new JLabel();
		logo2.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logo2.setBounds(290,332,24,24);
		panelRegistro.add(logo2); 
		
		///
		
		JLabel labelConfPassword = new JLabel("Confirmar Contraseña");
		labelConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelConfPassword.setBounds(100, 367, 180, 45);
		panelRegistro.add(labelConfPassword);
		
		confPassword = new JPasswordField();
		confPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		confPassword.setBounds(100, 404, 180, 30);
		confPassword.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(confPassword);
		
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logo.setBounds(290,407,24,24);
		panelRegistro.add(logo); 
		
		
		terminos = new JCheckBox("Acepto términos y condiciones");
		terminos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 11));
		terminos.setBounds(110, 440, 200, 45);
		terminos.setOpaque(false);
		terminos.setFocusable(false);
		terminos.setBackground(null);
		panelRegistro.add(terminos);
		
	
		
		JButton boton = new JButton("Confirmar");
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(81, 81, 255));
		boton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		boton.setBorder(new LineBorder(new Color(0, 0, 128), 3));
		boton.setBounds(150, 520, 120, 30);
		boton.setFocusable(false);
		boton.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String pwd = new String (password.getPassword());
				String confpwd = new String (confPassword.getPassword());
				
				
				if (!pwd.equals(confpwd) || pwd.length()<=0 || confpwd.length()<=0)
				{
					password.setBorder(BorderFactory.createLineBorder(Color.red,5));
					confPassword.setBorder(BorderFactory.createLineBorder(Color.red,5));
					
					
					if(pwd.length()<=0 || confpwd.length()<=0)
						JOptionPane.showMessageDialog(null, "Por favor, complete ambos campos de contraseña", "Error", JOptionPane.WARNING_MESSAGE);
					else
						JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Error", JOptionPane.WARNING_MESSAGE);
					
					return; 
				} else {
					password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
					confPassword.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
				}
					
				if(!terminos.isSelected()) {
					terminos.setBorderPainted(true);
					terminos.setBorder(BorderFactory.createLineBorder(Color.red, 3));
					return;
				} else {
					 terminos.setBorder(null);
				}
				
				System.out.println("Registro exitoso");
				JOptionPane.showMessageDialog(null, "Registro exitoso");
                
			}});      
		
		panelRegistro.add(boton);
		
		JButton btnCuenta = new JButton("<html><u>¿Ya tienes cuenta?</u></html>");
		btnCuenta.setForeground(new Color(0, 0, 128));
		btnCuenta.setBackground(new Color(185, 185, 255));
		btnCuenta.setBorder(null);
		btnCuenta.setBounds(120, 485, 179, 21);
		panelRegistro.add(btnCuenta);
		
		
		btnCuenta.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		btnCuenta.setFocusPainted(false);
		btnCuenta.setFocusable(false);
		
		btnCuenta.setContentAreaFilled(false);

		btnCuenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        login();
			}
		});
	}

	public void recuperarCuenta()
	{
		menu();
		setTitle("Recuperar cuenta");
		JPanel panelLogin = new JPanel();
		panelLogin.setFocusable(false);
		panelLogin.setBackground(new Color(255, 179, 142));
		panelLogin.setLayout(null);
		panelLogin.setBorder(new LineBorder(new Color(191, 63, 0), 10));
		contentPane.add(panelLogin, BorderLayout.CENTER);
		
		
		JLabel titulo = new JLabel("RECUPERACIÓN DE CUENTA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(87,31,265,45);
		panelLogin.add(titulo);
	}
}
