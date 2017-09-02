package Menus;

/**
 * Created by myron on 02/09/2017.
 */
public class LoginMenu extends Menu{

    public void menuLogin(){
        System.out.println("## MENU LOGIN ##");
        System.out.println("1: LOGAR | 2: CRIAR CONTA");
        opc = read.nextInt();
    }
}
