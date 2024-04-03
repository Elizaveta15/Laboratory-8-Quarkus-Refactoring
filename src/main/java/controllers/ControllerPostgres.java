package controllers;

import dao.DaoPostgres;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import entities.Animal;

import java.sql.SQLException;

@ApplicationScoped
@Path("/animal")
public class ControllerPostgres {
    private DaoPostgres daoPostgres;

    public ControllerPostgres() throws SQLException {
        daoPostgres = new DaoPostgres();
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/createByName")
    public String createByNameDB(Animal animal) {
        return daoPostgres.createByName(animal);
    }

    @GET
    @Path("/readOne/{id}")
    public Animal readOneDB(@PathParam("id") String id) {
        return daoPostgres.readOne(id);
    }

    @GET
    @Path("/readByName/{name}")
    public Animal readByNameDB(@PathParam("name") String name) {
        return daoPostgres.readByName(name);
    }

    @PUT
    @Path("/updateByName/{name}")
    @Transactional
    public String updateByNameDB(@PathParam("name") String name) {
        return daoPostgres.updateByName(name);
    }

    @DELETE
    @Path("/deleteByName/{name}")
    @Transactional
    public String deleteByNameDB(@PathParam("name") String name) {
        return daoPostgres.deleteByName(name);
    }
}
