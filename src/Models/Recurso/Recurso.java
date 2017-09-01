package Models.Recurso;

import Patterns.State.IAlocacaoState;

/**
 * Created by myron on 01/09/2017.
 */
public abstract class Recurso {
    protected int Id;
    protected String nome;
    private IAlocacaoState status;



    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public IAlocacaoState getStatus() {
        return status;
    }

    public void setStatus(IAlocacaoState status) {
        this.status = status;
    }
}