package Persistence;

import Models.Atividade.Atividade;

import java.util.ArrayList;

/**
 * Created by myron on 01/09/2017.
 */
public class BancoAtividade implements IBanco {
    ArrayList<Atividade> atividades = new ArrayList<Atividade>();


    @Override
    public boolean cadastra(Object objeto) {
        if(objeto != null){
            atividades.add((Atividade) objeto);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifica(Object objeto) {
        Atividade atv = (Atividade) objeto;
        if(atv != null){
            atividades.set(atv.getId(), atv);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object objeto) {
        if(objeto != null){
            atividades.remove((Atividade) objeto);
            return true;
        }
        return false;
    }

    @Override
    public Object getFromBanco(int id) {
        return atividades.get(id);
    }
}
