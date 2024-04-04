package dao;

import entities.Animal;
import entities.Mammal;

import java.util.ArrayList;
import java.util.List;

public class DaoNotMemory {

    public DaoNotMemory() {
    }

    public Animal getOne() {
        return new Animal(0L, "Fox");
    }

    public Animal getOnePath(String name) {
        return new Animal(name);
    }

    public Animal getOneQuery(String name) {
        return new Animal(name);
    }

    public Animal postOneShowOne(Animal animal) {
        return new Mammal(animal);
    }

    public List<Mammal> postOneShowList(Animal animal) {
        List<Mammal> mammals = new ArrayList<>();
        mammals.add(new Mammal(animal));
        mammals.add(new Mammal(animal));
        mammals.add(new Mammal(animal));
        return mammals;
    }

    public Animal postListShowOne(ArrayList<Animal> animals) {
        return animals.get(1);
    }
}
