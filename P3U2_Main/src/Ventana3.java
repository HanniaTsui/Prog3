//Unidad 4 
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.json.*;

public class Ventana3 extends JFrame{

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
		botonJSON();
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

             System.out.println("Nombre: " + nombre);
             System.out.println("Edad: " + edad);
             System.out.println("Genero: " + genero);
             System.out.println("Pais: " + pais);
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
