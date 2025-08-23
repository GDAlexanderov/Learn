package org.example;

public class StarSystem {
    private String starname;
    private int quantityOfPlanets;
    private int age;
    public StarSystem(String starname, int quantityOfPlanets, int age) {
        this.starname = starname;
        this.quantityOfPlanets = quantityOfPlanets;
        this.age = age;
    }
    public String getInfo(){
        return starname+" "+quantityOfPlanets+" "+age;
    }
    public String getStarname() {
        return starname;
    }

    public void setStarname(String starname) {
        this.starname = starname;
    }

    public int getQuantityOfPlanets() {
        return quantityOfPlanets;
    }

    public void setQuantityOfPlanets(int quantityOfPlanets) {
        this.quantityOfPlanets = quantityOfPlanets;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
