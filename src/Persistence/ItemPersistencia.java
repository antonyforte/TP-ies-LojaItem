package Persistence;

import Model.Entidade;
import Model.Item;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

import java.io.IOException;
import java.util.ArrayList;

public class ItemPersistencia extends Persistencia {
    private static ItemPersistencia ItemPersistenciaSingleton;

    public ItemPersistencia() {
        super("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/Banco de Dados Itens.txt");

    }

    public static ItemPersistencia getSingletonLP() throws IOException {
        if (ItemPersistenciaSingleton == null) {
            ItemPersistenciaSingleton = new ItemPersistencia();
        }
        return ItemPersistenciaSingleton;
    }
    @Override
    public void Incluir(Entidade e) throws IOException {
        Writer fileWriter = new Writer(this.Path);
        ArrayList<String> item = eParse(e);

        fileWriter.Write(item);
    }

    @Override
    public void Excluir(int id) throws IOException {
        Reader fileReader = new Reader(this.Path);
        ArrayList<String> data = fileReader.getFile();
        //PROCURA PELO ID DO ITEM A SER EXCLUIDO E TIRA ELE DA LISTA
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
    //POR TIPO
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
            case "Type" -> {
                newdata.add(2,dadonovo);
                newdata.remove(3);
                Excluir(id);
                Writer filewriter = new Writer(this.Path);
                filewriter.Write(newdata);
            }
            case "Price" -> {
                newdata.add(3,dadonovo);
                newdata.remove(4);
                Excluir(id);
                Writer filewriter = new Writer(this.Path);
                filewriter.Write(newdata);
            }
            default -> System.out.println("ERROR");
        }

        Excluir(id);
        Incluir(stringParse(newdata));

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
                int j = i;
            }
        }
        return searchedArray;
    }
    @Override
    public ArrayList<String> eParse(Entidade e){
        Item item = (Item) e;
        ArrayList<String> returnArray = new ArrayList<>();

        returnArray.add(Integer.toString(item.getID()));
        returnArray.add(item.getName());
        returnArray.add(item.getType());
        returnArray.add(item.getPrice());
        return returnArray;
    }

    @Override
    public Entidade stringParse(ArrayList<String> entidade) throws IOException{
        int id = Integer.parseInt(entidade.get(0));
        ArrayList<String> litem = BuscarPorID(id);
        String name = litem.get(1);
        String type = litem.get(2);
        String price = litem.get(3);
        Item item = new Item(id,name,type,price);
        return item;
    }


}