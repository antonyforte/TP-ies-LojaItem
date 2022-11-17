package Factory;

import Controler.Controller;
import Model.Entidade;
import Model.Item;
import Model.Loja;
import Persistence.ItemPersistencia;
import Persistence.LojaPersistencia;
import Persistence.Persistencia;
import View.Vision;

import java.io.IOException;

abstract public class AbstractFactory {

    public static AbstractFactory ObterFactory(String entidade) {
        if(entidade.equalsIgnoreCase("Item")){
            return new ConcreteFactoryItem();
        }else{
            return new ConcreteFactoryLoja();
        }
    }

    public abstract Entidade CriarEntidade();
    public abstract Persistencia CriarPersistencia() throws IOException;

    public abstract Controller CriarController() throws IOException;

    public abstract Vision CriarVision() throws IOException;

}
