

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package view;

import bean.NgrUsuarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;


/**
 *
 * @author u07884727129
 */
public class ControllerUsuarios extends AbstractTableModel {

    private List NgrUsuarios;

    public void setList(List NgrUsuarios) {
        this.NgrUsuarios = NgrUsuarios;
           fireTableDataChanged();
    }
    
    public NgrUsuarios getBean(int rowIndex) {
        return (NgrUsuarios) NgrUsuarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return NgrUsuarios.size();
                
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrUsuarios usuarios = (NgrUsuarios) NgrUsuarios.get( rowIndex);
        if ( columnIndex == 0 ){
            return usuarios.getNgrIdUsuarios();
        } else if (columnIndex ==1) {
            return usuarios.getNgrNome();        
        } else if (columnIndex ==2) {
            return usuarios.getNgrApelido();
        } else if (columnIndex ==3) {
            return usuarios.getNgrCpf();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        } else if ( columnIndex == 2) {
            return "Apelido";
        } else if ( columnIndex == 3) {
            return "Cpf";
        } 
        return "";
    }
}
