package entities;

public class Mammal extends Animal {
    private Integer numberNipples;

    public Mammal(Animal animal) {
        super(animal);
        this.numberNipples = 4;
    }

    public Integer getNumberNipples() {
        return numberNipples;
    }

    public void setNumberNipples(Integer numberNipples) {
        this.numberNipples = numberNipples;
    }

}
