
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.Usuario;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.hibernate.query.Query;

public class LogicaLogin {

    public LogicaLogin(String username, String password) throws Errores.ConexionException {
        
        if(Usuario.session == null) {
            
            Usuario.iniciar();
        }
        
        this.username = username;
        this.password = password;
    }
    
    public boolean usuarioValido() throws NoSuchAlgorithmException {
        
        String hql = "FROM Usuario u1 WHERE u1.username = :user AND u1.password = :pass";   
        Query query = Usuario.session.createQuery(hql);
        query.setParameter("user", username);
        query.setParameter("pass", getSHA_256());
        ArrayList<Usuario> consulta = new ArrayList<>(query.list());
            
        return !consulta.isEmpty();
    }
    
    private String getSHA_256() throws NoSuchAlgorithmException {
        
        byte[] bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
        StringBuilder sha256 = new StringBuilder();
        
        for(byte b : bytes) {
            
            sha256.append(String.format("%02x", b));
        }
        
        return sha256.toString();
    }
    
    private final String username;
    private final String password;
}