package View;

import Controler.Controller;
import Factory.AbstractFactory;

import java.io.IOException;
import java.util.Scanner;

public class Vision {
    static Scanner scanf = new Scanner(System.in);
    static AbstractFactory factory;

    public Vision() throws IOException {
    }

    public static void main(String[] args) throws IOException {
        int option = 0;
        while(option != 3){
            System.out.println("1 - MENU LOJA");
            System.out.println("2 - MENU ITEM");
            System.out.println("3 - SAIR");
            System.out.print("Digite sua Opção: ");
            option = scanf.nextInt();

            switch (option){
                case 1:
                    factory = AbstractFactory.ObterFactory("Loja");
                    VisionLoja lojavision = (VisionLoja) factory.CriarVision();
                    lojavision.menu();
                    break;
                case 2:
                    factory = AbstractFactory.ObterFactory("Item");
                    VisionItem itemvision = (VisionItem) factory.CriarVision();
                    itemvision.menu();
                case 3:
                    break;
            }
        }
    }
}