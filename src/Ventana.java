import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class Ventana extends JFrame{

	public Ventana() {
		// TODO Auto-generated constructor stub
		
		this.setTitle("Mi ventana");
		this.setSize(900,560);
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
		
		
		JLabel registroNombre = new JLabel ("Nombre de usuario");
		registroNombre.setFont(new Font("Consolas", Font.BOLD, 18));
		registroNombre.setForeground(Color.black);
		registroNombre.setBounds(80,100,200,30); 
		registro.add(registroNombre);
		
		JTextField registroUsuario = new JTextField();
		registroUsuario.setFont(new Font("Consolas", Font.PLAIN, 16));
		registroUsuario.setForeground(Color.black);
		registroUsuario.setBounds(80, 130, 290, 30);
		registro.add(registroUsuario);
		
		JLabel registroEmail = new JLabel ("Correo electrónico");
		registroEmail.setFont(new Font("Consolas", Font.BOLD, 18));
		registroEmail.setForeground(Color.black);
		registroEmail.setBounds(80,170,200,30); 
		registro.add(registroEmail);
		
		JTextField registroCorreo = new JTextField();
		registroCorreo.setFont(new Font("Consolas", Font.PLAIN, 16));
		registroCorreo.setForeground(Color.black);
		registroCorreo.setBounds(80, 200, 290, 30);
		registro.add(registroCorreo);

		JLabel registroContraseña = new JLabel ("Contraseña");
		registroContraseña.setFont(new Font("Consolas", Font.BOLD,18));
		registroContraseña.setForeground(Color.black);
		registroContraseña.setBounds(80,240,200,30); 
		registro.add(registroContraseña);
		
		JPasswordField agregarContraseña = new JPasswordField();
		agregarContraseña.setFont(new Font("Consolas", Font.PLAIN, 16));
		agregarContraseña.setForeground(Color.black);
		agregarContraseña.setBounds(80, 270, 290, 30);
		registro.add(agregarContraseña);
		
		JLabel registroCContraseña = new JLabel ("Confirmar contraseña");
		registroCContraseña.setFont(new Font("Consolas", Font.BOLD, 18));
		registroCContraseña.setForeground(Color.black);
		registroCContraseña.setBounds(80,310,300,30); 
		registro.add(registroCContraseña);
		
		JPasswordField confirmarContraseña = new JPasswordField();
		confirmarContraseña.setFont(new Font("Consolas", Font.PLAIN, 16));
		confirmarContraseña.setForeground(Color.black);
		confirmarContraseña.setBounds(80,340, 290, 30);
		registro.add(confirmarContraseña);
		
		JButton registroAceptar = new JButton ("Aceptar");
		registroAceptar.setBackground(new Color (15,55,121));
		registroAceptar.setFont(new Font("Consolas", Font.BOLD, 18));
        registroAceptar.setForeground(Color.WHITE);
        registroAceptar.setBounds(150, 420, 150, 50);
        registro.add(registroAceptar);
		
		this.add(login);
		this.add(registro);
		

	}

}
