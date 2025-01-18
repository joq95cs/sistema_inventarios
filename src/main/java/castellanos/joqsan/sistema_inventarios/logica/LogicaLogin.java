
package castellanos.joqsan.sistema_inventarios.logica;

import castellanos.joqsan.sistema_inventarios.orm.Usuario;
import castellanos.joqsan.sistema_inventarios.vista.Utilidades;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.hibernate.query.Query;

public class LogicaLogin {

    public static LogicaLogin login = null;
    
    public LogicaLogin(String username, String password) throws Errores.IniciarEntidadException {
        
        //Esta logica usa la entidad Usuario
        Utilidades.iniciarEntidad(Usuario.class);
        
        this.username = username;
        this.password = password;
    }
    
    //Si el usuario existe y la clave es correcta el metodo regresa true
    public boolean usuarioValido() throws Errores.UsuarioValidoException {
        
        try {
            
            //Se usa una query para verificar que el username y password existan en la tabla de usuarios
            //Se usa SHA-256 para cifrar el password ingresado
            //La tabla de usuarios solamente guarda el sha y revisa si el usuario y la clave existen
            //Si el usuario es valido entonces se guarda el registro en un array de consulta
            //Dado que la tabla tiene indices de unique, el array solamente tendra un registro
            String hql = "FROM Usuario u1 WHERE u1.username = :user AND u1.password = :pass";   
            Query query = Usuario.session.createQuery(hql);
            query.setParameter("user", username);
            query.setParameter("pass", getSHA_256());
            ArrayList<Usuario> consulta = new ArrayList<>(query.list());

            //Simplemente se verifica si el array no es vacio
            //Si el array es vacio, el username o password son incorrectos y regresa false
            //Si todo sale bien, el metodo regresa true
            return !consulta.isEmpty();
            
        } catch(Exception ex) {
            
            //Si algo sucede mal se lanza una excepcion personalizada
            throw new Errores.UsuarioValidoException("Error de usuario válido", ex);
        }
    }
    
    //Este metodo privado se encarga de cifrar el password con la funcion hash de sha-256
    private String getSHA_256() throws NoSuchAlgorithmException {
           
        //Se toma la constante de clase y se cifra
        byte[] bytes = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
        StringBuilder sha256 = new StringBuilder();
        
        for(byte b : bytes) {
            
            sha256.append(String.format("%02x", b));
        }
        
        //Se regresa una cadena alfanumerica cifrada
        return sha256.toString();
    }
    
    //Se usan campos string como constantes para guardar el user y password
    private final String username;
    private final String password;
    
    //Esta clase esta asociada solamente al login
    //La entidad de Usuario tiene mas de una logica asociada
    //Las entidades normalmente tienen asociada una unica logica
}