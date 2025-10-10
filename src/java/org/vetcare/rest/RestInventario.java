package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

import org.vetcare.controller.InventarioController;
import org.vetcare.model.Inventario;

@Path("inventario")
public class RestInventario {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();
        try {
            InventarioController ic = new InventarioController();
            List<Inventario> list = ic.getAll();
            out = gson.toJson(list);
        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }
        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("inventario") String inventarioJson) {
        Gson gson = new Gson();
        Inventario i = gson.fromJson(inventarioJson, Inventario.class);
        InventarioController ic = new InventarioController();
        ic.save(i);
        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }
}
