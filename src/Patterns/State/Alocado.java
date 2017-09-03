package Patterns.State;

import Models.Alocacao;
import Models.Recurso.Recurso;
import Models.Usuario.Usuario;

/**
 * Created by myron on 01/09/2017.
 */
public class Alocado implements IAlocacaoState {

    @Override
    public void alocarRecurso(Recurso recurso) {

        recurso.setStatus(new Alocado());
    }
}
