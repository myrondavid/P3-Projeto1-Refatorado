package Menus;

import Models.Usuario.Usuario;
import Patterns.FactoryMethod.FactoryUsuario;
import Persistence.Banco;
import java.util.ArrayList;

/**
 * Created by myron on 02/09/2017.
 */
public class UsuarioMenu extends Menu {
    int opcMenu;

    public void exibeMenuPrincipal(Usuario usuario){
        do {
            System.out.println("## GERENCIAMENTO DE USUARIOS ##");
            System.out.println("* USUARIO LOGADO: " + usuario.getNome() + " *");
            System.out.println("1: CADASTRAR NOVO | 2: MODIFICAR | 3: EXCLUIR | 4: CONSULTAR | 5: VER TODOS");
            System.out.println("0: SAIR");
            opcMenu = read.nextInt();
            if(opcMenu == 1) cadastraUsuario();
            if(opcMenu == 2) modificaUsuario();
            if(opcMenu == 3) excluirUsuario();
            if(opcMenu == 4) consultarUsuario();
            if(opcMenu == 5) verTodos();
        } while(opcMenu != 0);
    }

    public void cadastraUsuario() {
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

    public void modificaUsuario() {
        Usuario u;
        System.out.println("DIGITE O ID do USUARIO QUE VAI MODIFICAR: ");
        int id = read.nextInt();
        try{
            u = Banco.buscaUsuario(id);
            System.out.println("USUARIO: " + u.getNome());
            read.nextLine(); //buffer
            System.out.println("NOME: ");
            String nome = read.nextLine();
            System.out.println("EMAIL: ");
            String email = read.next();
            System.out.println("SENHA: ");
            String senha = read.next();
            u.setNome(nome);
            u.setEmail(email);
            u.setSenha(senha);
            if(Banco.modificaUsuario(u))
                System.out.println("Usuario modificado com sucesso!");
            else System.out.println("Algo deu errado!");
        }catch (Exception e){
            System.out.println("Algo deu errado");
        }
    }

    public void excluirUsuario(){
        Usuario u;
        System.out.println("# EXCLUIR Usuario #");
        System.out.println("ID do usuario a ser excluido: ");
        int id = read.nextInt();
        try{
            u = Banco.buscaUsuario(id);
            Banco.removeUsuario(u);
            System.out.println("SUCESSO!");
        } catch (Exception e){
            System.out.println("usuario não existe ou outro erro aí");
        }
    }

    public void consultarUsuario(){
        Usuario u;
        System.out.println("# CONSULTAR USUARIO #");
        System.out.println("ID do usuario a ser consultado: ");
        int id = read.nextInt();
        try{
            u = Banco.buscaUsuario(id);
            System.out.println("Usuario: " + u.getNome());
            System.out.println("EMAIL: " + u.getEmail());
        } catch (Exception e){
            System.out.println("recurso não existe ou outro erro aí");
        }
    }

    public void verTodos(){
        ArrayList<Usuario> usuarios = Banco.getInstance().getAllUsuarios();
        for(Usuario u : usuarios){
            System.out.println("ID: " + u.getId() + " Usuario: " + u.getNome() + " Email: " + u.getEmail());
        }
    }



}
