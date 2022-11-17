package Controler;

import Factory.AbstractFactory;
import Model.Entidade;
import Model.Item;
import Model.Loja;
import Persistence.ItemPersistencia;

import java.io.IOException;

public class ItemController extends Controller {

    public ItemController() throws IOException {
        super();
        factory = AbstractFactory.ObterFactory("Item");
        persistenciaI = ItemPersistencia.getSingletonLP();
    }

    @Override
    public void Incluir(Entidade item) throws IOException {
        persistenciaI.Incluir(item);
    }
    @Override
    public void Excluir(Entidade item) throws IOException {
        persistenciaI.Excluir(item.getID());
    }

    @Override
    public void Alterar(Entidade item, String tipoAlterar,String novoDado) throws IOException {
        persistenciaI.Alterar(item.getID(),tipoAlterar,novoDado);
    }

    @Override
    public Item BuscarID(int id) throws IOException {
        return (Item) persistenciaI.stringParse(persistenciaI.BuscarPorID(id));
    }

    @Override
    public Item BuscarTipo(String tipo) throws IOException {
        return (Item) persistenciaI.stringParse(persistenciaI.BuscarTipo(tipo));
    }

}
