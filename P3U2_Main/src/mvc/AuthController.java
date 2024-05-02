package mvc;

import javax.swing.JFrame;

public class AuthController {
	private JFrame frame; 
	private AuthView view; 
	
	public AuthController() {
		// TODO Auto-generated constructor stub
		frame= new JFrame();
		frame.setVisible(false);
		frame.setSize(450,650);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		view = new AuthView();
		
	}
	 public void login() {
		 frame.add(view.login());
		 frame.setVisible(true);
		 frame.repaint();
		 frame.revalidate();
	 }

}
