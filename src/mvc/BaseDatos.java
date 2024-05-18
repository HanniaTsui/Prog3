package mvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.code.advancedsql.*;
import com.code.advancedsql.query.Select;
public class BaseDatos {
    private static BaseDatos Istance=new BaseDatos();

    static List<Usuario> user = new ArrayList<>();

    public static BaseDatos obtenerIstancia() {
        return Istance;
    }
    
    
    public void cargarBase() {
		try {
            MySQL mySQL = new MySQL("sql.freedb.tech", 3306, "freedb_free_user_dataBase", "NC@sgA4zYdF4qjj", "freedb_data_base_2024");

            if (mySQL.isConnected()) {
                System.out.println("Conectado!");

            Select nombreTabla=mySQL.table("Usuarios").select();
            List<Map<String, Object>> resultTableUser = nombreTabla.fetchAllAsList();
            for (Map<String, Object> map : resultTableUser) {
                String nombre=((String)map.get("nombre"));
                String contraseña=((String)map.get("contraseña"));
                user.add(new Usuario(nombre,contraseña));
            }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public Usuario user(String username, String password) {
        for (Usuario usuario : user) {
            if (usuario.getNombre().equals(username) && usuario.getPassword().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}