package mvc;

public class AuthModel {

	public AuthModel() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean login (String username, String password) {
		if (username.equals("admin") && password.equals("123")) {
			return true; 
		}
		return false; 
	}

}
