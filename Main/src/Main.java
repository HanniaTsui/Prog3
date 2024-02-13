import javax.swing.JFrame;

public class Main {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hola");
		
		JFrame ventana = new JFrame("Ejemplo");
		ventana.setVisible(true); // Se muestra ventana
		ventana.setSize(500,300); // Tamaño de la ventana
		ventana.setLocation(100,100); // Ubicacion de la ventana
		
		ventana.setLocationRelativeTo(null); // 	Centrar la ventana
		
		ventana.setResizable(false);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        System.out.println("Holaa");
		
	}

}
