package Controler;

import Factory.AbstractFactory;
import Model.Entidade;
import Model.Item;
import Model.Loja;
import Persistence.LojaPersistencia;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

public class LojaController extends Controller {

    public LojaController() throws IOException {
        super();
        factory = AbstractFactory.ObterFactory("Loja");
        persistenciaL = LojaPersistencia.getSingletonLP();
    }

    @Override
    public void Incluir(Entidade loja) throws IOException {
        persistenciaL.Incluir(loja);
    }
    @Override
    public void Excluir(Entidade loja) throws IOException {
        persistenciaL.Excluir(loja.getID());
    }

    @Override
    public void Alterar(Entidade loja, String tipoAlterar,String novoDado) throws IOException {
        persistenciaL.Alterar(loja.getID(),tipoAlterar,novoDado);
    }

    @Override
    public Loja BuscarID(int id) throws IOException {
        return (Loja) persistenciaL.stringParse(persistenciaL.BuscarPorID(id));
    }
    @Override
    public Loja BuscarTipo(String tipo) throws IOException {
        return (Loja) persistenciaL.stringParse(persistenciaL.BuscarTipo(tipo));
    }

    @Override
    public void addItem(int id, Item i) throws IOException {
        ArrayList<String> newdata = persistenciaL.BuscarPorID(id);
        System.out.println(newdata);
        persistenciaL.Excluir(id);
        newdata.add(Integer.toString(i.getID()));
        Loja loja = (Loja) persistenciaL.stringParse(newdata);
        persistenciaL.Incluir(loja);

    }
    @Override
    public void removeItem(int id, int idItem) throws IOException {
        ArrayList<String> newdata = persistenciaL.BuscarPorID(id);
        persistenciaL.Excluir(id);
        for(int i = 0 ; i < newdata.size() ; i++){
            if(newdata.get(i).equals(Integer.toString(idItem))){
                newdata.remove(i);
            }
        }
        persistenciaL.Incluir(persistenciaL.stringParse(newdata));
    }

}
