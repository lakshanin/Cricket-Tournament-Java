package sample;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Player{

    protected SimpleIntegerProperty index;
    protected SimpleStringProperty cap;
    protected SimpleStringProperty name;

    public Player(int index, String cap, String name){
        this.index = new SimpleIntegerProperty(index);
        this.cap = new SimpleStringProperty(cap);
        this.name = new SimpleStringProperty(name);
    }

    public Player() {
    }

    public int getIndex() {
        return index.get();
    }

    public void setIndex(int index) {
        this.index = new SimpleIntegerProperty(index);
    }

    public String getCap() {
        return cap.get();
    }

    public void setCap(String cap) {
        this.cap = new SimpleStringProperty(cap);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name = new SimpleStringProperty(name);
    }
}
