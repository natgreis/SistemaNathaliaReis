package view;

import bean.NgrVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultaVendas extends AbstractTableModel {

     private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendas.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         NgrVendas v = (NgrVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return v.getNgrIdVenda();
        }else if (columnIndex ==1) {
            return v.getNgrClientes();   
        }else if (columnIndex ==2) {
            return v.getNgrFuncionarios();        
        } 
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
       if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Cliente";         
        } else if ( columnIndex == 2) {
            return "Funcionario";
        } 
        return "";
    }
}