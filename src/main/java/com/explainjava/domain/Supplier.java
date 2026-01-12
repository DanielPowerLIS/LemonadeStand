package main.java.com.explainjava.domain;

import java.util.Objects;

public class Supplier {
    private int id;
    private String name;
    private String email;

    public Supplier(){
        this.id = -1;
    }

    public Supplier(int id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getId(){
        return this.id;
    }

    public void setId(int ID){
        this.id = ID;
    }

    public String email(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    @Override
    public String toString(){
        return "Supplier{" +
                "id= " + this.id +
                ", name= " + this.name + '\'' +
                ", email= " + this.email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Supplier supplier = (Supplier) o;

        return Objects.equals(this.id, supplier.getId());
    }
}
