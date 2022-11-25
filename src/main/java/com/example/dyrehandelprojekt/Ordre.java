package com.example.dyrehandelprojekt;
import java.util.ArrayList;
import java.util.List;

public class Ordre {
    private int ordrenr;
    private String kundenavn;
    private int dato;

    public String toString() { return ordrenr + kundenavn + dato;}

    private List<Vare> vareList = new ArrayList<>();


    public Ordre (int ordrenr, String kundenavn, int dato){
        this.ordrenr = ordrenr;
        this.kundenavn = kundenavn;
        this.dato = dato;
    }


    public void addVare(Vare v) {
        vareList.add(v);
    }
    public void removeVare(Vare v) {
        vareList.remove(v);
    }

    public List<Vare> getVareList() {
        return vareList;
    }



}
