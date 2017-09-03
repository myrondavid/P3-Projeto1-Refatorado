package Menus;

import Models.Usuario.Usuario;

/**
 * Created by myron on 02/09/2017.
 */
public class AlocacaoMenu extends Menu{

    int opcMenu;
    public void exibeMenuPrincipal(Usuario usuario){
        do {
            System.out.println("## HISTORICO DE ALOCAÇÕES ##");
            System.out.println("* USUARIO LOGADO: " + usuario.getNome() + " *");
            System.out.println("1: CONSULTAR | 2: VER TODOS");
            System.out.println("0: SAIR");
            opcMenu = read.nextInt();
        } while(opcMenu != 0);
    }
}
