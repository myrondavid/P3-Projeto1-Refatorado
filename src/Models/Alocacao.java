package Models;

import Models.Recurso.Recurso;
import Models.Usuario.Usuario;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myron on 01/09/2017.
 */
public class Alocacao {
    protected static final AtomicInteger count = new AtomicInteger(0);
    protected int id;
    private Usuario alocador;
    private Recurso recursoAlocado;

    public Alocacao() {
        this.id = count.getAndIncrement();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getAlocador() {
        return alocador;
    }

    public void setAlocador(Usuario alocador) {
        this.alocador = alocador;
    }

    public Recurso getRecursoAlocado() {
        return recursoAlocado;
    }

    public void setRecursoAlocado(Recurso recursoAlocado) {
        this.recursoAlocado = recursoAlocado;
    }
}
