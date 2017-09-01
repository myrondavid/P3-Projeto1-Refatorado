package Models.Usuario;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myron on 01/09/2017.
 */
public abstract class Usuario {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected int id;
    protected String nome;
    protected String email;
    protected String senha;


    boolean logar(String email, String senha){
        return true;
    }

    boolean deslogar(){
        return true;
    }
}
