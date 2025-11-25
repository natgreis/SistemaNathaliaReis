/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author u1845853
 */
public class Util {
    public static void habilitar(boolean valor, JComponent ... componentes) {
        for (int i = 0; i < componentes.length; i++) {
            componentes[i].setEnabled(valor);
            
        }
    }
    public static void limpar(JComponent ... componentes){
        for (int i = 0; i < componentes.length; i++){
            if (componentes[i] instanceof JTextField){
           ((JTextField) componentes[i]).setText("");      
            }
            else if (componentes[i] instanceof JComboBox){
           ((JComboBox) componentes[i]).setSelectedIndex(-1);      
            }
            else if (componentes[i] instanceof JCheckBox) {
                ((JCheckBox) componentes[i]).setSelected(false); 
            }
        }
    }
    public static void mensagem(String cad){
        JOptionPane.showMessageDialog(null, cad);
    }
    
   public static boolean pergunta(String cad){
        return JOptionPane.showConfirmDialog(null, cad)== JOptionPane.YES_OPTION;
       
    }
    public static int strToInt (String num) {
        return Integer.parseInt(num);
    }
    public static String intToStr(int num) {
        return String.valueOf(num);
    }
    public static double strToDouble (String num){
        return Double.parseDouble(num);
    }
    public static String doubleToStr (double num){
        return String.valueOf(num);
    }
    public static Date strToDate (String data){
       SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);
        try {
            return sdf.parse(data);
        } catch (ParseException e) {
            return null;
        }
    }
    public static String dateToStr(Date data){
        if (data == null) return "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(data);
    }
    public static boolean validarEmail(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }

        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return email.matches(emailRegex);
    }
}
