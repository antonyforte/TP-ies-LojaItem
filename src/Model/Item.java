package Model;

import Model.Entidade;

public class Item extends Entidade {

    // ATRIBUTOS 8-9
    private String Type;
    private String Price;


    // CONSTRUTOR 12-16
    public Item(int id, String name, String price, String type) {
        super(id,name);
        Type = type;
        Price = price;

    }

    // TOSTRING 19-25
    @Override
    public String toString() {
        return "Model.Item{" +
                "Price=" + Price +
                ", Type='" + Type + '\'' +
                '}';
    }

    // GETTERS & SETTERS 28-42
    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        Price = price;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
