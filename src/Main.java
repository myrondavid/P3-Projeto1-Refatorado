import Patterns.AbstractFactory.RecursoFactory;
import Models.Recurso.Recurso;

public class Main {
    static RecursoFactory factory = new RecursoFactory();
    public static void main(String[] args) {
        Recurso sala = factory.criaSala();

    }
}
