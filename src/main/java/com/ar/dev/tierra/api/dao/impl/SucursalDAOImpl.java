/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ar.dev.tierra.api.dao.impl;

import com.ar.dev.tierra.api.dao.SucursalDAO;
import com.ar.dev.tierra.api.model.Sucursal;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author PauloGaldo
 */
@Repository
@Transactional
public class SucursalDAOImpl implements SucursalDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<Sucursal> getAll() {
        Criteria criteria = getSession().createCriteria(Sucursal.class);
        criteria.add(Restrictions.eq("estado", true));
        criteria.addOrder(Order.asc("idSucursal"));
        List<Sucursal> list = criteria.list();
        return list;
    }

}
