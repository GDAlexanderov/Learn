package org.example;

public class SunSystem extends StarSystem{
    private long population;
    public SunSystem(int quantityOfPlanets, int age,long population) {
        super("sun", quantityOfPlanets, age);
        this.population = population;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
    @Override
    public String getInfo() {
        return "This is the most densely populated star system in the universe(probably).";
    }
}
