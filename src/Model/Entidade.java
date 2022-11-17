package Model;

public abstract class Entidade {

    private int ID;
    private String Name;

    public Entidade(int ID, String name) {
        this.ID = ID;
        Name = name;
    }


    @Override
    public abstract String toString();

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
