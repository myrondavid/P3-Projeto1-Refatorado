package Persistence;

/**
 * Created by myron on 01/09/2017.
 */
public interface IBanco {
    boolean cadastra(Object objeto);
    boolean modifica(Object objeto);
    boolean remove(Object objeto);
    Object getFromBanco(int id);
}
