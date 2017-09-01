package Patterns.AbstractFactory;

import Models.Recurso.Auditorio;
import Models.Recurso.Laboratorio;
import Models.Recurso.Projetor;
import Models.Recurso.Sala;

/**
 * Created by myron on 01/09/2017.
 */
public interface IRecursoFactory {
    Auditorio criaAuditorio();
    Laboratorio criaLaboratorio();
    Projetor criaProjetor();
    Sala criaSala();

}
