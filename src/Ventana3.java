//Unidad 4 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.*;

public class Ventana3 extends JFrame{
	private JPanel contentPane;
	private JTextField nombres;
	private JPasswordField password;
	private JLabel labelUsuario,logo2,logo4, logo5, titulo, labelPassword, labelPregunta;

	public Ventana3() {
		// TODO Auto-generated constructor stub
		this.setTitle("Mi ventana");
		this.setSize(400,400); 
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setLayout(null); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.iniciarComponentes();
        this.setVisible(true); 
	}
	
	public void iniciarComponentes()
	{
	//	botonJSON();
		escribirJSON();
		leerJSON();
		login();
	}
	
	public void login()
	{
		setSize(450,650);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
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
		logo5.setBounds(153,112,128,128);
		panelLogin.add(logo5);
		
		labelUsuario = new JLabel("Usuario");
		labelUsuario.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelUsuario.setBounds(85, 237, 80, 45);
		panelLogin.add(labelUsuario);	
		
		nombres = new JTextField();
		nombres.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		nombres.setBounds(85, 275, 265, 30);
        nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelLogin.add(nombres);	
		
		labelPassword = new JLabel("Contraseña");
		labelPassword.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		labelPassword.setBounds(85, 304, 100, 45);
		panelLogin.add(labelPassword);	
		
		password = new JPasswordField();
		password.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 15));
		password.setBounds(85, 341, 225, 30);
		password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
		panelLogin.add(password);
		
		logo2 = new JLabel();
		logo2.setIcon(new ImageIcon(getClass().getResource("ojo.png")));
		logo2.setBounds(318,346,24,24);
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
					nombres.setBorder(BorderFactory.createLineBorder(Color.red,3));
				} else {
					 nombres.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
				}
				if(pwd.length()<=0) {
					password.setBorder(BorderFactory.createLineBorder(Color.red,3));
				} else
				{
					 password.setBorder(BorderFactory.createCompoundBorder(new LineBorder(Color.BLACK), BorderFactory.createEmptyBorder(0, 5, 0, 0)));
				}
				
				try {
		            FileReader reader=new FileReader("datos.json");
		            JSONObject jsonObject=new JSONObject(new JSONTokener(reader));

		            String usuarioJSON=jsonObject.getString("Usuario");
		            String contraseñaJSON=jsonObject.getString("Contraseña");

		            if (usr.equals(usuarioJSON) && pwd.equals(contraseñaJSON)) {
		                JOptionPane.showMessageDialog(null, "Bienvenido");
		            } else {
		                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
		            }

		            reader.close();
		        } catch (IOException ex) {
		            ex.printStackTrace();
		        } catch (JSONException ex) {
		            ex.printStackTrace();
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
			}
		});
		botonRegistro.setBounds(227, 72, 95, 21);
		panelLogin.add(botonRegistro);
		
		JButton botonOlvidaste = new JButton("<html><u>¿Olvidaste tu contraseña?</u></html>");
		botonOlvidaste.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				contentPane.removeAll();
		        contentPane.revalidate();
		        contentPane.repaint();
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
		
			
	}
	
	
	public void botonJSON()
	{
		JPanel panel = new JPanel();
		panel.setSize(this.getWidth(), this.getHeight());
		panel.setLocation(0,0);
		panel.setBackground(new Color(142, 188, 186));
		panel.setLayout(null);
		add(panel);
		
		JButton btn = new JButton("Escribir JSON");
		btn.setFocusable(false);
		btn.setBackground(new Color(21, 122, 117));
		btn.setBounds((this.getWidth() -150)/2, (200-25)/2, 150, 25);
		btn.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				escribirJSON();
			}
			
		});
		panel.add(btn);
		
		JButton btn2 = new JButton("Leer JSON");
		btn2.setFocusable(false);
		btn2.setBackground(new Color(21, 122, 117));
		btn2.setBounds((this.getWidth() -150)/2, (400+25)/2, 150, 25);
		btn2.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				leerJSON();
			}
			
		});
		panel.add(btn2);
		
		
	}
	
	public static void escribirJSON()
	{
		JSONObject obj1 = new JSONObject();
		obj1.put("Nombre", "Emma");
		obj1.put("Edad", "18");
		obj1.put("Genero", "Mujer");
		obj1.put("Pais", "Mexico");
		obj1.put("Usuario", "user");
		obj1.put("Contraseña","123");
		
		System.out.println(obj1);
		String jsonString = obj1.toString();

	    try (FileWriter file = new FileWriter("datos.json")) {
	        file.write(jsonString);
	        file.flush();
	        System.out.println("JSON guardado correctamente en 'datos.json'");
	        System.out.println();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
	private static void leerJSON() {

		 try 
		 {
			 FileReader reader = new FileReader("datos.json");
			 JSONObject jsonObject = new JSONObject(new JSONTokener(reader));

			 String nombre = jsonObject.getString("Nombre");
             int edad = jsonObject.getInt("Edad");
             String genero = jsonObject.getString("Genero");
             String pais = jsonObject.getString("Pais");
             String usuario = jsonObject.getString("Usuario");
             String contrasena = jsonObject.getString("Contraseña");

             System.out.println("Nombre: " + nombre);
             System.out.println("Edad: " + edad);
             System.out.println("Genero: " + genero);
             System.out.println("Pais: " + pais);
             System.out.println("Usuario: " + usuario);
             System.out.println("Contraseña: " + contrasena);
             System.out.println();

	         reader.close();
		 } catch (IOException e)  {
	            e.printStackTrace();
	     } catch (JSONException e) {
	            e.printStackTrace();
	     }
    }
	
	public static void main(String[] args) {
		Ventana3 ven3 = new Ventana3();
	}

}
