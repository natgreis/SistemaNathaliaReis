package view;

import bean.NgrClientes;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerClientes extends AbstractTableModel {

    private List NgrClientes;

    public void setList(List NgrClientes) {
        this.NgrClientes = NgrClientes;
    }
    
    public NgrClientes getBean(int rowIndex) {
        return (NgrClientes) NgrClientes.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return NgrClientes.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrClientes clientes = (NgrClientes) NgrClientes.get(rowIndex);
        if (columnIndex == 0) {
            return clientes.getNgrIdCliente();
        } else if (columnIndex == 1) {
            return clientes.getNgrNome();        
        } else if (columnIndex == 2) {
            return clientes.getNgrCpf();
        } else if (columnIndex == 3) {
            return clientes.getNgrTelefone();
        }
        return "";
    }

    @Override
    public String getColumnName(int columnIndex) {
        if (columnIndex == 0) {
            return "Código";
        } else if (columnIndex == 1) {
            return "Nome";         
        } else if (columnIndex == 2) {
            return "CPF";
        } else if (columnIndex == 3) {
            return "Telefone";
        } 
        return "";
    }
}