/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.NgrFuncionarios;
import java.util.List;

/**
 *
 * @author u07884727129
 */
public class ControllerFuncionarios {
    private List NgrFuncionarios;

    public void setList(List NgrFuncionarios) {
        this.NgrFuncionarios = NgrFuncionarios;
    }
    
    public NgrFuncionarios getBean(int rowIndex) {
        return (NgrFuncionarios) NgrFuncionarios.get(rowIndex);
    }

    public int getRowCount() {
        return NgrFuncionarios.size();
    }

    public int getColumnCount() {
        return 4;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrFuncionarios vendedor = (NgrFuncionarios) NgrFuncionarios.get(rowIndex);
        if (columnIndex == 0) {
            return vendedor.getNgrIdFuncionario();
        } else if (columnIndex == 1) {
            return vendedor.getNgrNome();        
        } else if (columnIndex == 2) {
            return vendedor.getNgrCpf();
        } else if (columnIndex == 3) {
            return vendedor.getNgrTelefone();
        }
        return "";
    }

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