
package castellanos.joqsan.sistema_inventarios.vista;

import java.awt.Component;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Dialogos {
    
    public static void d1(Component parent, Exception ex) {
        
        JOptionPane.showMessageDialog(parent, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void d2(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Valor numérico requerido", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void d3(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Inserción exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void d4(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Actualización exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void d5(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Valor numérico requerido", "Error", JOptionPane.ERROR_MESSAGE);
    }
    
    public static void d6(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int d7(Component parent) {
        
        return JOptionPane.showConfirmDialog(parent, "¿Cargar un archivo Excel previamente guardado?", "Elija una opción", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static int d8(Component parent, JComboBox combo) {
        
        return JOptionPane.showConfirmDialog(parent, combo, "Seleccione el archivo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void d9(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Carga de archivo Excel exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int d10(Component parent, JComboBox combo) {
        
        return JOptionPane.showConfirmDialog(parent, combo, "Elija una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void d11(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Carga de archivo Excel exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int d12(Component parent) {
        
        return JOptionPane.showConfirmDialog(parent, "¿Guardar el archivo Excel?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void d13(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Archivo Excel guardado exitosamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int d14(Component parent, JPanel panel) {
        
        return JOptionPane.showConfirmDialog(parent, panel, "Ingrese nombre del nuevo archivo", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void d15(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void d16(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Inicio de sesión exitoso", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void d17(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Inserción exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void d18(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Actualización exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static void d19(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int d20(Component parent, String nombre) {
        
        return JOptionPane.showConfirmDialog(parent, "¿Eliminar el archivo " + nombre + "?", "Advertencia", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
    }
    
    public static void d21(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Eliminación exitosa", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public static int d22(Component parent, JComboBox combo) {
        
        return JOptionPane.showConfirmDialog(parent, combo, "Elija una opción", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
    }
    
    public static void d23(Component parent) {
        
        JOptionPane.showMessageDialog(parent, "Archivo Excel guardado con éxito", "Correcto", JOptionPane.INFORMATION_MESSAGE);
    }
}