package dao;


import jakarta.persistence.EntityManager;
import model.Usuario;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UsuarioDao extends GenericDAO<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }
}