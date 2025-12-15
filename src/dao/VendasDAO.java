/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.NgrFuncionarios;
import bean.NgrClientes;
import bean.NgrVendas;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author macbook
 */
public class VendasDAO extends AbstractDAO{

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

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendas.class);
        criteria.add(Restrictions.eq("ngrIdVenda", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }
    public Object listCliente(NgrClientes ngrClientes) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendas.class);
        criteria.add(Restrictions.eq("ngrClientes", ngrClientes));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listVendedor(NgrFuncionarios ngrFuncionarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendas.class);
        criteria.add(Restrictions.eq("ngrFuncionarios", ngrFuncionarios));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    public Object listClienteVendedor(NgrClientes ngrClientes, NgrFuncionarios ngrFuncionarios) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendas.class);
        criteria.add(Restrictions.eq("ngrClientes", ngrClientes));
        criteria.add(Restrictions.eq("ngrFuncionarios", ngrFuncionarios));
        List lista = criteria.list();
        session.getTransaction().commit();
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrVendas.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.listAll();
    }
}
