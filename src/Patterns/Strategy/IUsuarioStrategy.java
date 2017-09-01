package Patterns.Strategy;

import Models.Usuario.Usuario;

/**
 * Created by myron on 01/09/2017.
 */
public interface IUsuarioStrategy {
    boolean login(Usuario usuario);
    boolean logout(Usuario usuario);
}
