/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import bean.NgrVendas;
import java.util.List;
import javax.swing.table.AbstractTableModel;
/**
 *
 * @author u07884727129
 */
public class ControllerVendas extends AbstractTableModel {
    
     private List lstVendas;

    public void setList(List lstVendas) {
        this.lstVendas = lstVendas;
    }
    
    public NgrVendas getBean(int rowIndex) {
        return (NgrVendas) lstVendas.get(rowIndex);
    }

     @Override
    public int getRowCount() {
        return lstVendas.size();
                
    }

     @Override
    public int getColumnCount() {
        return 4;
    }

     @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrVendas pedidos = (NgrVendas) lstVendas.get( rowIndex);
        if ( columnIndex == 0 ){
            return pedidos.getNgrIdVenda();
        } else if (columnIndex ==1) {
            return pedidos.getNgrDataVenda();        
        } else if (columnIndex ==2) {
            return pedidos.getNgrValorTotal();
        } else if (columnIndex ==3) {
            return pedidos.getNgrCliente().getNgrNome();
        }
        return ""; 
    }

     @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Data";         
        } else if ( columnIndex == 2) {
            return "Total";
        } else if ( columnIndex == 3) {
            return "Cliente";
        } 
        return "";
    }
}
