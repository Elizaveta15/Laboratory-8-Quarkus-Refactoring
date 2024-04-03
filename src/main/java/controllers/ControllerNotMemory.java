package controllers;

import dao.DaoNotMemory;

import entities.Animal;
import entities.Mammal;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@Path("/animal")
public class ControllerNotMemory {
    private DaoNotMemory daoNotMemory;

    public ControllerNotMemory() {
        daoNotMemory = new DaoNotMemory();
    }

    @GET
    @Path("/getOne")
    public Animal getOne() {
        return daoNotMemory.getOne();
    }

    @GET
    @Path("/getOnePath/{name}")
    public Animal getOnePath(@PathParam("name") String name) {
        return daoNotMemory.getOnePath(name);
    }

    @GET
    @Path("/getOneQuery")
    public Animal getOneQuery(@QueryParam("name") String name) {
        return daoNotMemory.getOneQuery(name);
    }

    @POST
    @Path("/postOneShowOne")
    public Animal postOneShowOne(Animal animal) {
        return daoNotMemory.postOneShowOne(animal);
    }

    @POST
    @Path("/postOneShowList")
    public List<Mammal> postOneShowList(Animal animal) {
        return daoNotMemory.postOneShowList(animal);
    }

    @POST
    @Path("/postListShowOne")
    public Animal postListShowOne(ArrayList<Animal> animals) {
        return daoNotMemory.postListShowOne(animals);
    }
}
