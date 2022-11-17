package View;

import Controler.Controller;
import Controler.LojaController;
import Controler.ItemController;
import Factory.AbstractFactory;
import Model.Item;
import Model.Loja;
import ReaderWriter.Reader;
import ReaderWriter.Writer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class VisionLoja extends Vision{

    LojaController control = (LojaController) AbstractFactory.ObterFactory("Loja").CriarController();
    private static int idCount;


    public VisionLoja() throws IOException {
    }

    public void menu() throws IOException {
        int option = 0;
        while(option != 6){
            System.out.println("1 - ADICIONAR LOJA");
            System.out.println("2 - EXCLUIR LOJA");
            System.out.println("3 - ALTERAR DADOS DA LOJA");
            System.out.println("4 - ADICIONAR ITENS A LOJA");
            System.out.println("5 - REMOVER ITENS DA LOJA");
            System.out.println("6 - VOLTAR");
            System.out.print("Digite sua Opcao: ");
            option = scanf.nextInt();
            switch (option){
                case 1:
                    idCount = idReturn();
                    idAdd();
                    System.out.print("Digite o Nome da Loja: ");
                    String name = scanf.next();
                    System.out.print("Digite o Endereço da Loja: ");
                    String address = scanf.next();
                    System.out.print("Digite o país da Loja: ");
                    String country = scanf.next();
                    Loja loja = (Loja) factory.CriarEntidade();
                    loja.setID(idCount);
                    loja.setName(name);
                    loja.setAddress(address);
                    loja.setCountry(country);
                    control.Incluir(loja);
                    break;
                case 2:
                    System.out.print("Digite o ID da Loja a ser Excluida: ");
                    int id = scanf.nextInt();
                    control.Excluir(control.BuscarID(id));
                    break;
                case 3:
                    System.out.print("Digite o ID da loja: ");
                    int id1 = scanf.nextInt();
                    System.out.print("Digite o tipo de dado a ser alterado(Name/Address/Country): ");
                    String dado = scanf.next();
                    System.out.print("Digite a nova informação para alterar: ");
                    String novodado = scanf.next();
                    control.Alterar(control.BuscarID(id1),dado,novodado);
                    break;
                case 4:
                    ItemController control2 = new ItemController();
                    System.out.print("Digite o ID do item a ser adicionado na loja: ");
                    int id2 = scanf.nextInt();
                    System.out.print("Digite o ID da loja a ser adicionado o item: ");
                    int id3 = scanf.nextInt();
                    control.addItem(id3,control2.BuscarID(id2));
                    break;
                case 5:
                    System.out.print("Digite o ID do item a ser removido na loja: ");
                    int id4 = scanf.nextInt();
                    System.out.print("Digite o ID da loja a ser removido o item: ");
                    int id5 = scanf.nextInt();
                    control.removeItem(id5,id4);
                    break;
                case 6:
                    break;
                default:
                    System.out.println("INVALID OPTION");
            }
        }
    }
    public static int idReturn() throws IOException {
        Reader reader = new Reader("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/ID Counter.txt");
        ArrayList<String> idcountt = reader.getFile();
        return Integer.parseInt(idcountt.get(0));
    }

    public static void idAdd() throws IOException {
        Reader reader = new Reader("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/ID Counter.txt");
        ArrayList<String> idcountt = reader.getFile();
        int novo = Integer.parseInt(idcountt.get(0)) + 1;
        idcountt.add(0,Integer.toString(novo));
        idcountt.remove(1);
        Writer writer = new Writer("/home/byakko/Documentos/Faculdade/Introdução a Engenharia de Software/Trabalho/tp/Trabalho/src/Files/ID Counter.txt");
        writer.WriteAll(idcountt);
    }
}
