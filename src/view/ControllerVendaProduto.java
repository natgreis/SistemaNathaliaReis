/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import bean.NgrVendaProduto;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author u07884727129
 */
public class ControllerVendaProduto extends AbstractTableModel{
    private List lstVendaProduto;

    public void setList(List lstVendaProduto) {
        this.lstVendaProduto = lstVendaProduto;
        
        this.fireTableDataChanged();
    }
    
    public NgrVendaProduto getBean(int rowIndex) {
        return (NgrVendaProduto) lstVendaProduto.get(rowIndex);
    }

    public void addBean(NgrVendaProduto vendaProduto) {
        lstVendaProduto.add(vendaProduto);
        this.fireTableDataChanged();
    }
    
    public void removeBean(int rowIndex) {
        lstVendaProduto.remove(rowIndex);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return lstVendaProduto.size();                
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrVendaProduto vendaProduto = (NgrVendaProduto) lstVendaProduto.get( rowIndex);
        if ( columnIndex == 0 ){
            return vendaProduto.getNgrProdutos().getNgrIdProduto();
        } else if (columnIndex ==1) {
            return vendaProduto.getNgrProdutos().getNgrNome();
        } else if (columnIndex ==2) {
            return vendaProduto.getNgrQuantidade();
        } else if (columnIndex ==3) {
            return vendaProduto.getNgrPrecoUnitario();
        }else if (columnIndex ==4) {
            return vendaProduto.getNgrPrecoUnitario()*vendaProduto.getNgrQuantidade();
        }
        return ""; 
    }

    @Override
    public String getColumnName(int columnIndex) {
        if ( columnIndex == 0) {
            return "Código";
        } else if ( columnIndex == 1) {
            return "Produto";         
        } else if ( columnIndex == 2) {
            return "Quantidade";
        } else if ( columnIndex == 3) {
            return "Valor Unitário";
        } else if ( columnIndex == 4) {
            return "Total";
        } 
        return "";
    }

}
