package Models.Recurso;

import Models.Usuario.Usuario;
import Patterns.State.*;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myron on 01/09/2017.
 */
public abstract class Recurso {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected int id;
    protected String nome;
    private IAlocacaoState status;

    public Recurso(){
        this.id = count.getAndIncrement();
        this.status = new NaoAlocado();
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        id = id;
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

    public void emAndamento(){
        status = new EmAndamento();
    }
    public void emProcessoDeAlocacao(){
        status = new EmProcessoDeAlocacao();
    }
    public void alocado(){
        status = new Alocado();
    }
    public void concluido(){
        status = new NaoAlocado();
    }
}
