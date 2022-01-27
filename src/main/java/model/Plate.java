package model;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public int getFood() {
        return food;
    }

    public void decreaseFood(int foodEaten) {
        if (food < 1) {
            System.out.println("Миска пуста, положите корм в миску");
        } else if (food < foodEaten) {
            System.out.println("Корма недостаточно, положите корм в миску");
        } else {
            food -= foodEaten;
        }
    }

    public void addFood(int food) {
        this.food += food;
        System.out.println("Добавлено " + food + " корма.");
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
