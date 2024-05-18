package mvc;

import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public class AuthModel {

	public AuthModel() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean login (String username, String password) {
		
		Usuario user = BaseDatos.obtenerIstancia().user(username,password); //USANDO BASE DE DATOS
		if(user.getNombre().equals(username) && user.getPassword().equals(password)) {
			JOptionPane.showMessageDialog(null, "Bienvenido");
            return true;
		}else {
            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
        }
		
	/*	String usr = username;
		String pwd = password;
		try {
            FileReader reader=new FileReader("datos.json");
            JSONObject jsonObject=new JSONObject(new JSONTokener(reader));

            String usuarioJSON=jsonObject.getString("Usuario"); //user
            String contraseñaJSON=jsonObject.getString("Contraseña"); //123

            if (usr.equals(usuarioJSON) && pwd.equals(contraseñaJSON)) {
                JOptionPane.showMessageDialog(null, "Bienvenido");
                return true; 
            } else {
                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos", "Error", JOptionPane.WARNING_MESSAGE);
            }
            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (JSONException ex) {
            ex.printStackTrace();
        }*/
		/*if (username.equals("admin") && password.equals("123")) {
			return true; 
		}
		return false; */
		
		
		return false; 
	}

	
	
}
