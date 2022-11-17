package Factory;

import Controler.ItemController;
import Model.Item;
import Persistence.ItemPersistencia;
import View.VisionItem;

import java.io.IOException;

public class ConcreteFactoryItem extends AbstractFactory{
    public Item CriarEntidade(){

        return new Item(0,"null","0","null");
    }

    public ItemPersistencia CriarPersistencia() throws IOException {
        return new ItemPersistencia();
    }

    public ItemController CriarController() throws IOException {
        return new ItemController();
    }

    public VisionItem CriarVision() throws IOException {
        return new VisionItem();
    }
}
