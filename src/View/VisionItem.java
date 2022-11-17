package View;

import Controler.Controller;
import Controler.ItemController;
import Factory.AbstractFactory;
import Model.Item;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VisionItem extends Vision{

    ItemController control = (ItemController) AbstractFactory.ObterFactory("Item").CriarController();
    private static int idCount;

    public VisionItem() throws IOException {
    }
    public void menu() throws IOException{
        int option = 0;
        while(option != 4){
            System.out.println("1 - ADICIONAR ITEM");
            System.out.println("2 - REMOVER ITEM");
            System.out.println("3 - ALTERAR ITEM");
            System.out.println("4 - VOLTAR");
            System.out.print("Digite sua opção: ");
            option = scanf.nextInt();

            switch (option){
                case 1:
                    idCount = idReturn();
                    idAdd();
                    System.out.print("Digite o Nome do Item: ");
                    String name = scanf.next();
                    System.out.print("Digite a categoria do Item: ");
                    String type = scanf.next();
                    System.out.print("Digite o preço do Item: ");
                    String price = scanf.next();
                    Item item = new Item(idCount,name,type,price);
                    control.Incluir(item);
                    break;
                case 2:
                    System.out.print("Digite o ID do item a ser excluido: ");
                    int id = scanf.nextInt();
                    control.Excluir(control.BuscarID(id));
                    break;
                case 3:
                    System.out.print("Digite o ID do Item: ");
                    int id1 = scanf.nextInt();
                    System.out.print("Digite o tipo de dado a ser alterado(Name/Type/Price): ");
                    String dado = scanf.next();
                    System.out.print("Digite a nova informação para alterar: ");
                    String novodado = scanf.next();
                    control.Alterar(control.BuscarID(id1),dado,novodado);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        }
    }

    public static int idReturn() throws IOException {
        Reader reader = new Reader("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/ID Counter.txt");
        ArrayList<String> idcountt = reader.getFile();
        return Integer.parseInt(idcountt.get(1));
    }

    public static void idAdd() throws IOException {
        Reader reader = new Reader("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/ID Counter.txt");
        ArrayList<String> idcountt = reader.getFile();
        int novo = Integer.parseInt(idcountt.get(1)) + 1;
        idcountt.add(1,Integer.toString(novo));
        idcountt.remove(2);
        Writer writer = new Writer("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/ID Counter.txt");
        writer.WriteAll(idcountt);
    }
}
