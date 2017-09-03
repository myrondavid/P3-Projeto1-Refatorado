import Menus.*;
import Models.Alocacao;
import Models.Atividade.Atividade;
import Models.Usuario.Aluno;
import Models.Usuario.Graduando;
import Models.Usuario.Professor;
import Models.Usuario.Usuario;
import Patterns.AbstractFactory.RecursoFactory;
import Models.Recurso.Recurso;
import Patterns.FactoryMethod.FactoryUsuario;
import Persistence.Banco;

import java.util.ArrayList;


public class Main {

    public static void main(String[] args) {
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.menuLogin();
    }
}
