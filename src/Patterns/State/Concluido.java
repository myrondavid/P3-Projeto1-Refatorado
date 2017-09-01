package Patterns.State;

import Models.Recurso.Recurso;
import Models.Usuario.Usuario;

/**
 * Created by myron on 01/09/2017.
 */
public class Concluido implements IAlocacaoState {
    private Recurso recurso;
    @Override
    public void alocarRecurso(Usuario usuario) {

    }
}
