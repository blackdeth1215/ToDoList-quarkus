package org.example.service;

import org.example.model.ToDoList;
import org.jboss.logging.Logger;

import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashSet;
import java.util.Set;

@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ToDoListService {
    private Logger LOGGER = Logger.getLogger(ToDoListService.class);
    private Set<ToDoList> toDoLists = new HashSet<>();

    public ToDoListService() {
        toDoLists.add(new ToDoList("Test1", "desc test1","done"));
        toDoLists.add(new ToDoList("Test2", "desc test2","incomplete"));
        toDoLists.add(new ToDoList("Test3", "desc test3","done"));
    }
    @Path("/get")
    @GET
    public Set<ToDoList> list() {
        LOGGER.info("Se mostro correctamente los datos");
        return toDoLists;
    }
    @Path("/post")
    @POST
    public Set<ToDoList> add(ToDoList element) {
        LOGGER.info("Se añadio correctamente"+element);
        toDoLists.add(element);
        return toDoLists;
    }
    @Path("/delete")
    @DELETE
    public Set<ToDoList> delete(ToDoList element) {
        LOGGER.info("Eliminación completa");
        toDoLists.removeIf(value -> value.getTitle().contentEquals(element.getTitle()));
        return toDoLists;
    }
    @Path("/put")
    @PUT
    public Set<ToDoList> update(ToDoList element) {
        toDoLists.forEach(value -> {
            if (value.getTitle().equals(element.getTitle())) {
                LOGGER.info("Actualización completa de la Descripción");
                value.setDescription(element.getDescription());
            }
        });
        return toDoLists;
    }
    @Path("/stade")
    @PUT
    public Set<ToDoList> update1(ToDoList element){
        toDoLists.forEach(value ->{
            if (value.getTitle().equals(element.getTitle())) {
                LOGGER.info("Actualización completa de estado");
                value.setStade(element.getStade());
            }
        });
        return toDoLists;
    }
    @Path("{title}")
    @GET
    @Transactional
    public Set<ToDoList> busqueda(String title) {
        toDoLists.forEach(value ->{
            if(value.getTitle().equals(title)){
                LOGGER.info("Busqueda completa"+title);
                value.setTitle(title);
            }else {
                LOGGER.info("Error");
            }
        });
        return toDoLists;
    }
}