package Models.Atividade;

import Models.Usuario.Usuario;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myron on 01/09/2017.
 */
public abstract class Atividade {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
    protected String titulo, descricao, materialApoio;
    protected Usuario responsavel;
    protected ArrayList<Usuario> participantes;
    protected ArrayList<String> infos;


    public Atividade() {
        this.id = count.getAndIncrement();
        this.participantes = new ArrayList<Usuario>();
        this.infos = new ArrayList<String>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(Usuario responsavel) {
        this.responsavel = responsavel;
    }

    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<String> getInfos() {
        return infos;
    }

    public void setInfos(ArrayList<String> infos) {
        this.infos = infos;
    }
}
