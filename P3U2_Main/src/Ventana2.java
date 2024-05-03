// Unidad 3 - Eventos
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Dimension;
import javax.swing.JTextField;

public class Ventana2 extends JFrame implements MouseListener, KeyListener {
	
	JPanel panel = new JPanel();
	public Ventana2() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("Mi ventana");
		this.setSize(900,740); //Login y Registro
		this.setLocationRelativeTo(null);
		this.setMaximumSize(new Dimension (800,800));
		this.setMinimumSize(new Dimension (250,250));
		//this.setResizable(false);
		this.setLayout(null); //Quitar el molde
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true); 
        addMouseListener(this);
        addKeyListener(this);
	}
	
	public void iniciarComponentes()
	{
		this.login();
	//	this.registro();
	//	this.botones();
	//	this.botonesV2();
	}

	public void login() //Login con Eventos  - 13/03/24
	{
		JPanel login = new JPanel();
		login.setSize(this.getWidth()/2, this.getHeight());
	//	login.setSize(450,700);
		login.setLocation(0,0);
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

		/*JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon(getClass().getResource("abeja.png")));
		logo.setBounds(100,50,256,256);
		login.add(logo); */
		
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
        
        loginAcceder.addActionListener(new ActionListener()
		{
        	public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("hola");
				
				String usr = nombreUsuario.getText();
				String pwd = new String (contraseñaUsuario.getPassword());
				
				
				if (usr.length()<=0)
				{
					nombreUsuario.setBorder(BorderFactory.createLineBorder(Color.red,5));
				} else {
					nombreUsuario.setBorder(BorderFactory.createLineBorder(Color.green,5));
				}
				if(pwd.length()<=0) {
					contraseñaUsuario.setBorder(BorderFactory.createLineBorder(Color.red,5));
				} else
				{
					contraseñaUsuario.setBorder(BorderFactory.createLineBorder(Color.green,5));
				}
			//	System.out.println();
				
				if (usr.equals("SuperUser"))
				{
					//System.out.println(pwd);
					if(pwd.equals("SuperPass")) {
						System.out.println("Bienvenido");
					}
				} else
				{
					
					System.out.println("Usuario no encontrado");
				//	nombreUsuario.setBorderPainted(true); //Agregar borde
					nombreUsuario.setBorder(BorderFactory.createLineBorder(Color.red,5));
					contraseñaUsuario.setBorder(BorderFactory.createLineBorder(Color.red,5));
				}
			}});      
        this.add(login);
		
	}
	
	public void registro() //Registro con eventos - 13/03/24
	{

        //PANEL DERECHO
		JPanel registro = new JPanel(); // Agregar otro panel
	//	this.setSize(450,750);
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
        
        registroAceptar.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String usr = registroUsuario.getText();
				String bio = bio_text.getText();
				if (usr.length()<=0)
				{
					registroUsuario.setBorder(BorderFactory.createLineBorder(Color.red,5));
				} else {
					registroUsuario.setBorder(BorderFactory.createLineBorder(Color.green,5));
				}
				if(bio.length()<=0) {
					bio_text.setBorder(BorderFactory.createLineBorder(Color.red,5));
				} else
				{
					bio_text.setBorder(BorderFactory.createLineBorder(Color.green,5));
				}
				if(!aceptarTerminos.isSelected()) {
					aceptarTerminos.setBorderPainted(true);
					aceptarTerminos.setBorder(BorderFactory.createLineBorder(Color.red,3));
				}
				else {
					aceptarTerminos.setBorderPainted(true);
					aceptarTerminos.setBorder(BorderFactory.createLineBorder(Color.green,3));
				}
			}});
        
        this.add(registro);
	}

	public void botones() // Boton con eventos - 13/03/24
	{
		this.setSize(500,750);
	//	JPanel panel = new JPanel();
		panel.setSize(this.getWidth(), this.getHeight());
		panel.setLocation(0,0);
		panel.setBackground(new Color(123, 203, 204));
		panel.setLayout(null);
		
		JButton superBoton = new JButton("Haz click");
		superBoton.setBackground(new Color (20, 72, 73));
		superBoton.setFont(new Font("Consolas", Font.BOLD, 40));
		superBoton.setForeground(Color.WHITE);
		superBoton.setFocusable(false);
		superBoton.setBounds(50, 530, 400, 70);
		panel.add(superBoton);
        
        superBoton.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				int x=(int)Math.floor(Math.random()*450+1);
				int y=(int)Math.floor(Math.random()*650+1);
				
				int w=(int)Math.floor(Math.random()*120+1);
				int h=(int)Math.floor(Math.random()*120+1);
				
				int r=(int)Math.floor(Math.random()*255+1); //RGB
				int g=(int)Math.floor(Math.random()*255+1);
				int b=(int)Math.floor(Math.random()*255+1);
				
				JButton otroBoton = new JButton(r+","+g+","+b);
				otroBoton.setBounds(x,y,w,h);
				otroBoton.setOpaque(true);
				otroBoton.setBackground(new Color (r,g,b));
				otroBoton.setFocusable(false);
				otroBoton.setBorderPainted(true);
				otroBoton.setBorder(BorderFactory.createLineBorder(new Color(r,g,b),5));
			//	otroBoton.setFont(new Font("Consolas", Font.BOLD, 40));
			//	otroBoton.setForeground(Color.WHITE);
				panel.add(otroBoton);
				
				getContentPane().repaint();
				getContentPane().revalidate();
				
				 otroBoton.addActionListener(new ActionListener()
				 {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						JOptionPane.showMessageDialog(null, r+","+g+","+b,
					             "Colores", JOptionPane.WARNING_MESSAGE);
					}
			 
				 });
			}
        });
		
		add(panel);
	}

	public void botonesV2() // Boton con eventos - Eliminar boton - 14/03/24
	{
		this.setSize(500,750);
	//	JPanel panel = new JPanel();
		panel.setSize(this.getWidth(), this.getHeight());
		panel.setLocation(0,0);
		panel.setBackground(new Color(123, 203, 204));
		panel.setLayout(null);
		
		JButton superBoton = new JButton("Haz click");
		superBoton.setBackground(new Color (20, 72, 73));
		superBoton.setFont(new Font("Consolas", Font.BOLD, 40));
		superBoton.setForeground(Color.WHITE);
		superBoton.setFocusable(false);
		superBoton.setBounds(50, 530, 400, 70);
		panel.add(superBoton);
        
        superBoton.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				// TODO Auto-generated method stub
				int x=(int)Math.floor(Math.random()*450+1);
				int y=(int)Math.floor(Math.random()*650+1);
				
				int w=(int)Math.floor(Math.random()*120+1);
				int h=(int)Math.floor(Math.random()*120+1);
				
				int r=(int)Math.floor(Math.random()*255+1); //RGB
				int g=(int)Math.floor(Math.random()*255+1);
				int b=(int)Math.floor(Math.random()*255+1);
				
				JButton otroBoton = new JButton(r+","+g+","+b);
				otroBoton.setBounds(x,y,w,h);
				otroBoton.setOpaque(true);
				otroBoton.setBackground(new Color (r,g,b));
				otroBoton.setFocusable(false);
				otroBoton.setBorderPainted(true);
				otroBoton.setBorder(BorderFactory.createLineBorder(new Color(r,g,b),5));
				panel.add(otroBoton);
				
				getContentPane().repaint();
				getContentPane().revalidate();
				
				otroBoton.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e) { //Eliminar botones (Aquellos agregado con el boton hacer clic)
						JButton yo = ((JButton) e.getSource());
						panel.remove(yo);
						getContentPane().repaint();
						getContentPane().revalidate();
					}
			 
				});
			}
        });
		
		add(panel);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub 
		int w = (int) Math.floor(Math.random() * 100 + 30);
	    int h = (int) Math.floor(Math.random() * 100 + 10); 

		saySomething(" " + e.getClickCount(),e, w,h);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		int r=(int)Math.floor(Math.random()*255+1); //RGB
		int g=(int)Math.floor(Math.random()*255+1);
		int b=(int)Math.floor(Math.random()*255+1);
		panel.setBackground(new Color(r,g,b)); //Cambiar el color del panel al entrar a la ventana
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	void saySomething(String eventDescription, MouseEvent e, int w, int h) {
		int r=(int)Math.floor(Math.random()*255+1); //RGB
		int g=(int)Math.floor(Math.random()*255+1);
		int b=(int)Math.floor(Math.random()*255+1);
		JButton otroBoton = new JButton( r+","+g+","+b);
		otroBoton.setOpaque(true);
		otroBoton.setBackground(new Color (r,g,b));
		otroBoton.setFocusable(false);
		otroBoton.setBounds(e.getX()-50, e.getY()-50, w, h); 
		panel.add(otroBoton);
	    getContentPane().repaint();
	    getContentPane().revalidate();
	    
	    otroBoton.addActionListener(new ActionListener()
		 {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, r+","+g+","+b,
			             "Colores", JOptionPane.WARNING_MESSAGE);
			}
	 
		 });
	}


	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode()+" "+e.getKeyChar()); //Escribir en codigo y el valor tecleado
		if (e.getKeyCode()==8) {
            panel.removeAll(); // Remover componentes del panel
            getContentPane().repaint();
            getContentPane().revalidate();
        }
		else if (e.getKeyCode() == 84) { // t - Cambiar tamaño
			Component[] elementos = panel.getComponents();
	        for (int i = 0; i < elementos.length; i++)    {
	        	if (elementos[i].getClass().toString().equals("class javax.swing.JButton")) {
	        		JButton boton = (JButton) elementos[i];
	                boton.setSize(boton.getWidth() + 10, boton.getHeight() + 10);
	                
	                getContentPane().repaint();
	                getContentPane().revalidate();
	            }
	        }
	    }
		
	    int movX = 0;
	    int movY = 0;
	    switch (e.getKeyCode()) {
	        case 37: 
	        case 65:	//a - Izquierda
	        	movX = -10;
	            break;
	        case 39:
	        case 68:	// d - derecha
	        	movX = 10;
	            break;
	        case 38:
	        case 87: // w - arriba
	        	movY = -10;
	            break;
	        case 40:
	        case 83:	// s - abajo
	        	movY = 10;
	            break;
	        default:
	            return;
	    }

	   Component[] elementos = panel.getComponents();
        for (int i = 0; i < elementos.length; i++)    {
        	if (elementos[i].getClass().toString().equals("class javax.swing.JButton")) {
        		JButton boton = (JButton) elementos[i];
        		int x2 = boton.getX() + movX;
	            int y2 = boton.getY() + movY;
	            //Para que los botones no salgan del panel
	            if (x2 < 0) {
	            	x2 = 0;
	            } else if (x2 > panel.getWidth() - boton.getWidth()) {
	            	x2 = panel.getWidth() - boton.getWidth();
	            }
	            
	            if (y2 < 0) {
	                y2 = 0;
	            } else if (y2 > panel.getHeight() - boton.getHeight()) {
	                y2 = panel.getHeight() - boton.getHeight();
	            }
	            boton.setLocation(x2, y2);
	            getContentPane().repaint();
                getContentPane().revalidate();
            }
        }
        
	}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
