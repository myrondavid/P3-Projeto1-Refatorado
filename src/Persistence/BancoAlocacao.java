package Persistence;

import Models.Alocacao;

import java.util.ArrayList;

/**
 * Created by myron on 01/09/2017.
 */
public class BancoAlocacao implements IBanco {
    ArrayList<Alocacao> alocacoes = new ArrayList<Alocacao>();

    @Override
    public boolean cadastra(Object objeto) {
        if(objeto != null){
            alocacoes.add((Alocacao) objeto);
            return true;
        }
        return false;
    }

    @Override
    public boolean modifica(Object objeto) {
        Alocacao a = (Alocacao) objeto;
        if(a != null){
            alocacoes.set(a.getId(), a);
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object objeto) {
        if(objeto != null){
            alocacoes.remove((Alocacao) objeto);
            return true;
        }
        return false;
    }

    @Override
    public Object getFromBanco(int id) {
        return alocacoes.get(id);
    }
}
