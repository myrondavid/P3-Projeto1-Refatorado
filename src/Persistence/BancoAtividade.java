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
        return false;
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
