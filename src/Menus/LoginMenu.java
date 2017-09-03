package Menus;

import Models.Alocacao;
import Models.Recurso.Recurso;
import Models.Usuario.Usuario;
import Patterns.FactoryMethod.FactoryUsuario;
import Patterns.State.Alocado;
import Patterns.State.Concluido;
import Patterns.State.EmAndamento;
import Patterns.State.EmProcessoDeAlocacao;
import Persistence.Banco;

import javax.swing.plaf.synth.SynthOptionPaneUI;

/**
 * Created by myron on 02/09/2017.
 */
public class LoginMenu extends Menu{
    int opcMenu;

    RecursoMenu recursoMenu = new RecursoMenu();
    UsuarioMenu usuarioMenu = new UsuarioMenu();
    AtividadeMenu atividadeMenu = new AtividadeMenu();
    AlocacaoMenu alocacaoMenu = new AlocacaoMenu();

    public void exibeMenuPrincipal(Usuario u){
        do {
            System.out.println("## MENU PRINCIPAL ##");
            System.out.println("* USUARIO LOGADO: " + u.getNome() + " *");
            System.out.println("1: GERENCIAR USUARIOS | 2: GERENCIAR RECURSOS | 3: GERENCIAR ATIVIDADES | 4: HISTORICO DE ALOCAÇÕES");
            System.out.println("5: EMITIR RELATÓRIO");
            System.out.println("0: SAIR");
            opcMenu = read.nextInt();
            if(opcMenu == 1) usuarioMenu.exibeMenuPrincipal(u);
            if(opcMenu == 2) recursoMenu.exibeMenuPrincipal(u);
            if(opcMenu == 3) atividadeMenu.exibeMenuPrincipal(u);
            if(opcMenu == 4) alocacaoMenu.exibeMenuPrincipal(u);
            if(opcMenu == 5) emitirRelatorio();

        } while(opcMenu != 0);

    }

    public void menuLogin(){
        do {
            System.out.println("## MENU LOGIN ##");
            System.out.println("1: LOGAR | 2: CRIAR CONTA | 0: SAIR");
            opc = read.nextInt();
            if (opc == 1) {
                login();
            }
            if (opc == 2) {
                menuCriaConta();
            }
        } while (opc != 0);
    }

    public void login(){
        System.out.println("EMAIL: ");
        String email = read.next();
        System.out.println("SENHA: ");
        String senha = read.next();

        Usuario u = Banco.getInstance().getUsuarioByEmail(email);
        if (u != null) {
            if(u.getSenha().equals(senha)){
                exibeMenuPrincipal(u);
            } else System.out.println("Senha Incorreta!");
        } else System.out.println("Usuário incorreto ou inexistente!");
    }

    public void menuCriaConta(){
        read.nextLine(); //esvazia o buffer
        System.out.println("NOME: ");
        String nome = read.nextLine();
        System.out.println("EMAIL: ");
        String email = read.next();
        System.out.println("SENHA: ");
        String senha = read.next();
        System.out.println("TIPO: 1-PROFESSOR | 2-PESQUISADOR | 3-GRADUANDO | 4-MESTRANDO | 5-DOUTORANDO | 6-ADMIN ->");
        int t = read.nextInt();
        String tipo = "ADMIN";
        if(t == 1) tipo = "PROFESSOR";
        else if(t == 2) tipo = "PESQUISADOR";
        else if(t == 3) tipo = "GRADUANDO";
        else if(t == 4) tipo = "MESTRANDO";
        else if(t == 5) tipo = "DOUTORANDO";
        else if(t == 6) tipo = "ADMIN";
        Usuario u = FactoryUsuario.criaUsuario(tipo);
        u.setNome(nome);
        u.setEmail(email);
        u.setSenha(senha);
        if(Banco.getInstance().cadastraUsuario(u))
            System.out.println("Usuario cadastrado com sucesso!");
        else System.out.println("Algo deu errado!");
    }

    public void emitirRelatorio(){
        try{
            int contU = Banco.getInstance().getAllUsuarios().size();
            int qntProcessoAlocacao = 0, qntAlocado = 0, qntAndamento = 0, qntConcluido = 0;
            for(Recurso r : Banco.getInstance().getAllRecursos()){
                if (r.getStatus() instanceof EmProcessoDeAlocacao) qntProcessoAlocacao++;
                if (r.getStatus() instanceof Alocado) qntAlocado++;
                if (r.getStatus() instanceof EmAndamento) qntAndamento++;
                if (r.getStatus() instanceof Concluido) qntConcluido++;
            }
            int contAl = Banco.getAllAlocacoes().size();
            int contA = Banco.getInstance().getAllAtividades().size();
            System.out.println("TOTAL DE USUARIOS CADASTRADOS: " + contU);
            System.out.println("Numero de recursos em PROCESSO DE ALOCAÇÕES: " + qntProcessoAlocacao);
            System.out.println("Numero de recursos ALOCADOS: " + qntAlocado);
            System.out.println("Numero de recursos EM ANDAMENTO: " + qntAndamento);
            System.out.println("Numero de recuros CONCLUÍDOS: " + qntConcluido);
            System.out.println("TOTAL DE ALOCAÇÕES: " + contAl);
            System.out.println("TOTAL DE ATIVIDADES: " + contA);
        } catch (Exception e){
            System.out.println("Algo deu errado...");
        }

    }
}
