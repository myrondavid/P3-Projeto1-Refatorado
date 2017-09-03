package Persistence;

import Models.Alocacao;
import Models.Atividade.Atividade;
import Models.Recurso.Recurso;
import Models.Usuario.Usuario;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by myron on 01/09/2017.
 */
public final class Banco {
    private static BancoUsuario usuarioBD = new BancoUsuario();
    private static BancoRecurso recursoBD = new BancoRecurso();
    private static BancoAtividade atividadeBD = new BancoAtividade();
    private static BancoAlocacao alocacaoBD = new BancoAlocacao();

    private static Banco instance;

    protected Banco(){

    }

    public static Banco getInstance(){
        if(instance == null)
            instance = new Banco();
        return instance;
    }

    //Usuario
    public static boolean cadastraUsuario(Usuario u){
        return usuarioBD.cadastra(u);
    }

    public static boolean modificaUsuario(Usuario u){
        return usuarioBD.modifica(u);
    }

    public static boolean removeUsuario(Usuario u){
        return usuarioBD.remove(u);
    }

    public static Usuario buscaUsuario(int id){
        return (Usuario) usuarioBD.getFromBanco(id);
    }

    public Usuario getUsuarioByEmail(String email){
        for (Usuario u: usuarioBD.usuarios) {
            if(u.getEmail().equals(email))
                return  u;
        }
        return null;
    }

    public ArrayList<Usuario> getAllUsuarios(){
        return usuarioBD.usuarios;
    }

    //Recurso
    public static boolean cadastraRecurso(Recurso r){
        return recursoBD.cadastra(r);
    }

    public static boolean modificaRecurso(Recurso r){
        return recursoBD.modifica(r);
    }

    public static boolean removeRecurso(Recurso r){
        return recursoBD.remove(r);
    }

    public static Recurso buscaRecurso(int id){
        return (Recurso) recursoBD.getFromBanco(id);
    }
    public ArrayList<Recurso> getAllRecursos(){
        return recursoBD.recursos;
    }

    //Atividade
    public static boolean cadastraAtividade(Atividade a){
        return atividadeBD.cadastra(a);
    }

    public static boolean modificaAtividade(Atividade a){
        return atividadeBD.modifica(a);
    }

    public static boolean removeAtividade(Atividade a){
        return atividadeBD.remove(a);
    }

    public static Atividade buscaAtividade(int id){
        return (Atividade) atividadeBD.getFromBanco(id);
    }
    public ArrayList<Atividade> getAllAtividades(){
        return atividadeBD.atividades;
    }

    //Alocacao
    public static boolean cadastraAlocacao(Alocacao a){
        return alocacaoBD.cadastra(a);
    }

    public static boolean modificaAlocacao(Alocacao a){
        return alocacaoBD.modifica(a);
    }

    public static boolean removeAlocacao(Alocacao a){
        return alocacaoBD.remove(a);
    }

    public static Alocacao buscaAlocacao(int id){
        return (Alocacao) alocacaoBD.getFromBanco(id);
    }
    public static ArrayList<Alocacao> getAllAlocacoes(){
        return alocacaoBD.alocacoes;
    }



}
