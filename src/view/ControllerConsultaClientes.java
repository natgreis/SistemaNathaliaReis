package view;

import bean.NgrClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultaClientes extends AbstractTableModel {

    private List lstClientes;

    public void setList(List lstClientes) {
        this.lstClientes = lstClientes;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         NgrClientes c = (NgrClientes) lstClientes.get( rowIndex);
        if ( columnIndex == 0 ){
            return c.getNgrIdCliente();
        } else if (columnIndex ==1) {
            return c.getNgrNome();        
        } else if (columnIndex ==2) {
            return c.getNgrCpf();
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
       if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Nome";         
        }else if ( columnIndex == 2) {
            return "Cpf";         
        } 
        return "";
    }
}