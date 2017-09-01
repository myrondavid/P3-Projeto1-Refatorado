package Patterns.AbstractFactory;

import Models.Recurso.Auditorio;
import Models.Recurso.Laboratorio;
import Models.Recurso.Projetor;
import Models.Recurso.Sala;

/**
 * Created by myron on 01/09/2017.
 */
public class RecursoFactory implements IRecursoFactory {
    @Override
    public Auditorio criaAuditorio() {
        return new Auditorio();
    }

    @Override
    public Laboratorio criaLaboratorio() {
        return new Laboratorio();
    }

    @Override
    public Projetor criaProjetor() {
        return new Projetor();
    }

    @Override
    public Sala criaSala() {
        return new Sala();
    }
}
