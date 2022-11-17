package Model;

import java.util.ArrayList;
import java.util.List;
public class Loja extends Entidade {

    private String Address;
    private String Country;
    private List<Item> Itens = new ArrayList<>();

    public Loja(int id, String nome,String address, String country) {
        super(id,nome);
        Address = address;
        Country = country;
    }

    @Override
    public String toString() {
        return  "Model.Loja{" +
                "Address='" + Address + '\'' +
                ", Country='" + Country + '\'' +
                ", itens=" + Itens +
                '}';
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public List<Item> getItens() {
        return Itens;
    }

    public void setItens(List<Item> itens) {
        this.Itens = itens;
    }
}
