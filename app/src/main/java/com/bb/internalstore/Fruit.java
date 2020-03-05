package com.bb.internalstore;

public class Fruit {

    private String fruitName;
    private String timeEaten;

    public Fruit(String fruitName, String timeEaten) {
        this.fruitName = fruitName;
        this.timeEaten = timeEaten;
    }

    public String getFruitName() {
        return fruitName;
    }

    public void setFruitName(String fruitName) {
        this.fruitName = fruitName;
    }

    public String getTimeEaten() {
        return timeEaten;
    }

    public void setTimeEaten(String timeEaten) {
        this.timeEaten = timeEaten;
    }

    @Override
    public String toString(){
        return fruitName + " " + timeEaten;
    }
}
