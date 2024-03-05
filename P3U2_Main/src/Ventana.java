import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
import javax.swing.border.Border;
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
	//	this.setLayout(null); //Quitar el molde
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true); 
	}
	
	public void iniciarComponentes()
	{
	//	this.calculadora();
	//	this.admin();
	//	this.login();
	//	this.newlogin();
	//	this.registro();
	//	this.newCalculadora();
	//	this.calInteres();
		this.repaint();
		this.revalidate();
	//	this.repaint(); // repintar componentes.
		
	}
	@Override
	public  void paint(Graphics g)
	{
	//	this.setTitle("Paint"); //
		//this.setSize(600,600); 		  
		//this.setLocationRelativeTo(null);
		
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(Color.DARK_GRAY);
		g2d.drawLine(50, 500, 700, 70); // x1,y1, x2, y2 LINEA
		g2d.fillRect(100, 50, 200, 105); //rectangulo con relleno
		g2d.clearRect(125, 80, 150, 100); // limpiar una parte 
		
	//	g2d.drawArc(100, 300, 100, 100, 50, 180); // dibuja un arco // x,y, w, h, anguloInicial, anguloExtension
		g2d.fillArc(250, 300, 100, 100, 0, 180); // pinta un arco
		
		g2d.drawOval(350, 300, 100, 150); //dibuja un ovalo
		g2d.fillOval(550, 300, 100, 150); // rellena obvalo
		
		int xPoints[] = {200,250,300}; // areglo de coordenadas x
		int yPoints[] = {250,200,300}; // arreglo de coordernas y 
		
		g2d.drawPolygon(xPoints, yPoints, 3); // dibujar poligono
		g2d.setColor(Color.black);
		g2d.fillPolygon(xPoints, yPoints, 3);
		
		g2d.setFont(new Font("Heroes Assemble Condensed Italic", Font.PLAIN, 80));
		g2d.drawString("AVENGERS", 200, 550); // Texto
		
		
		g2d.setStroke(new BasicStroke(10));
		
		g2d.fillRoundRect(500,500,100,80,20,20); // Rectangulo con esquinas redondeadas
		
		
		try {
			BufferedImage image = ImageIO.read(new File("src/abeja.png"));
			g2d.drawImage(image, 500, 80, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
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
	
	public void newCalculadora () // Calculadora con Layouts
	{
		this.setTitle("Calculadora"); // Calculadora
		this.setSize(420,600); 		  // Calculadora
		this.setLocationRelativeTo(null);
		
		JPanel calPanel = new JPanel();
		calPanel.setSize(this.getWidth(), this.getHeight());
		//calPanel.setLocation(0,0);
		calPanel.setBackground(Color.black);
		calPanel.setLayout(new BorderLayout ());
		
		JLabel text = new JLabel ("100.00  ", 4);
		text.setFont(new Font("Eras Bold ITC", Font.BOLD, 50));
		text.setForeground(Color.black);
		text.setOpaque(true);
		text.setBackground(new Color(196, 207, 206));
		calPanel.add(text, BorderLayout.NORTH); 
		
		JPanel centro = new JPanel();
		centro.setBackground(new Color(170, 255, 215));
		centro.setLayout(new GridLayout(4,3,5,5));
		calPanel.add(centro, BorderLayout.CENTER);
		
		String btns[] = {"7", "8","9","4","5","6","1","2","3","0",".", "/"};
		for (int i=0; i<12; i++)
		{
			JButton boton = new JButton(btns[i]);
			boton.setBackground(new Color (20, 165, 146));
			boton.setFont(new Font("Consolas", Font.BOLD, 25));
			boton.setForeground(Color.BLACK);
			boton.setBorderPainted(true); //Agregar borde
			boton.setBorder(BorderFactory.createLineBorder(new Color(20, 99, 88), 5));
			boton.setFocusable(false);
			centro.add(boton);
		}
		
		JPanel east = new JPanel();
		east.setBackground(new Color(170, 255, 215));
		east.setLayout(new GridLayout(4,1,5,5));
		calPanel.add(east, BorderLayout.EAST);
		
		String btns2[] = {"  +  ", "  -  ","  *  ","  =  "};
		for (int i=0; i<4; i++)
		{
			JButton boton = new JButton(btns2[i]);
			boton.setBackground(new Color (90, 144, 136));
			boton.setFont(new Font("Consolas", Font.BOLD, 25));
			boton.setForeground(Color.BLACK);
			boton.setBorderPainted(true); //Agregar borde
			boton.setBorder(BorderFactory.createLineBorder(new Color(20, 99, 88), 5));
			boton.setFocusable(false);
			east.add(boton);
		}
		
		JPanel west = new JPanel();
		west.setBackground(new Color(170, 255, 215));
	//	west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));
		west.setLayout(new GridLayout(4,1,5,5));
		calPanel.add(west, BorderLayout.WEST);
		
		String btns3[] = {" MC ", " M+ "," AC "," DEL "};
		for (int i=0; i<4; i++)
		{
			JButton boton = new JButton(btns3[i]);
			boton.setBackground(new Color (106, 124, 121));
			boton.setFont(new Font("Consolas", Font.BOLD, 25));
			boton.setForeground(Color.BLACK);
			boton.setBorderPainted(true); //Agregar borde
			boton.setBorder(BorderFactory.createLineBorder(new Color(20, 99, 88), 5));
			boton.setFocusable(false);
			west.add(boton);
		}

		this.add(calPanel);
	}
	
	public  void calInteres()
	{
		this.setTitle("Calculadora de Interes"); // Calculadora
		this.setSize(600,600); 		  // Calculadora
		this.setLocationRelativeTo(null);
		
		JPanel calPanel = new JPanel();
		calPanel.setSize(this.getWidth(), this.getHeight());
		calPanel.setBackground(Color.white);
		calPanel.setLayout(new BorderLayout ());
		this.add(calPanel);
		
		
		JLabel text = new JLabel ("Interés", 0);
		text.setFont(new Font("Cambria", Font.ITALIC, 40));
		text.setForeground(Color.red);
		calPanel.add(text, BorderLayout.NORTH); 
		
		JPanel centro = new JPanel();
		centro.setBackground(new Color(130, 254, 149));
		centro.setLayout(new GridLayout(8,2));	
		Border bordeCentro = BorderFactory.createLineBorder(Color.BLACK); 
        centro.setBorder(bordeCentro);
		calPanel.add(centro, BorderLayout.CENTER);
		
		JLabel west = new JLabel("                 ");
		west.setBackground(Color.white);
		west.setOpaque(true);
		calPanel.add(west,BorderLayout.WEST);
		
		JLabel east = new JLabel("                 ");
		east.setBackground(Color.white);
		east.setOpaque(true);
		calPanel.add(east,BorderLayout.EAST);
		
		JLabel south = new JLabel("                 ");
		south.setBackground(Color.white);
		south.setFont(new Font("Cambria", Font.ITALIC, 40));
		south.setOpaque(true);
		calPanel.add(south,BorderLayout.SOUTH);
		
		JLabel cal = new JLabel("     Calculadora de interés",2);
		cal.setFont(new Font("Cambria", Font.ITALIC, 17));
		cal.setForeground(Color.BLACK);
		centro.add(cal);
		
		
		JLabel vacio = new JLabel("",0);
		vacio.setFont(new Font("Cambria", Font.PLAIN, 18));
		vacio.setForeground(Color.BLACK);
		centro.add(vacio);
		
		
		JLabel cap = new JLabel("     Capital: ",0);
		cap.setFont(new Font("Cambria", Font.PLAIN, 18));
		cap.setForeground(Color.BLACK);
		centro.add(cap);
		
		JPanel panel2 = new JPanel(new GridLayout(3,1));
	    panel2.setBackground(new Color(130, 254, 149));
	    centro.add(panel2);
		
		    JLabel vacioA = new JLabel("");
		    vacioA.setBackground(new Color(130, 254, 149));
		    vacioA.setOpaque(true);
		    panel2.add(vacioA);
		    
			JTextField text1 = new JTextField("1500",0);
			text1.setFont(new Font("Cambria", Font.PLAIN, 18));
			text1.setBackground(Color.white);
			text1.setHorizontalAlignment(0); 
			text1.setForeground(Color.BLACK);
			text1.setOpaque(true);
			panel2.add(text1);
			
			JLabel vacioB = new JLabel(" ");
			vacioB.setBackground(new Color(130, 254, 149));
			vacioB.setOpaque(true);
			panel2.add(vacioB);
	
		
		JLabel tiempo = new JLabel("     Tiempo: ",0);
		tiempo.setFont(new Font("Cambria", Font.PLAIN, 18));
		tiempo.setForeground(Color.BLACK);
		centro.add(tiempo);
		
		
		JPanel panel3 = new JPanel(new GridLayout(3,1));
	    panel3.setBackground(new Color(130, 254, 149));
	    centro.add(panel3);
	    
		    JLabel vacioC = new JLabel("");
		    vacioC.setBackground(new Color(130, 254, 149));
		    vacioC.setOpaque(true);
		    panel3.add(vacioC);
	    
			JTextField text2 = new JTextField("2",0);
			text2.setFont(new Font("Cambria", Font.PLAIN, 18));
			text2.setBackground(Color.white);
			text2.setHorizontalAlignment(0); 
			text2.setOpaque(true);
			text2.setForeground(Color.BLACK);
			panel3.add(text2);
			
			JLabel vacioD = new JLabel("");
			vacioD.setBackground(new Color(130, 254, 149));
			vacioD.setOpaque(true);
			panel3.add(vacioD);
		
		
		JLabel tasa = new JLabel("     Tasa de Intéres: ",0);
		tasa.setFont(new Font("Cambria", Font.PLAIN, 18));
		tasa.setForeground(Color.BLACK);
		centro.add(tasa);
		
		JPanel panel4 = new JPanel(new GridLayout(3,1));
	    panel4.setBackground(new Color(130, 254, 149));
	    centro.add(panel4);
		
		    JLabel vacioE = new JLabel("");
		    vacioE.setBackground(new Color(130, 254, 149));
		    vacioE.setOpaque(true);
		    panel4.add(vacioE);
		    
			JTextField text3 = new JTextField("0.1",0);
			text3.setFont(new Font("Cambria", Font.PLAIN, 18));
			text3.setBackground(Color.white);
			text3.setHorizontalAlignment(0); 
			text3.setOpaque(true);
			text3.setForeground(Color.BLACK);
			panel4.add(text3);
		
			JLabel vacioF = new JLabel("");
			vacioF.setBackground(new Color(130, 254, 149));
			vacioF.setOpaque(true);
		    panel4.add(vacioF);
		
		JPanel botoneA = new JPanel();
		botoneA.setBackground(new Color(130, 254, 149));
		botoneA.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		centro.add(botoneA, BorderLayout.SOUTH);
		
		
		JButton calcular = new JButton ("Calcular");
		calcular.setBackground(Color.black);
		calcular.setFont(new Font("Consolas", Font.BOLD, 18));
		calcular.setForeground(Color.white);
		calcular.setBorderPainted(true); //Agregar borde
		calcular.setBorder(BorderFactory.createLineBorder(new Color(99, 103, 100), 3));
		calcular.setFocusable(false);
		botoneA.add(calcular);
		
		
		
		JPanel botoneB = new JPanel();
		botoneB.setBackground(new Color(130, 254, 149));
		botoneB.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		centro.add(botoneB, BorderLayout.SOUTH);
		
		
		JButton cancelar = new JButton ("Cancelar");
		cancelar.setBackground(Color.black);
		cancelar.setFont(new Font("Consolas", Font.BOLD, 18));
		cancelar.setForeground(Color.white);
		cancelar.setBorderPainted(true); //Agregar borde
		cancelar.setBorder(BorderFactory.createLineBorder(new Color(99, 103, 100), 3));
		cancelar.setFocusable(false);
		botoneB.add(cancelar);
		
		
	
		JLabel vacio2 = new JLabel(" ",0);
		vacio2.setFont(new Font("Cambria", Font.PLAIN, 18));
		vacio2.setBackground(Color.white);
		vacio2.setForeground(Color.BLACK);
		vacio2.setOpaque(true);
		centro.add(vacio2);
		
		JLabel vacio3 = new JLabel("",0);
		vacio3.setFont(new Font("Cambria", Font.PLAIN, 18));
		vacio3.setBackground(Color.white);
		vacio3.setOpaque(true);
		vacio3.setForeground(Color.BLACK);
		centro.add(vacio3);
		
		JLabel interes = new JLabel("     Intéres: ",0);
		interes.setFont(new Font("Cambria", Font.PLAIN, 18));
		interes.setForeground(Color.BLACK);
		interes.setBackground(new Color(255, 113, 141));
		interes.setOpaque(true);
		centro.add(interes);
		
		JPanel panel5 = new JPanel(new GridLayout(3,1));
	    panel5.setBackground(new Color(255,113,141));
	    centro.add(panel5);
		
		    JLabel vacioG = new JLabel("");
		    vacioG.setBackground(new Color(255, 113, 141));
		    vacioG.setOpaque(true);
		    panel5.add(vacioG);
		    
			JTextField text4 = new JTextField(" 315.10235",0);
			text4.setFont(new Font("Cambria", Font.PLAIN, 18));
			text4.setBackground(Color.white);
			text4.setForeground(Color.BLACK);
			text4.setHorizontalAlignment(0); 
			text4.setOpaque(true);
			panel5.add(text4);
			
			JLabel vacioH = new JLabel("");
			vacioH.setBackground(new Color(255, 113, 141));
			vacioH.setOpaque(true);
		    panel5.add(vacioH);
			
		
		JLabel monto = new JLabel("     Monto: ",0);
		monto.setFont(new Font("Cambria", Font.PLAIN, 18));
		monto.setBackground(new Color(255, 113, 141));
		monto.setForeground(Color.BLACK);
		monto.setOpaque(true);
		centro.add(monto);
		
		JPanel panel6 = new JPanel(new GridLayout(3,1));
	    panel6.setBackground(new Color(255,113,141));
	    centro.add(panel6);
		
			JLabel vacioI = new JLabel("");
			vacioI.setBackground(new Color(255, 113, 141));
			vacioI.setOpaque(true);
		    panel6.add(vacioI);
		
			JTextField text5 = new JTextField(" 1815.2634",0);
			text5.setFont(new Font("Cambria", Font.PLAIN, 18));
			text5.setBackground(Color.white);
			text5.setOpaque(true);
			text5.setHorizontalAlignment(0); 
			text5.setForeground(Color.BLACK);
			panel6.add(text5);
			
			JLabel vacioJ = new JLabel("");
			vacioJ.setBackground(new Color(255, 113, 141));
			vacioJ.setOpaque(true);
		    panel6.add(vacioJ);
		
	}
	
	
}
