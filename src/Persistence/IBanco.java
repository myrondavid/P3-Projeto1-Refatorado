package Persistence;

/**
 * Created by myron on 01/09/2017.
 */
public interface IBanco {
    void cadastra(Object objeto);
    void modifica(Object objeto);
    void remove(Object objeto);
    void getFromBanco(Object objeto);
}
