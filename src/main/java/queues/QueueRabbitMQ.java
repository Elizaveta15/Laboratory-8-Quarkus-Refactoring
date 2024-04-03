package queues;

import entities.Animal;
import dao.DaoMemory;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;
import io.smallrye.reactive.messaging.annotations.Blocking;

public class QueueRabbitMQ {
    DaoMemory daoMemory;

    public QueueRabbitMQ() {
        daoMemory = new DaoMemory();
    }

    @Incoming("requests")
    @Outgoing("answers")
    @Blocking
    public Animal process(String request) throws InterruptedException {
        System.out.println("The search is underway");
        Thread.sleep(2000);
        Animal animal = daoMemory.getListCollection().stream()
                .filter(animalCur -> request.equals(animalCur.getName()))
                .findFirst()
                .orElse(new Animal((long) -1, "Not found"));
        System.out.println("The search is completed");
        return animal;
    }
}
