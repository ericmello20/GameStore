package dao;

import model.Usuario;

public class UsuarioDao extends GenericDAO<Usuario> {

    public UsuarioDao() {
        super(Usuario.class);
    }
}