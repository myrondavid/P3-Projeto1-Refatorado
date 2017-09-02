package Persistence;


import Models.Recurso.Recurso;
import Models.Usuario.Usuario;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

/**
 * Created by myron on 01/09/2017.
 */
public class BancoRecurso implements IBanco{
    ArrayList<Recurso> recursos = new ArrayList<Recurso>();


    @Override
    public boolean cadastra(Object objeto) {
        if(objeto != null){
            recursos.add((Recurso)objeto);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifica(Object objeto) {
        Recurso r = (Recurso) objeto;
        if(r != null){
            recursos.set(r.getId(), r);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object objeto) {
        if(objeto != null){
            recursos.remove((Recurso) objeto);
            return true;
        }
        return false;
    }

    @Override
    public Object getFromBanco(int id) {
        return recursos.get(id);
    }
}
