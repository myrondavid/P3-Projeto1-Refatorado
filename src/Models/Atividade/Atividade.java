package Models.Atividade;

import Models.Usuario.Usuario;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by myron on 01/09/2017.
 */
public abstract class Atividade {
    private static final AtomicInteger count = new AtomicInteger(0);
    protected int Id;
    protected Usuario responsavel;
    protected ArrayList<Usuario> participantes;

}
