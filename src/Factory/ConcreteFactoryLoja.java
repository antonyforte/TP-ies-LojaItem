package Factory;

import Controler.LojaController;
import Model.Loja;
import Persistence.LojaPersistencia;
import View.VisionLoja;

import java.io.IOException;
import java.util.List;

public class ConcreteFactoryLoja extends AbstractFactory{
    public Loja CriarEntidade(){
        return new Loja(0,"null","null","null");
    }

    public LojaPersistencia CriarPersistencia() throws IOException {
        return new LojaPersistencia();
    }

    public LojaController CriarController() throws IOException {
        return new LojaController();
    }

    public VisionLoja CriarVision() throws IOException {
        return new VisionLoja();
    }
}