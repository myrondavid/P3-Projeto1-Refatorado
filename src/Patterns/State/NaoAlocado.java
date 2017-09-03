package Patterns.State;

import Models.Recurso.Recurso;

/**
 * Created by myron on 02/09/2017.
 */
public class NaoAlocado implements IAlocacaoState {
    @Override
    public void alocarRecurso(Recurso recurso) {
        recurso.setStatus(new NaoAlocado());
    }
}
