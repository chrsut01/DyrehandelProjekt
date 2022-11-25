package com.example.dyrehandelprojekt;
import java.util.LinkedList;
import java.util.List;

public class Vare {
    public int varenr;
    private String varebeskrivelse;

    public String toString() { return varenr + varebeskrivelse;}


    public Vare(int varenr, String varebeskrivelse) {
        this.varenr = varenr;
        this.varebeskrivelse = varebeskrivelse;
    }


}






