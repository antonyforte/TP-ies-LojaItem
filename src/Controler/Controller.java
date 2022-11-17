package Controler;

import Factory.AbstractFactory;
import Model.Entidade;
import Model.Item;
import Model.Loja;
import Persistence.ItemPersistencia;
import Persistence.LojaPersistencia;
import Persistence.Persistencia;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
     static AbstractFactory factory;
     static LojaPersistencia persistenciaL;
     static ItemPersistencia persistenciaI;

     //PERSISTENCIAS
     public void Incluir(Entidade e) throws IOException {
     }

     public void Excluir(Entidade e) throws IOException {
     }

     public void Alterar(Entidade e, String Antigo, String Novodado) throws IOException {
     }

     public Entidade BuscarID(int id) throws IOException {
          return null;
     }

     public Entidade BuscarTipo(String tipo) throws IOException {
          return null;
     }


     public void addItem(int id, Item i) throws IOException{

     }

    public void removeItem(int id, int idItem) throws IOException {

    }

}
