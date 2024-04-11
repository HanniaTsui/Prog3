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
	private JTextField nombres, apellidos, email;
	private JCheckBox terminos;
	private JPasswordField password, confPassword;
	private JLabel labelUsuario, logo,logo2,logo3,logo4, logo5, titulo, labelPassword, labelPregunta, labelNombre, labelApellidos,labelEmail, labelConfPassword;

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

	public Sesion_Registro() {
		setResizable(false);
		setSize(450,650);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		this.login();
	//	this.registro();
	//	this.recuperarCuenta();
	//	this.alta();
	//	this.baja();
	//	this.consultar();
	//	this.accederSistema();
	//	this.crearUsuario();
	//	this.olvideMiContraseña();
	}
	
	public void menu() {
		JPanel panel = new JPanel();
		panel.setSize(new Dimension(450, 15));
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		JMenuBar menu = new JMenuBar();
		menu.setBounds(0, 0, 240, 22);
		panel.add(menu);
		
		JMenu subMenu1 = new JMenu("Cuenta");
		menu.add(subMenu1);
		
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
		subMenu1.add(item1);
		
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
		subMenu1.add(item2);
		
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
		subMenu1.add(item3);
		
		JMenu subMenu2 = new JMenu("Usuarios");
		menu.add(subMenu2);
		
		JMenuItem item4 = new JMenuItem("Alta");
		item4.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        alta();
        	}
        });
		subMenu2.add(item4);
		
		JMenuItem item5 = new JMenuItem("Baja");
		item5.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        baja();
        	}
        });
		subMenu2.add(item5);
		
		JMenuItem item6 = new JMenuItem("Consultar");
		item6.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        consultar();
        	}
        });
		subMenu2.add(item6);
		
		JMenu subMenu3 = new JMenu("Ayuda");
		menu.add(subMenu3);
		
		JMenuItem item7 = new JMenuItem("¿Cómo crear un usuario?");
		item7.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        crearUsuario();
        	}
        });
		subMenu3.add(item7);
		
		JMenuItem item8 = new JMenuItem("¿Cómo acceder al sistema?");
		item8.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        accederSistema();
        	}
        });
		subMenu3.add(item8);
		
		JMenuItem item9 = new JMenuItem("¿Qué pasa si olvide mi contraseña?");
		item9.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
        		contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        olvideMiContraseña();
        	}
        });
		subMenu3.add(item9);
	}
	
	public void login()
	{
		menu();
		setTitle("Inicio de sesión");
		JPanel panelLogin = new JPanel();
		panelLogin.setFocusable(false);
		panelLogin.setBackground(new Color(129, 192, 192));
		panelLogin.setLayout(null);
		panelLogin.setBorder(new LineBorder(new Color(64, 128, 128), 10));
		contentPane.add(panelLogin, BorderLayout.CENTER);		
		
		titulo = new JLabel("INICIO DE SESIÓN");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(140,30,187,45);
		panelLogin.add(titulo);
		
		logo4 = new JLabel();
		logo4.setIcon(new ImageIcon(getClass().getResource("usuarioSesion.png")));
		logo4.setBounds(118,41,24,24);
		panelLogin.add(logo4);
		
		logo5 = new JLabel();
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
		
		labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelPassword.setBounds(85, 304, 100, 45);
		panelLogin.add(labelPassword);	
		
		password = new JPasswordField();
		password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		password.setBounds(85, 341, 210, 30);
		password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelLogin.add(password);
		
		logo2 = new JLabel();
		logo2.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logo2.setBounds(303,346,24,24);
		panelLogin.add(logo2); 
		
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
		
		panelLogin.add(botonAcceder);
		
		JCheckBox botonRecordar = new JCheckBox("Recordarme");
		botonRecordar.setFocusable(false);
		botonRecordar.setBackground(null);
		botonRecordar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 12));
		botonRecordar.setBounds(85, 377, 100, 21);
		panelLogin.add(botonRecordar);
		
		labelPregunta = new JLabel("¿Es tu primera vez?");
		labelPregunta.setHorizontalTextPosition(SwingConstants.CENTER);
		labelPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		labelPregunta.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 13));
		labelPregunta.setBounds(100, 75, 150, 16);
		panelLogin.add(labelPregunta);
		
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
		        registro();
			}
		});
		
		JButton botonOlvidaste = new JButton("<html><u>¿Olvidaste tu contraseña?</u></html>");
		botonOlvidaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        recuperarCuenta();
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
		panelLogin.add(botonOlvidaste);
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
		
		titulo = new JLabel("REGISTRARSE");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(153,23,135,45);
		panelRegistro.add(titulo);
		
		logo3 = new JLabel();
		logo3.setIcon(new ImageIcon(getClass().getResource("usuarioReg.png")));
		logo3.setBounds(118,34,24,24);
		panelRegistro.add(logo3);
		
		labelNombre = new JLabel("Nombre(s)");
		labelNombre.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelNombre.setBounds(100, 67, 80, 45);
		panelRegistro.add(labelNombre);
			
		nombres = new JTextField();
		nombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombres.setBounds(100, 104, 220, 30);
        nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(nombres);
		
		labelApellidos = new JLabel("Apellidos");
		labelApellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelApellidos.setBounds(100, 142, 80, 45);
		panelRegistro.add(labelApellidos);
		
		apellidos = new JTextField();
		apellidos.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		apellidos.setBounds(100, 179, 220, 30);
		apellidos.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(apellidos);
		
		labelEmail = new JLabel("Correo Electrónico");
		labelEmail.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelEmail.setBounds(100, 217, 220, 45);
		panelRegistro.add(labelEmail);
		
		email = new JTextField();
		email.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		email.setBounds(100, 254, 220, 30);
		email.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(email);
		
		labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelPassword.setBounds(100, 292, 100, 45);
		panelRegistro.add(labelPassword);
				
		password = new JPasswordField();
		password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		password.setBounds(100, 329, 180, 30);
		password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(password);
		
		logo2 = new JLabel();
		logo2.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logo2.setBounds(290,332,24,24);
		panelRegistro.add(logo2); 
		
		labelConfPassword = new JLabel("Confirmar Contraseña");
		labelConfPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelConfPassword.setBounds(100, 367, 180, 45);
		panelRegistro.add(labelConfPassword);
		
		confPassword = new JPasswordField();
		confPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		confPassword.setBounds(100, 404, 180, 30);
		confPassword.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRegistro.add(confPassword);
		
		logo = new JLabel();
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
				JOptionPane.showMessageDialog(null, "Registro exitoso");
                
			}});      
		panelRegistro.add(boton);
		
		JButton btnCuenta = new JButton("<html><u>¿Ya tienes cuenta?</u></html>");
		btnCuenta.setForeground(new Color(0, 0, 128));
		btnCuenta.setBackground(new Color(185, 185, 255));
		btnCuenta.setBorder(null);
		btnCuenta.setBounds(120, 485, 179, 21);
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
		panelRegistro.add(btnCuenta);
	}

	public void recuperarCuenta()
	{
		menu();
		setTitle("Recuperar cuenta");
		JPanel panelRecuperar = new JPanel();
		panelRecuperar.setFocusable(false);
		panelRecuperar.setBackground(new Color(255, 179, 142));
		panelRecuperar.setLayout(null);
		panelRecuperar.setBorder(new LineBorder(new Color(191, 63, 0), 10));
		contentPane.add(panelRecuperar, BorderLayout.CENTER);
		
		titulo = new JLabel("RECUPERACIÓN DE CUENTA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(87,31,265,45);
		panelRecuperar.add(titulo);
		
		logo5 = new JLabel();
		logo5.setIcon(new ImageIcon(getClass().getResource("recuperar.png")));
		logo5.setBounds(150,85,128,128);
		panelRecuperar.add(logo5);
		
		labelUsuario = new JLabel("Correo electrónico");
		labelUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelUsuario.setBounds(85, 218, 140, 45);
		panelRecuperar.add(labelUsuario);
		
		nombres = new JTextField();
		nombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombres.setBounds(85, 256, 250, 30);
        nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelRecuperar.add(nombres);
		
		JButton btnCorreo = new JButton("<html><u>¿Olvidaste el correo electrónico?</u></html>");
		btnCorreo.setForeground(new Color(128, 0, 0));
		btnCorreo.setBackground(new Color(185, 185, 255));
		btnCorreo.setBorder(null);
		btnCorreo.setBounds(85, 310, 250, 21);
		panelRecuperar.add(btnCorreo);
		btnCorreo.setFont(new Font("Arial Rounded MT Bold", Font.ITALIC, 12));
		btnCorreo.setFocusPainted(false);
		btnCorreo.setFocusable(false);
		btnCorreo.setContentAreaFilled(false);
		btnCorreo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        menu();
			}
		});
		
		JButton boton = new JButton("Siguiente");
		boton.setForeground(new Color(255, 255, 255));
		boton.setBackground(new Color(191, 63, 0));
		boton.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		boton.setBorder(null);
		boton.setBounds(252, 490, 120, 30);
		boton.setFocusable(false);
		boton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub				
			}
		});
		panelRecuperar.add(boton);
		
		JButton botonCancelar = new JButton("Cancelar");
		botonCancelar.setForeground(new Color(0, 0, 0));
		botonCancelar.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		botonCancelar.setFocusable(false);
		botonCancelar.setBorder(new LineBorder(new Color(128, 128, 128)));
		botonCancelar.setBackground(new Color(192, 192, 192));
		botonCancelar.setBounds(50, 490, 120, 30);
		botonCancelar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
		        login();
			}
		});
		panelRecuperar.add(botonCancelar);
	}
	
	
	public void alta()
	{
		menu();
		setTitle("Alta");
		JPanel panelAlta = new JPanel();
		panelAlta.setFocusable(false);
		panelAlta.setBackground(new Color(255, 128, 192));
		panelAlta.setLayout(null);
		panelAlta.setBorder(new LineBorder(new Color(128, 0, 64), 10));
		contentPane.add(panelAlta, BorderLayout.CENTER);		
		
		titulo = new JLabel("ALTA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(168,30,100,45);
		panelAlta.add(titulo);
		
	}
	
	public void baja()
	{
		menu();
		setTitle("Baja");
		JPanel panelBaja = new JPanel();
		panelBaja.setFocusable(false);
		panelBaja.setBackground(new Color(168, 168, 213));
		panelBaja.setLayout(null);
		panelBaja.setBorder(new LineBorder(new Color(64, 0, 64), 10));
		contentPane.add(panelBaja, BorderLayout.CENTER);		
		
		titulo = new JLabel("BAJA");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(168,30,100,45);
		panelBaja.add(titulo);
	}
	
	public void consultar()
	{
		menu();
		setTitle("Consultar");
		JPanel panelConsultar = new JPanel();
		panelConsultar.setFocusable(false);
		panelConsultar.setBackground(new Color(255, 162, 162));
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new LineBorder(new Color(136, 0, 0), 10));
		contentPane.add(panelConsultar, BorderLayout.CENTER);		
		
		titulo = new JLabel("CONSULTAR");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(158,30,120,45);
		panelConsultar.add(titulo);
	}
	
	public void crearUsuario()
	{
		menu();
		setTitle("¿Cómo crear un usuario?");
		JPanel panelConsultar = new JPanel();
		panelConsultar.setFocusable(false);
		panelConsultar.setBackground(new Color(192, 192, 192));
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new LineBorder(new Color(128, 128, 128), 10));
		contentPane.add(panelConsultar, BorderLayout.CENTER);		
		
		titulo = new JLabel("¿CÓMO CREAR UN USUARIO?");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(78,30,280,45);
		panelConsultar.add(titulo);
	}
	
	public void accederSistema()
	{
		menu();
		setTitle("¿Cómo acceder al sistema?");
		JPanel panelConsultar = new JPanel();
		panelConsultar.setFocusable(false);
		panelConsultar.setBackground(new Color(192, 192, 192));
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new LineBorder(new Color(128, 128, 128), 10));
		contentPane.add(panelConsultar, BorderLayout.CENTER);		
		
		titulo = new JLabel("¿CÓMO ACCEDER AL SISTEMA?");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(68,30,300,45);
		panelConsultar.add(titulo);
	}
	
	public void olvideMiContraseña()
	{
		menu();
		setTitle("¿Qué pasa si olvide mi contraseña?");
		JPanel panelConsultar = new JPanel();
		panelConsultar.setFocusable(false);
		panelConsultar.setBackground(new Color(192, 192, 192));
		panelConsultar.setLayout(null);
		panelConsultar.setBorder(new LineBorder(new Color(128, 128, 128), 10));
		contentPane.add(panelConsultar, BorderLayout.CENTER);		
		
		titulo = new JLabel("¿QUÉ PASA SI OLVIDE MI CONTRASEÑA?");
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setHorizontalTextPosition(SwingConstants.CENTER);
		titulo.setBorder(null);
		titulo.setForeground(new Color(0, 0, 0));
		titulo.setFont(new Font("Arial Black", Font.BOLD, 16));
		titulo.setBounds(0,30,435,45);
		panelConsultar.add(titulo);
	}
}