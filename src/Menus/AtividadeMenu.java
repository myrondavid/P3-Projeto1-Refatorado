package Menus;

import Models.Atividade.Atividade;
import Models.Usuario.Usuario;
import Patterns.FactoryMethod.FactoryAtividade;
import Patterns.FactoryMethod.FactoryUsuario;
import Persistence.Banco;

import java.util.ArrayList;

/**
 * Created by myron on 02/09/2017.
 */
public class AtividadeMenu extends Menu {
    int opcMenu;

    public void exibeMenuPrincipal(Usuario usuario){
        do {
            System.out.println("## GERENCIAMENTO DE ATIVIDADES ##");
            System.out.println("* USUARIO LOGADO: " + usuario.getNome() + " *");
            System.out.println("1: CADASTRAR NOVO | 2: MODIFICAR | 3: EXCLUIR | 4: CONSULTAR | 5: VER TODOS | 6: ADICIONAR PARTICIPANTES EM ATIVIDADE");
            System.out.println("0: SAIR");
            opcMenu = read.nextInt();
            if(opcMenu == 1) cadastraAtividade(usuario);
            if(opcMenu == 2) modificaAtividade();
            if(opcMenu == 3) excluirAtividade();
            if(opcMenu == 4) consultarAtividade();
            if(opcMenu == 5) verTodos();
            if(opcMenu == 6) addParticipantes();
        } while(opcMenu != 0);
    }

    public void cadastraAtividade(Usuario usuario){
        read.nextLine(); //esvazia o buffer
        System.out.println("TITULO: ");
        String nome = read.nextLine();
        System.out.println("DESCRICÃO: ");
        String descricao = read.nextLine();
        System.out.println("MATERIAL DE APOIO: ");
        String material = read.nextLine();
        System.out.println("TIPO: 1-AULA | 2-APRESENTAÇÃO | 3-LABORATÓRIO ->");
        int t = read.nextInt();
        String tipo = "AULA";
        if(t == 1) tipo = "AULA";
        else if(t == 2) tipo = "APRESENTACAO";
        else if(t == 3) tipo = "LAB";
        Atividade a = FactoryAtividade.getInstance().criaAtividade(tipo);
        a.setTitulo(nome);
        a.setDescricao(descricao);
        a.setMaterialApoio(material);
        a.setResponsavel(usuario);
        if(Banco.getInstance().cadastraAtividade(a))
            System.out.println("Atividade cadastrada com sucesso!");
        else System.out.println("Algo deu errado!");
    }

    public void modificaAtividade(){
        Atividade a;
        System.out.println("DIGITE O ID da ATIVIDADE QUE VAI MODIFICAR: ");
        int id = read.nextInt();
        try{
            a = Banco.buscaAtividade(id);
            System.out.println("Atividade: " + a.getTitulo());
            read.nextLine(); //buffer

            System.out.println("TITULO: ");
            String nome = read.nextLine();
            System.out.println("DESCRICÃO: ");
            String descricao = read.nextLine();
            System.out.println("MATERIAL DE APOIO: ");
            String material = read.nextLine();
            a.setTitulo(nome);
            a.setDescricao(descricao);
            a.setMaterialApoio(material);
            if(Banco.modificaAtividade(a))
                System.out.println("Atividade modificada com sucesso!");
            else System.out.println("Algo deu errado!");
        }catch (Exception e){
            System.out.println("Algo deu errado");
        }
    }

    public void excluirAtividade(){
        Atividade a;
        System.out.println("# EXCLUIR Atividade #");
        System.out.println("ID da atividade a ser excluida: ");
        int id = read.nextInt();
        try{
            a = Banco.buscaAtividade(id);
            Banco.removeAtividade(a);
            System.out.println("SUCESSO!");
        } catch (Exception e){
            System.out.println("Atividade não existe ou outro erro aí");
        }
    }

    public void consultarAtividade(){
        Atividade a;
        System.out.println("# CONSULTAR Atividade #");
        System.out.println("ID da atividade a ser consultada: ");
        int id = read.nextInt();
        try{
            a = Banco.buscaAtividade(id);
            System.out.println("ATIVIDADE: " + a.getTitulo());
            System.out.println("DESCRICAO " + a.getDescricao());
            System.out.println("RESPONSAVEL " + a.getResponsavel().getNome());
        } catch (Exception e){
            System.out.println("Atividade não existe ou outro erro aí");
        }
    }

    public void verTodos(){
        ArrayList<Atividade> atividades = Banco.getInstance().getAllAtividades();
        for(Atividade a : atividades){
            System.out.println("ID: " + a.getId() + " Atividade: " + a.getTitulo() + " Responsavel: " + a.getResponsavel().getNome());
        }
    }

    public void addParticipantes(){
        Atividade a;
        Usuario u;
        System.out.println("DIGITE O ID da ATIVIDADE QUE VAI Adicionar participantes: ");
        int id = read.nextInt();
        int idU;
        try{
            a = Banco.buscaAtividade(id);
            int opca;
            do{
                System.out.println("Digite o ID do usuario pra adicionar: ");
                idU = read.nextInt();
                u = Banco.buscaUsuario(idU);
                a.getParticipantes().add(u);
                System.out.println("CONTINUAR ADICIONANDO? 1:sim | 2:nao ->");
                opca = read.nextInt();
            } while (opca != 0);

            if(Banco.modificaAtividade(a))
                System.out.println("Atividade modificada com sucesso!");
            else System.out.println("Algo deu errado!");
        }catch (Exception e){
            System.out.println("Algo deu errado");
        }
    }
}
