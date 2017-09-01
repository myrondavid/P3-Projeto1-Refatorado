package Persistence;


import Models.Recurso.Recurso;

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
        else return false;
    }

    @Override
    public boolean modifica(Object objeto) {
        return false;
    }

    @Override
    public boolean remove(Object objeto) {
        return false;
    }

    @Override
    public Object getFromBanco(int id) {
        return null;
    }
}
