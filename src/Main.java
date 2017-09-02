import Models.Alocacao;
import Models.Usuario.Aluno;
import Models.Usuario.Graduando;
import Models.Usuario.Professor;
import Models.Usuario.Usuario;
import Patterns.AbstractFactory.RecursoFactory;
import Models.Recurso.Recurso;
import Patterns.FactoryMethod.FactoryUsuario;
import Persistence.BancoSingleton;


public class Main {

    public static void main(String[] args) {
        Recurso r = RecursoFactory.getInstance().criaAuditorio();
        r.setNome("Teste");
        Recurso r2 = RecursoFactory.getInstance().criaLaboratorio();

        BancoSingleton.cadastraRecurso(r);
        Recurso teste = BancoSingleton.buscaRecurso(r.getId());
        System.out.println(teste.getNome());


    }
}
