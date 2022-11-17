package Persistence;

import Model.Entidade;
import Model.Item;
import Model.Loja;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

import java.io.IOException;
import java.util.ArrayList;

public class LojaPersistencia extends Persistencia {
    private static LojaPersistencia LojaPersistenciaSingleton;

    public LojaPersistencia() {
        super("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/Banco de Dados Loja.txt");

    }

    public static LojaPersistencia getSingletonLP() throws IOException{
        if(LojaPersistenciaSingleton == null){
            LojaPersistenciaSingleton = new LojaPersistencia();
        }
        return LojaPersistenciaSingleton;
    }

    @Override
    public void Incluir(Entidade e) throws IOException {
        Writer fileWriter = new Writer(this.Path);
        ArrayList<String> loja = eParse(e);
        fileWriter.Write(loja);
    }

    @Override
    public void Excluir(int id) throws IOException {
        Reader fileReader = new Reader(this.Path);
        ArrayList<String> data = fileReader.getFile();
        //PROCURA PELO ID A LOJA A SER EXCLUIDA E TIRA ELA DA LISTA
        for(int i = 0 ; i < data.size() ; i++){
            if(data.get(i).equals(Integer.toString(id))){
                while(!data.get(i).equals("-")){
                    data.remove(i);
                }
                data.remove(i);
            }
        }
        Writer newfileWriter = new Writer(this.Path);
        newfileWriter.WriteAll(data);

    }
    //POR PAÍS
    @Override
    public ArrayList<String> BuscarTipo(String x) throws IOException {
        Reader fileReader = new Reader(this.Path);
        ArrayList<String> data = fileReader.getFile();

        ArrayList<String> searchedArray = new ArrayList<>();
        for(int i = 0 ; i < data.size() ; i++){
            if(data.get(i).equals(x)){
                searchedArray.add(data.get(i-3));
                searchedArray.add(data.get(i-2));
                searchedArray.add(data.get(i-1));
                searchedArray.add(data.get(i));

                i = i+1;
                int j = i;
                while(!data.get(i).equals("-")){
                    searchedArray.add(data.get(j));
                    j++;
                }
            }
        }
        return searchedArray;
    }

    @Override
    public void Alterar(int id, String dadoantigo, String dadonovo) throws IOException {

        ArrayList<String> newdata = BuscarPorID(id);
        switch (dadoantigo){
            case "Name" -> {
                newdata.add(1,dadonovo);
                newdata.remove(2);
                Excluir(id);
                Writer filewriter = new Writer(this.Path);
                filewriter.Write(newdata);
            }
            case "Country" -> {
                newdata.add(2,dadonovo);
                newdata.remove(3);
                Excluir(id);
                Writer filewriter = new Writer(this.Path);
                filewriter.Write(newdata);
            }
            case "Address" -> {
                newdata.add(3,dadonovo);
                newdata.remove(4);
                Excluir(id);
                Writer filewriter = new Writer(this.Path);
                filewriter.Write(newdata);
            }
            default -> System.out.println("ERROR");
        }

    }

    @Override
    public ArrayList<String> BuscarPorID(int id) throws IOException {
        Reader fileReader = new Reader(this.Path);
        ArrayList<String> data = fileReader.getFile();

        ArrayList<String> searchedArray = new ArrayList<>();
        for(int i = 0 ; i < data.size() ; i++){
            if(data.get(i).equals(Integer.toString(id))){
                searchedArray.add(data.get(i));
                searchedArray.add(data.get(i+1));
                searchedArray.add(data.get(i+2));
                searchedArray.add(data.get(i+3));
                i = i+3;
                int j = i+1;
                while(!(data.get(j).equals("-"))){
                    searchedArray.add(data.get(j));
                    j++;
                }
            }
        }
        return searchedArray;
    }
    @Override
    public ArrayList<String> eParse(Entidade e){
        Loja loja = (Loja) e;
        ArrayList<String> returnArray = new ArrayList<>();

        returnArray.add(Integer.toString(loja.getID()));
        returnArray.add(loja.getName());
        returnArray.add(loja.getAddress());
        returnArray.add(loja.getCountry());

        for(int i = 0 ; i < loja.getItens().size() ; i++){
            String id = Integer.toString(loja.getItens().get(i).getID());
            returnArray.add(id);
        }

        return returnArray;
   }

    @Override
    public Entidade stringParse(ArrayList<String> entidade) throws IOException {
        ItemPersistencia item = ItemPersistencia.getSingletonLP();
        int id = Integer.parseInt(entidade.get(0));
        String name = entidade.get(1);
        String address = entidade.get(2);
        String country = entidade.get(3);
        ArrayList<Item> items = new ArrayList<>();
        for(int i = 4 ; i < entidade.size(); i++){
            if(isInteger(entidade.get(i))){
                ArrayList<String> string = item.BuscarPorID(Integer.parseInt(entidade.get(i)));
                Item A = new Item(Integer.parseInt(string.get(0)),string.get(1),string.get(2),string.get(3));
                items.add(A);

            }
        }
        Loja loja = new Loja(id,name,address,country);
        loja.setItens(items);
        return loja;
    }

    public boolean isInteger(String s){
        return s != null && s.matches("[0-9]*");
    }
}