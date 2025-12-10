package view;

import bean.NgrFuncionarios;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerConsultaFuncionario extends AbstractTableModel {

    private List lstFuncionario;

    public void setList(List lstFuncionario) {
        this.lstFuncionario = lstFuncionario;
        this.fireTableDataChanged();
        
    }
    
    @Override
    public int getRowCount() {
        return lstFuncionario.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         NgrFuncionarios funcionarios = (NgrFuncionarios) lstFuncionario.get( rowIndex);
        if ( columnIndex == 0 ){
            return funcionarios.getNgrIdFuncionario();
        } else if (columnIndex ==1) {
            return funcionarios.getNgrNome();        
        } else if (columnIndex ==2) {
            return funcionarios.getNgrCpf();
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