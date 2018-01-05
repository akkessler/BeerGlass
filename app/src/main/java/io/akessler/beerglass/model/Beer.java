package io.akessler.beerglass.model;

public class Beer {

    public int id;
    public String name = "Example beer name";
    public String company = "Example beer company";
    public String description = "Example beer description";

    public Beer(int id) {
        this.id = id;
        name += " " + id;
    }

}
