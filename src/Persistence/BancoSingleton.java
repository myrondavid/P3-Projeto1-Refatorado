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
public class BancoSingleton {

    BancoUsuario usuarioBD = new BancoUsuario();
    BancoRecurso recursoBD = new BancoRecurso();
    BancoAtividade atividadeBD = new BancoAtividade();
    BancoAlocacao alocacaoBD = new BancoAlocacao();

    //Usuario
    public void cadastraUsuario(){

    }
    public void modificaUsuario(){

    }
    public void removeUsuario(){

    }
    public void buscaUsuario(){

    }

    //Recurso
    public void cadastraRecurso(){

    }
    public void modificaRecurso(){

    }
    public void removeRecurso(){

    }
    public void buscaRecurso(){

    }

    //Atividade
    public void cadastraAtividade(){

    }
    public void modificaAtividade(){

    }
    public void removeAtividade(){

    }
    public void buscaAtividade(){

    }

    //Alocacao
    public void cadastraAlocacao(){

    }
    public void modificaAlocacao(){

    }
    public void removeAlocacao(){

    }
    public void buscaAlocacao(){

    }



}
