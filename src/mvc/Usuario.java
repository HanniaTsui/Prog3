package mvc;

public class Usuario {

	String nombre;
	String password;
	
	public Usuario(String nombre,String pw) {
        this.nombre=nombre;
        this.password=pw;
    }
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	} 
	

}
