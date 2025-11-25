/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.NgrUsuarios;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;



/**
 *
 * @author macbook
 */
public class UsuariosDAO extends AbstractDAO{

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
    
    public NgrUsuarios validar(String apelido, String senha) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrUsuarios.class);
        criteria.add(Restrictions.eq("ngrApelido", apelido));
        criteria.add(Restrictions.eq("ngrSenha", senha));
        NgrUsuarios usuario = (NgrUsuarios) criteria.uniqueResult();
        session.getTransaction().commit();
        return usuario;
    }

    @Override
    public Object list(int codigo) {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrUsuarios.class);
        criteria.add(Restrictions.eq("ngrIdUsuarios", codigo));
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;
    }

    @Override
    public Object listAll() {
        session.beginTransaction();
        Criteria criteria = session.createCriteria(NgrUsuarios.class);
        List lista = criteria.list();
        session.getTransaction().commit();        
        return lista;    
    }

    public static void main(String[] args) {
        UsuariosDAO usuariosDAO = new UsuariosDAO();
        usuariosDAO.listAll();
    }
}
