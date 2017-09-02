package Patterns.FactoryMethod;

import Models.Atividade.Apresentacao;
import Models.Atividade.Atividade;
import Models.Atividade.Aula;
import Models.Atividade.Lab;
import com.sun.org.apache.bcel.internal.generic.RETURN;

/**
 * Created by myron on 01/09/2017.
 */
public class FactoryAtividade {
    private static FactoryAtividade instance;

    private FactoryAtividade(){

    }

    public static FactoryAtividade getInstance(){
        if(instance == null)
            instance = new FactoryAtividade();
        return instance;
    }

    public Atividade criaAtividade(String tipo){
        if(tipo.equals("APRESENTACAO"))
            return new Apresentacao();
        if(tipo.equals("LAB"))
            return new Lab();
        else return new Aula();
    }
}
