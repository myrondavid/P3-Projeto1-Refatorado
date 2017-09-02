package Patterns.FactoryMethod;
import Models.Usuario.*;
import Persistence.BancoSingleton;

/**
 * Created by myron on 01/09/2017.
 */
public class FactoryUsuario {
    private static FactoryUsuario instance;

    private FactoryUsuario(){

    }

    public static FactoryUsuario getInstance(){
        if(instance == null)
            instance = new FactoryUsuario();
        return instance;
    }

    public static Usuario criaUsuario(String tipo){
        if(tipo.equals("PROFESSOR"))
            return new Professor();
        if(tipo.equals("PESQUISADOR"))
            return new Pesquisador();
        if(tipo.equals("DOUTORANDO"))
            return new Doutorando();
        if(tipo.equals("GRADUANDO"))
            return new Graduando();
        if(tipo.equals("MESTRANDO"))
            return new Mestrando();
        else
            return new Admin();
    }
}
