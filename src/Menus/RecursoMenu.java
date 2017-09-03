package Menus;

import Models.Alocacao;
import Models.Recurso.Recurso;
import Models.Usuario.Admin;
import Models.Usuario.Professor;
import Models.Usuario.Usuario;
import Patterns.AbstractFactory.RecursoFactory;
import Patterns.State.NaoAlocado;
import Persistence.Banco;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.ArrayList;
import java.util.concurrent.RecursiveTask;

/**
 * Created by myron on 02/09/2017.
 */
public class RecursoMenu extends Menu{
    int opcMenu;

    public void exibeMenuPrincipal(Usuario usuario){
        do {
            System.out.println("## GERENCIAMENTO DE RECURSOS ##");
            System.out.println("* USUARIO LOGADO: " + usuario.getNome() + " *");
            System.out.println("1: CADASTRAR NOVO | 2: MODIFICAR | 3: EXCLUIR | 4: CONSULTAR | 5: VER TODOS | 6: ALOCAR");
            System.out.println("0: SAIR");
            opcMenu = read.nextInt();
            if(opcMenu == 1) cadastraRecurso();
            if(opcMenu == 2) modificaRecurso();
            if(opcMenu == 3) excluirRecurso();
            if(opcMenu == 4) consultarRecurso();
            if(opcMenu == 5) verTodos();
            if(opcMenu == 6) alocar(usuario);
        } while(opcMenu != 0);
    }

    public void cadastraRecurso(){
        Recurso r;
        System.out.println("# CADASTRAR RECURSO #");
        read.nextLine(); //limpa buffer
        System.out.println("NOME: ");
        String nome = read.nextLine();
        System.out.println("TIPO: 1-SALA | 2-LABORATORIO | 3-AUDITORIO | 4-PROJETOR");
        int tipo = read.nextInt();
        if(tipo == 1) r = RecursoFactory.getInstance().criaSala();
        else if (tipo == 2) r = RecursoFactory.getInstance().criaLaboratorio();
        else if (tipo == 3) r = RecursoFactory.getInstance().criaAuditorio();
        else if (tipo == 4) r = RecursoFactory.getInstance().criaProjetor();
        else r = RecursoFactory.getInstance().criaSala();
        r.setNome(nome);
        try{
            Banco.cadastraRecurso(r);
            System.out.println("SUCESSO");
        }catch (Exception e){
            System.out.println("Algo deu errado... ");
        }

    }
    
    public void modificaRecurso(){
        Recurso r;
        System.out.println("# MODIFICAR RECURSO #");
        System.out.println("ID do recurso a ser modificado: ");
        int id = read.nextInt();
        try {
            r = Banco.buscaRecurso(id);
            System.out.println("Recurso: " + r.getNome());
            System.out.println("NOVO NOME: ");
            read.nextLine(); //buffer
            String nome = read.nextLine();
            Banco.modificaRecurso(r);
            System.out.println("SUCESSO!");
        }catch (Exception e){
            System.out.println("recurso não existe ou outro erro aí");
        }
    }

    public void excluirRecurso(){
        Recurso r;
        System.out.println("# EXCLUIR RECURSO #");
        System.out.println("ID do recurso a ser excluido: ");
        int id = read.nextInt();
        try{
            r = Banco.buscaRecurso(id);
            Banco.removeRecurso(r);
            System.out.println("SUCESSO!");
        } catch (Exception e){
            System.out.println("recurso não existe ou outro erro aí");
        }
    }

    public void consultarRecurso(){
        Recurso r;
        System.out.println("# CONSULTAR RECURSO #");
        System.out.println("ID do recurso a ser consultado: ");
        int id = read.nextInt();
        try{
            r = Banco.buscaRecurso(id);
            System.out.println("Recurso: " + r.getNome());
            System.out.println("Status: " + r.getStatus().toString());
        } catch (Exception e){
            System.out.println("recurso não existe ou outro erro aí");
        }
    }

    public void verTodos(){
        ArrayList<Recurso> recursos = Banco.getInstance().getAllRecursos();
        for(Recurso r : recursos){
            System.out.println("ID: " + r.getId() + " RECURSO: " + r.getNome() + " STATUS: " + r.getStatus().toString());
        }
    }

    public void alocar(Usuario usuario){
        Recurso r;
        System.out.println("# ALOCAR RECURSO #");
        if(usuario instanceof Admin || usuario instanceof Professor){
            System.out.println("ID do recurso que deseja ALOCAR");
            int id = read.nextInt();
            try{
                r = Banco.buscaRecurso(id);
                r.emProcessoDeAlocacao();
                Alocacao a = new Alocacao();
                a.setAlocador(usuario);
                a.setRecursoAlocado(r);
                Banco.cadastraAlocacao(a);
                r.alocado();
                Banco.modificaRecurso(r);

            }catch (Exception e){
                System.out.println("Recurso não encontrado ou outro erro");
            }

        }
        else System.out.println("USUARIO NÃO TEM PERMISSÃO");

    }
}
