package Models.Usuario;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myron on 01/09/2017.
 */
public abstract class Usuario {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    private String nome;
    private String email;
    private String senha;


    boolean logar(String email, String senha){
        return true;
    }

    boolean deslogar(){
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
