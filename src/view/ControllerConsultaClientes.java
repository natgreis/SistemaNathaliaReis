package view;

import bean.NgrClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultaClientes extends AbstractTableModel {

    private List lstProdutos;

    public void setList(List lstProdutos) {
        this.lstProdutos = lstProdutos;
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         NgrClientes produtos = (NgrClientes) lstProdutos.get( rowIndex);
        if ( columnIndex == 0 ){
            return produtos.getNgrIdCliente();
        } else if (columnIndex ==1) {
            return produtos.getNgrNome();        
        } else if (columnIndex ==2) {
            return produtos.getNgrCpf();
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