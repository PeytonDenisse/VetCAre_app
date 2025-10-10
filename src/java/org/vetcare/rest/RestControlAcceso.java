package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;


import org.vetcare.controller.ControlAccessoController;
import org.vetcare.model.ControlAcceso;

@Path("usuarios")
public class RestControlAcceso {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();
        try {
            ControlAccessoController c = new ControlAccessoController();
            List<ControlAcceso> list = c.getAll();
            out = gson.toJson(list);
        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }
        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("controlAcceso") String controlAccesoJson) {
        Gson gson = new Gson();
        ControlAcceso u = gson.fromJson(controlAccesoJson, ControlAcceso.class);
        ControlAccessoController c = new ControlAccessoController();
        c.save(u);
        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }
}
