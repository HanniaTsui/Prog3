import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class Ventana extends JFrame{

	public Ventana() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("Mi ventana");
		this.setSize(900,760);
		this.setLocation(120,120);
		this.setLocationRelativeTo(null);
		this.setMaximumSize(new Dimension (600,600));
		this.setMinimumSize(new Dimension (250,250));
		//ventana.setResizable(false);
		this.setLayout(null);
		
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true); 
	}
	
	public void iniciarComponentes()
	{
		
        //PANEL DERECHO
		JPanel registro = new JPanel(); // Agregar otro panel
		registro.setSize(this.getWidth()/2, this.getHeight());
		registro.setLocation(450,0);
		registro.setBackground(new Color(163, 185, 220));
		registro.setLayout(null);
		
		JLabel registroTitulo = new JLabel("REGISTRO", JLabel.CENTER);
		registroTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		registroTitulo.setForeground(Color.white);
		registroTitulo.setSize(450,30);
		registroTitulo.setLocation(1,30); 
		registroTitulo.setOpaque(true);
		registroTitulo.setBackground(Color.blue);
		registro.add(registroTitulo);
		
		
		JLabel registroNombre = new JLabel ("Nombre de usuario",0);
		registroNombre.setFont(new Font("Consolas", Font.BOLD, 18));
		registroNombre.setForeground(Color.black);
		registroNombre.setBackground(new Color(140, 179, 241));
		registroNombre.setBounds(80,100,290,25); 
		registroNombre.setOpaque(true);
		registro.add(registroNombre);
		
		JTextField registroUsuario = new JTextField();
		registroUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		registroUsuario.setForeground(Color.black);
		registroUsuario.setHorizontalAlignment(0); //Alinear al centro
		registroUsuario.setBounds(80, 130, 290, 30);
		registro.add(registroUsuario);
		
		JLabel bio = new JLabel ("Bio");
		bio.setFont(new Font("Consolas", Font.BOLD, 18));
		bio.setForeground(Color.black);
		bio.setBounds(205,170,40,30); 
		registro.add(bio);
		
		JTextArea bio_text = new JTextArea();
		bio_text.setFont(new Font("Consolas", Font.PLAIN, 16));
		bio_text.setForeground(Color.black);
		bio_text.setBounds(80, 200, 290, 80);
		registro.add(bio_text);

		JLabel prefer = new JLabel ("Preferencias",0);
		prefer.setFont(new Font("Consolas", Font.BOLD,18));
		prefer.setForeground(Color.black);
		prefer.setBackground(new Color (140, 179, 241 ));
		prefer.setBounds(80,300,290,30); 
		prefer.setOpaque(true);
		registro.add(prefer);
		
		JCheckBox item_box_1 = new JCheckBox("Dulce");
		item_box_1.setFont(new Font("Consolas", Font.BOLD,16));
		item_box_1.setForeground(Color.black);
		item_box_1.setBounds(80,330,80,30); 
		item_box_1.setOpaque(false);
		registro.add(item_box_1);
		
		JCheckBox item_box_2 = new JCheckBox("Salado");
		item_box_2.setFont(new Font("Consolas", Font.BOLD,16));
		item_box_2.setForeground(Color.black);
		item_box_2.setBounds(170,330,90,30); 
		item_box_2.setOpaque(false);
		registro.add(item_box_2);
		
		JCheckBox item_box_3 = new JCheckBox("Saludable");
		item_box_3.setFont(new Font("Consolas", Font.BOLD,16));
		item_box_3.setForeground(Color.black);
		item_box_3.setBounds(270,330,110,30); 
		item_box_3.setOpaque(false);
		registro.add(item_box_3);
		
		JLabel terminos = new JLabel ("Terminos",0);
		terminos.setFont(new Font("Consolas", Font.BOLD,18));
		terminos.setForeground(Color.black);
		terminos.setOpaque(true);
		terminos.setBackground(new Color(140, 179, 241));
		terminos.setBounds(80,380,290,30); 
		registro.add(terminos);
		
		JRadioButton aceptarTerminos = new JRadioButton("Aceptar");
		aceptarTerminos.setFont(new Font("Consolas", Font.BOLD,16));
		aceptarTerminos.setForeground(Color.black);
		aceptarTerminos.setOpaque(false);
		aceptarTerminos.setBounds(80,420,100,30); 
		registro.add(aceptarTerminos);
		
		
		JRadioButton noTerminos = new JRadioButton("No aceptar");
		noTerminos.setFont(new Font("Consolas", Font.BOLD,16));
		noTerminos.setForeground(Color.black);
		noTerminos.setOpaque(false);
		noTerminos.setBounds(260,420,120,30);
		registro.add(noTerminos);
		
		ButtonGroup terms = new ButtonGroup();
		terms.add(aceptarTerminos);
		terms.add(noTerminos);
		
		JLabel lugar = new JLabel ("Localidad",0);
		lugar.setFont(new Font("Consolas", Font.BOLD,18));
		lugar.setForeground(Color.black);
		lugar.setOpaque(true);
		lugar.setBackground(new Color(140, 179, 241));
		lugar.setBounds(80,470,290,30); 
		registro.add(lugar);
		
		String colonia[]= {"Seleccione su colonia", "Centro","Camino Real", "Pedregal", "Conchalito"};
		JComboBox locacion = new JComboBox(colonia);
		locacion.setFont(new Font("Consolas", Font.BOLD,16));
		locacion.setForeground(new Color(68, 72, 77));
		locacion.setOpaque(false);
		locacion.setBounds(80,510,290,30);
		registro.add(locacion);
		
		
		JButton registroAceptar = new JButton ("Aceptar");
		registroAceptar.setBackground(new Color (15,55,121));
		registroAceptar.setFont(new Font("Consolas", Font.BOLD, 18));
        registroAceptar.setForeground(Color.WHITE);
        registroAceptar.setBounds(150, 600, 150, 50);
        registroAceptar.setBorderPainted(true);
        registroAceptar.setBorder(BorderFactory.createLineBorder(new Color(8, 36, 81), 5));
        registro.add(registroAceptar);
		
		this.login();
		this.add(registro);
		

	}
	
	public void login()
	{
		JPanel login = new JPanel();
		login.setSize(this.getWidth()/2, this.getHeight());
		login.setBackground(new Color(205, 217, 237));
		login.setLayout(null);
		
		JLabel loginTitulo = new JLabel("ACCEDER", JLabel.CENTER);
		loginTitulo.setFont(new Font("Consolas", Font.BOLD, 20));
		loginTitulo.setForeground(Color.white);
		loginTitulo.setSize(450,30);
		loginTitulo.setLocation(0,30); 
		loginTitulo.setOpaque(true);
		loginTitulo.setBackground(Color.blue);
		login.add(loginTitulo);

		JLabel nuevaCuenta = new JLabel ("¿No tienes cuenta? Registrate");
		nuevaCuenta.setFont(new Font("Consolas", Font.BOLD, 12));
		nuevaCuenta.setForeground(Color.black);
		nuevaCuenta.setBounds(130,80,190,30);
		login.add(nuevaCuenta);
		
		JLabel etiquetaNombre = new JLabel ("Nombre de usuario");
		etiquetaNombre.setFont(new Font("Consolas", Font.BOLD, 18));
		etiquetaNombre.setForeground(Color.black);
		etiquetaNombre.setBounds(80,140,200,30); 
		login.add(etiquetaNombre);
		
		JTextField nombreUsuario = new JTextField();
		nombreUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		nombreUsuario.setForeground(Color.black);
		nombreUsuario.setBounds(80, 170, 290, 30);
		login.add(nombreUsuario);

		JLabel etiquetaContraseña = new JLabel ("Contraseña");
		etiquetaContraseña.setFont(new Font("Consolas", Font.BOLD, 18));
		etiquetaContraseña.setForeground(Color.black);
		etiquetaContraseña.setBounds(80,250,200,30); 
		login.add(etiquetaContraseña);
		
		JPasswordField contraseñaUsuario = new JPasswordField();
		contraseñaUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		contraseñaUsuario.setForeground(Color.black);
		contraseñaUsuario.setBounds(80, 280, 290, 30);
		login.add(contraseñaUsuario);
		
		JCheckBox loginRecordar = new JCheckBox("Recordarme");
		loginRecordar.setFont(new Font("Consolas", Font.PLAIN, 12));
		loginRecordar.setForeground(Color.black);
		loginRecordar.setBounds(80,315,100,20);
		loginRecordar.setOpaque(false);
		login.add(loginRecordar);
		
		JLabel contraseñaOlvidada = new JLabel ("¿Olvidó su contraseña?");
		contraseñaOlvidada.setFont(new Font("Consolas", Font.PLAIN, 11));
		contraseñaOlvidada.setForeground(new Color(3, 48, 122));
		contraseñaOlvidada.setBounds(230,310,400,30); 
		login.add(contraseñaOlvidada);
		
		JButton loginAcceder = new JButton ("Acceder");
		loginAcceder.setBackground(new Color (15,55,121));
        loginAcceder.setFont(new Font("Consolas", Font.BOLD, 18));
        loginAcceder.setForeground(Color.WHITE);
        loginAcceder.setBounds(150, 420, 150, 50);
        login.add(loginAcceder);
        
        this.add(login);
		
	}

}
