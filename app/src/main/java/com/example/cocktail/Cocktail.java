package com.example.cocktail;

public class Cocktail {
    public String cId;
    public String cName;
    public String cSugar;
    public String cAlcohol;
    public Cocktail(){

    }
    public Cocktail(String cName, String cSugar, String cAlcohol){
        this.cName = cName;
        this.cSugar = cSugar;
        this.cAlcohol = cAlcohol;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcSugar() {
        return cSugar;
    }

    public void setcSugar(String cSugar) {
        this.cSugar = cSugar;
    }

    public String getcAlcohol() {
        return cAlcohol;
    }

    public void setcAlcohol(String cAlcohol) {
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
