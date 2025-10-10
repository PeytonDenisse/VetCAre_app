package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

import org.vetcare.controller.PropietarioController;
import org.vetcare.model.Propietario;

@Path("propietarios")
public class RestPropietario {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();
        try {
            PropietarioController pc = new PropietarioController();
            List<Propietario> list = pc.getAll();
            out = gson.toJson(list);
        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }
        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("propietario") String propietarioJson) {
        Gson gson = new Gson();
        Propietario p = gson.fromJson(propietarioJson, Propietario.class);
        PropietarioController pc = new PropietarioController();
        pc.save(p);
        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }
}
