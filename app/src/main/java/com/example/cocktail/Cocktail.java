package com.example.cocktail;

public class Cocktail {
    public String cId;
    public String cName;
    public int cSugar;
    public int cAlcohol;
    public Cocktail(){

    }
    public Cocktail(String cName, int cSugar, int cAlcohol){
        this.cName = cName;
        this.cSugar = cSugar;
        this.cAlcohol = cAlcohol;
    }

    public int getcSugar() {
        return cSugar;
    }

    public void setcSugar(int cSugar) {
        this.cSugar = cSugar;
    }

    public int getcAlcohol() {
        return cAlcohol;
    }

    public void setcAlcohol(int cAlcohol) {
        this.cAlcohol = cAlcohol;
    }

    @Override
    public String toString(){
        return "Cocktail{" +
                "Cocktail name = " + cName + '\'' +
                ", Sugar = " + cSugar + '\'' +
                ", Alcohol = " + cAlcohol +
                " }";
    }
}
