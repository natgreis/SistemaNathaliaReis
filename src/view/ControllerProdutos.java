package view;

import bean.NgrProdutos;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ControllerProdutos extends AbstractTableModel {

    private List NgrProdutos;

    public void setList(List NgrProdutos) {
        this.NgrProdutos = NgrProdutos;
    }
    
    public NgrProdutos getBean(int rowIndex) {
        return (NgrProdutos) NgrProdutos.get(rowIndex);
    }

    @Override
    public int getRowCount() {
        return NgrProdutos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        NgrProdutos produtos = (NgrProdutos) NgrProdutos.get(rowIndex);
        if (columnIndex == 0) {
            return produtos.getNgrIdProduto();
        } else if (columnIndex == 1) {
            return produtos.getNgrNome();        
        } else if (columnIndex == 2) {
            return produtos.getNgrCategoria();
        } else if (columnIndex == 3) {
            return produtos.getNgrPreco();
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
            return "Categoria";
        } else if (columnIndex == 3) {
            return "Preço";
        } 
        return "";
    }
}