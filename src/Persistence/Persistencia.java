package Persistence;
import Model.Entidade;

import java.io.*;
import java.util.ArrayList;

abstract public class Persistencia {
    protected String Path;
    public Persistencia(String path){
        this.Path = path;
    }

    abstract public void Incluir(Entidade e) throws IOException;

    abstract public void Excluir(int id) throws IOException;

    abstract public ArrayList<String> BuscarTipo(String x) throws IOException;
    abstract public void Alterar(int id, String dadoantigo,String dadonovo) throws IOException;
    abstract public ArrayList<String> BuscarPorID(int id) throws IOException;

    abstract public ArrayList<String> eParse(Entidade e);

    abstract public Entidade stringParse(ArrayList<String> entidade) throws IOException;

}
