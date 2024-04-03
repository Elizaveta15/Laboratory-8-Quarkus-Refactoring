package controllers;

import dao.DaoMemory;

import entities.Animal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;

import java.util.List;

@ApplicationScoped
@Path("/animal")
public class ControllerMemory {

    private DaoMemory daoMemory;

    public ControllerMemory() {
        daoMemory = new DaoMemory();
    }

    @POST
    @Path("/postMemory")
    public List<Animal> listCollection(Animal animal) {
        return daoMemory.listCollection(animal);
    }

    @PUT
    @Path("/putMemory")
    public List<Animal> putMemory(Animal animal) {
        return daoMemory.putMemory(animal);
    }

    @DELETE
    @Path("/deleteMemory")
    public List<Animal> deleteMemory(@QueryParam("id") Long id) {
        return daoMemory.deleteMemory(id);
    }
}
