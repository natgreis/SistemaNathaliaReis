/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.NgrVendas;
import bean.NgrVendaProduto;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author macbook
 */
public class VendaProdutoDAO extends AbstractDAO{

    @Override
    public void insert(Object object) {
        session.beginTransaction();
        session.save(object);
        session.getTransaction().commit();        
    }

    @Override
    public void update(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();
        session.update(object);
        session.getTransaction().commit();        
    }

    @Override
    public void delete(Object object) {
        session.beginTransaction();
        session.flush();
        session.clear();        
        session.delete(object);
        session.getTransaction().commit();        
    }
    
    public void deleteProdutos(NgrVendas vendas) {
        List lista = (List) listProdutos(vendas);
        session.beginTransaction();
        for (int i = 0; i < lista.size(); i++) {
            NgrVendaProduto pedidosProdutos = (NgrVendaProduto) lista.get(i);
            session.flush();
            session.clear();
            session.delete(pedidosProdutos);
        }
        session.getTransaction().commit();
    }
    
     public Object listProdutos(NgrVendas vendas) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendaProduto.class);
        criteria.add(Restrictions.eq("ngrVendas", vendas));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
     }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendaProduto.class);
        criteria.add(Restrictions.eq("ngrIdVendaProduto", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendaProduto.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        VendaProdutoDAO vendaProdutoDAO = new VendaProdutoDAO();
        vendaProdutoDAO.listAll();
    }
}
