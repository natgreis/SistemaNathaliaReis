package view;

import bean.NgrFuncionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerFuncionarios extends AbstractTableModel {

    private List NgrFuncionarios;

    public void setList(List NgrFuncionarios) {
        this.NgrFuncionarios = NgrFuncionarios;
    }
    
    public NgrFuncionarios getBean(int rowIndex) {
        return (NgrFuncionarios) NgrFuncionarios.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return NgrFuncionarios.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrFuncionarios funcionarios = (NgrFuncionarios) NgrFuncionarios.get(rowIndex);
        if (columnIndex == 0) {
            return funcionarios.getNgrIdFuncionario();
        } else if (columnIndex == 1) {
            return funcionarios.getNgrNome();        
        } else if (columnIndex == 2) {
            return funcionarios.getNgrCpf();
        } else if (columnIndex == 3) {
            return funcionarios.getNgrTelefone();
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