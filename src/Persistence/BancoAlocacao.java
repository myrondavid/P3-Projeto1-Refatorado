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
