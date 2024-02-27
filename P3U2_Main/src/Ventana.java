import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class Ventana extends JFrame{

	public Ventana() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("Mi ventana");
		this.setSize(900,760);
		this.setLocationRelativeTo(null);
		this.setMaximumSize(new Dimension (600,600));
		this.setMinimumSize(new Dimension (250,250));
		//this.setResizable(false);
		this.setLayout(null); //Quitar el molde
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true); 
	}
	
	public void iniciarComponentes()
	{
	//	this.calculadora();
	//	this.admin();
	//	this.login();
		
		this.newlogin();
	//	this.registro();

	//	this.repaint(); // repintar componentes.
		
	}
	
	public void calculadora()
	{
		this.setTitle("Calculadora"); // Calculadora
		this.setSize(420,680); 		  // Calculadora
		this.setLocation(120,120);
		JPanel calPanel = new JPanel();
		calPanel.setSize(this.getWidth(), this.getHeight());
		calPanel.setLocation(0,0);
		calPanel.setBackground(Color.black);
		calPanel.setLayout(null);
		
		JLabel digitos = new JLabel("123.2 ", JLabel.RIGHT);
		digitos.setSize(410,100);
		digitos.setFont(new Font("Consolas", Font.BOLD, 40));
		digitos.setForeground(Color.BLACK);
		digitos.setLocation(4,10); 
		calPanel.add(digitos);
		
		JLabel pantalla = new JLabel(" ", JLabel.CENTER);
		pantalla.setSize(410,100);
		pantalla.setLocation(4,10); 
		pantalla.setOpaque(true);
		pantalla.setBackground(new Color(168, 186, 186));
		calPanel.add(pantalla);

		JButton botonAC = new JButton("AC");
		confBotonesCal(botonAC);
		botonAC.setBounds(4, 120, 100, 100);
        calPanel.add(botonAC);
        
        JButton botonA = new JButton("DEL");
		confBotonesCal(botonA);
		botonA.setBounds(108, 120, 100, 100);
        calPanel.add(botonA);
        
        JButton botonPorcentaje = new JButton("%");
		confBotonesCal(botonPorcentaje);
		botonPorcentaje.setBounds(212, 120, 100,100);
        calPanel.add(botonPorcentaje);
        
        JButton botonDiv = new JButton("/");
		confBotonesCal(botonDiv);
		botonDiv.setBounds(316, 120, 100,100);
        calPanel.add(botonDiv);
        
        JButton boton7 = new JButton("7");
		confBotonesNum(boton7);
		boton7.setBounds(4, 224, 100, 100);
        calPanel.add(boton7);
        
        JButton boton8 = new JButton("8");
        confBotonesNum(boton8);
		boton8.setBounds(108, 224, 100, 100);
        calPanel.add(boton8);
        
        JButton boton9 = new JButton("9");
        confBotonesNum(boton9);
		boton9.setBounds(212, 224, 100,100);
        calPanel.add(boton9);
        
        JButton botonMult = new JButton("x");
		confBotonesCal(botonMult);
		botonMult.setBounds(316, 224, 100,100);
        calPanel.add(botonMult);
        
        JButton boton4 = new JButton("4");
        confBotonesNum(boton4);
		boton4.setBounds(4, 328, 100, 100);
        calPanel.add(boton4);
        
        JButton boton5 = new JButton("5");
        confBotonesNum(boton5);
		boton5.setBounds(108, 328, 100, 100);
        calPanel.add(boton5);
        
        JButton boton6 = new JButton("6");
        confBotonesNum(boton6);
		boton6.setBounds(212, 328, 100,100);
        calPanel.add(boton6);
        
        JButton botonResta = new JButton("-");
		confBotonesCal(botonResta);
		botonResta.setBounds(316, 328, 100,100);
        calPanel.add(botonResta);
        
        JButton boton1 = new JButton("1");
        confBotonesNum(boton1);
		boton1.setBounds(4, 432, 100, 100);
        calPanel.add(boton1);
        
        JButton boton2 = new JButton("2");
        confBotonesNum(boton2);
		boton2.setBounds(108, 432, 100, 100);
        calPanel.add(boton2);
        
        JButton boton3 = new JButton("3");
        confBotonesNum(boton3);
		boton3.setBounds(212, 432, 100,100);
        calPanel.add(boton3);
        
        JButton botonSuma = new JButton("+");
		confBotonesCal(botonSuma);
		botonSuma.setBounds(316, 432, 100,100);
        calPanel.add(botonSuma);
        
        JButton botonE = new JButton("e");
        confBotonesNum(botonE);
		botonE.setBounds(4, 536, 100, 100);
        calPanel.add(botonE);
        
        JButton boton0 = new JButton("0");
        confBotonesNum(boton0);
		boton0.setBounds(108, 536, 100, 100);
        calPanel.add(boton0);
        
        JButton botonPunto = new JButton(".");
        confBotonesNum(botonPunto);
		botonPunto.setBounds(212, 536, 100,100);
        calPanel.add(botonPunto);
        
        JButton botonIgual = new JButton("=");
		confBotonesCal(botonIgual);
		botonIgual.setBackground(new Color(9, 118, 118));
		botonIgual.setBounds(316, 536, 100,100);
        calPanel.add(botonIgual);
        
		this.add(calPanel);
	}
	
	public void confBotonesCal(JButton componente)
	{
		componente.setBackground(new Color (60, 162, 162));
		componente.setFont(new Font("Consolas", Font.BOLD, 25));
		componente.setForeground(Color.WHITE);
		componente.setFocusable(false);
	}
	public void confBotonesNum(JButton componente)
	{
		componente.setBackground(new Color (20, 72, 73));
		componente.setFont(new Font("Consolas", Font.BOLD, 25));
		componente.setForeground(Color.WHITE);
		componente.setFocusable(false);
	}
	
	public void admin()
	{
		//Añadir panel
		JPanel adminPanel = new JPanel();
		adminPanel.setSize(this.getWidth(), this.getHeight());
		adminPanel.setLocation(0,0);
		adminPanel.setBackground(new Color(123, 203, 204));
		adminPanel.setLayout(null);
		
		//Añadir menu
		JMenuBar barra = new JMenuBar();
		barra.setBackground(new Color(105, 132, 133));
		JMenu menuFile = new JMenu("Archivo");
		JMenuItem openItem = new JMenuItem("Abrir archivo");
		JMenuItem crear = new JMenuItem("Crear archivo");
		openItem.setBackground(new Color(114, 157, 158));
		crear.setBackground(new Color(114, 157, 158));
		
		JLabel adminUsuario = new JLabel("USUARIOS", JLabel.CENTER);
		adminUsuario.setFont(new Font("Consolas", Font.BOLD, 30));
		adminUsuario.setForeground(Color.white);
		adminUsuario.setSize(450,40);
		adminUsuario.setLocation(225,30); 
		adminUsuario.setOpaque(true);
		adminUsuario.setBackground(new Color(5, 98, 99));
		adminPanel.add(adminUsuario);
		
		JLabel tituloWidget = new JLabel("Total de usuarios",0);
		tituloWidget.setBounds(40,80,300,100);
		tituloWidget.setFont(new Font("Consolas", Font.BOLD, 18));
		tituloWidget.setForeground(Color.black);
		adminPanel.add(tituloWidget);
		
		JLabel usuarios = new JLabel("100",0);
		usuarios.setBounds(40,130,300,100);
		usuarios.setFont(new Font("Rockwell", Font.BOLD, 40));
		usuarios.setOpaque(true);
		usuarios.setForeground(Color.black);
		usuarios.setBackground(new Color(40, 139, 140));
		adminPanel.add(usuarios);
		
		JLabel widget = new JLabel("");
		widget.setBounds(40,100,300,100);
		widget.setOpaque(true);
		widget.setBackground(new Color(40, 139, 140));
		adminPanel.add(widget);
		
	/*	JLabel tabla = new JLabel("");
		tabla.setBounds(40,300,820,300);
		tabla.setFont(new Font("Showcard Gothic", Font.BOLD, 40));
		tabla.setOpaque(true);
		tabla.setForeground(Color.black);
		tabla.setBackground(new Color(40, 139, 140));
		adminPanel.add(tabla);*/
		
		JButton download = new JButton("Exportar");
		download.setBackground(new Color (20, 72, 73));
		download.setFont(new Font("Consolas", Font.BOLD, 15));
		download.setForeground(Color.WHITE);
		download.setFocusable(false);
		download.setBounds(620, 250, 100, 30);
        adminPanel.add(download);
        
        JButton añadir = new JButton("Añadir");
        añadir.setBackground(new Color (20, 72, 73));
        añadir.setFont(new Font("Consolas", Font.BOLD, 15));
        añadir.setForeground(Color.WHITE);
        añadir.setFocusable(false); //Quitar cuadro a boton (al presionar no aparece)
        añadir.setBounds(760, 250, 100, 30);
        adminPanel.add(añadir);
        
		String titles[]= {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"};
		
		String data[][]={{"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"},
						 {"No.Control", "Nombre", "Apellido", "Semestre", "Promedio", "Acciones"}};
		JTable datosTabla = new JTable(data, titles);
		JScrollPane tablaScroll = new JScrollPane(datosTabla);
		tablaScroll.setBounds(40,300,820,200);
		adminPanel.add(tablaScroll);
		
		barra.add(menuFile);
		menuFile.add(openItem);
		menuFile.add(crear);
		
		this.setJMenuBar(barra);
		this.add(adminPanel);
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

		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(getClass().getResource("abeja.png")));
		logo.setBounds(100,50,256,256);
		login.add(logo); 
		
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
	
	public void registro()
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
        registroAceptar.setBorderPainted(true); //Agregar borde
        registroAceptar.setBorder(BorderFactory.createLineBorder(new Color(8, 36, 81), 5));
        registro.add(registroAceptar);
        
        this.add(registro);
	}

	
	public void newlogin()
	{
		this.setSize(600,600);
		this.setLocationRelativeTo(null);
		
		JPanel login = new JPanel();
		login.setSize(this.getWidth(), this.getHeight());
		login.setBackground(new Color(67, 82, 233));
		login.setLayout(null);
		
		JLabel loginTitulo = new JLabel("Inicio de Sesión",0);
		loginTitulo.setFont(new Font("Eras Bold ITC", Font.BOLD, 35));
		loginTitulo.setForeground(Color.white);
		loginTitulo.setSize(600,60);
		loginTitulo.setLocation(0,20); 
		login.add(loginTitulo);

		JLabel logoUsuario = new JLabel();
		logoUsuario.setIcon(new ImageIcon(getClass().getResource("usuario.png")));
		logoUsuario.setBounds(130,170,35,35);
		login.add(logoUsuario); 
		
		
		JLabel logoCont = new JLabel();
		logoCont.setIcon(new ImageIcon(getClass().getResource("contraseña.png")));
		logoCont.setBounds(125,280,30,30);
		login.add(logoCont); 
		
		JLabel logoOjo = new JLabel();
		logoOjo.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logoOjo.setBounds(445,280,30,30);
		login.add(logoOjo); 
	
		
		JLabel nuevaCuenta = new JLabel ("Mi cuenta",0);
		nuevaCuenta.setFont(new Font("Eras Bold ITC", Font.ITALIC, 35));
		nuevaCuenta.setForeground(new Color (213, 228, 109));
		nuevaCuenta.setBounds(0,85,600,40);
		login.add(nuevaCuenta);
		
		
		
		JLabel etiquetaNombre = new JLabel ("Nombre de usuario");
		etiquetaNombre.setFont(new Font("Eras Bold ITC", Font.PLAIN, 16));
		etiquetaNombre.setForeground(Color.white);
		etiquetaNombre.setBounds(150,140,200,30); 
		login.add(etiquetaNombre);
		
		JTextField nombreUsuario = new JTextField();
		nombreUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		nombreUsuario.setForeground(Color.black);
		nombreUsuario.setBounds(150, 170, 290, 30);
		login.add(nombreUsuario);

		JLabel etiquetaContraseña = new JLabel ("Contraseña");
		etiquetaContraseña.setFont(new Font("Eras Bold ITC", Font.BOLD, 16));
		etiquetaContraseña.setForeground(Color.white);
		etiquetaContraseña.setBounds(150,250,200,30); 
		login.add(etiquetaContraseña);
		
		JPasswordField contraseñaUsuario = new JPasswordField();
		contraseñaUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		contraseñaUsuario.setForeground(Color.black);
		contraseñaUsuario.setBounds(150, 280, 290, 30);
		login.add(contraseñaUsuario);
		
		JCheckBox loginRecordar = new JCheckBox("Recordarme");
		loginRecordar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
		loginRecordar.setForeground(new Color(108, 114, 228));
		loginRecordar.setBounds(150,315,100,20);
		loginRecordar.setOpaque(false);
		login.add(loginRecordar);
		
		JLabel contraseñaOlvidada = new JLabel ("¿Olvide mi contraseña?");
		contraseñaOlvidada.setFont(new Font("Eras Bold ITC", Font.PLAIN, 11));
		contraseñaOlvidada.setForeground(new Color(142, 147, 241));
		contraseñaOlvidada.setBounds(310,310,400,30); 
		login.add(contraseñaOlvidada);
		
		JButton loginAcceder = new JButton ("Acceder");
		loginAcceder.setBackground(new Color (213, 228, 109));
        loginAcceder.setFont(new Font("Eras Bold ITC", Font.PLAIN, 18));
        loginAcceder.setForeground(Color.black);
        loginAcceder.setBounds(225, 360, 150, 50);
        loginAcceder.setBorderPainted(true); //Agregar borde
        loginAcceder.setBorder(BorderFactory.createLineBorder(new Color(135, 137, 15), 5));
        loginAcceder.setFocusable(false);
        login.add(loginAcceder);
        
        JLabel newCuenta = new JLabel("¿No tiene cuenta?",0);
        newCuenta.setFont(new Font("Eras Bold ITC", Font.PLAIN, 12));
        newCuenta.setForeground(Color.white);
        newCuenta.setBounds(200,450,200,30); 
		login.add(newCuenta);
		
		JButton loginRegistrar = new JButton ("Registrarse");
		loginRegistrar.setBackground(new Color (213, 228, 109));
		loginRegistrar.setFont(new Font("Eras Bold ITC", Font.PLAIN, 18));
		loginRegistrar.setForeground(Color.black);
		loginRegistrar.setBounds(225, 480, 150, 50);
		loginRegistrar.setBorderPainted(true); //Agregar borde
		loginRegistrar.setBorder(BorderFactory.createLineBorder(new Color(135, 137, 15), 5));
		loginRegistrar.setFocusable(false);
        login.add(loginRegistrar);
        
        
        JLabel fondoAzul = new JLabel(" ");
		fondoAzul.setBackground(new Color(45, 52, 189));
		fondoAzul.setSize(400,350);
		fondoAzul.setOpaque(true);
		fondoAzul.setLocation(100,80); 
		login.add(fondoAzul);
        
        this.add(login);
		
	}
}
