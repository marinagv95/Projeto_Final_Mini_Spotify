package br.com.maisunifacisa.models;

import java.util.ArrayList;

public class Catalogo {
    private ArrayList<Midia> midias = new ArrayList<>();

    public Catalogo(ArrayList<Midia> midias) {
        this.midias = midias;
    }

    public ArrayList<Midia> getMidias() {
        return midias;
    }

    public void setMidias(ArrayList<Midia> midias) {
        this.midias = midias;
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "midias=" + midias +
                '}';
    }
}
