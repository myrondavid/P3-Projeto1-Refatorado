package Persistence;

import Models.Usuario.Usuario;

import java.util.ArrayList;

/**
 * Created by myron on 01/09/2017.
 */
public class BancoUsuario implements IBanco {

    ArrayList<Usuario> usuarios = new ArrayList<Usuario>();
    @Override
    public boolean cadastra(Object objeto) {
        if(objeto != null) {
            usuarios.add((Usuario) objeto);
            return true;
        }
        return false;

    }

    @Override
    public boolean modifica(Object objeto) {
        Usuario u = (Usuario) objeto;
        if(u != null){
            usuarios.set(u.getId(), u);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object objeto) {
        if(objeto != null){
            usuarios.remove(objeto);
            return true;
        }
        else return false;

    }

    @Override
    public Object getFromBanco(int id) {
        return usuarios.get(id);
    }


}
