package dao;

import entities.Animal;

import java.util.ArrayList;
import java.util.List;

public class DaoMemory {
    private final List<Animal> animals = new ArrayList<>();

    public DaoMemory() {
        animals.add(new Animal(10L, "Mouse"));
        animals.add(new Animal(11L, "Dog"));
        animals.add(new Animal(12L, "Cat"));
    }

    public List<Animal> getListCollection() {
        return animals;
    }

    public List<Animal> listCollection(Animal animal) {
        animals.add(animal);
        return animals;
    }

    public List<Animal> putMemory(Animal animal) {
        if (animals.stream().noneMatch(item -> item.getName().equals(animal.getName()))) {
            animals.add(new Animal(animal));
        }
        return animals;
    }

    public List<Animal> deleteMemory(Long id) {
        animals.removeIf(existingAnimal -> existingAnimal.getId().equals(id));
        return animals;
    }
}
