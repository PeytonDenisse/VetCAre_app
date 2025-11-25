package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

import org.vetcare.controller.TratamientoController;
import org.vetcare.model.Tratamiento;

@Path("tratamientos")
public class RestTratamiento {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();

        try {
            TratamientoController tc = new TratamientoController();
            List<Tratamiento> list = tc.getAll();
            out = gson.toJson(list);

        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }

        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("tratamiento") String tratamientoJson) {
        Gson gson = new Gson();
        Tratamiento t = gson.fromJson(tratamientoJson, Tratamiento.class);

        TratamientoController tc = new TratamientoController();
        tc.save(t);

        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }

    // =============================================================
    //                           UPDATE
    // =============================================================
    @Path("update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("tratamiento") String tratamientoJson) {
        Gson gson = new Gson();
        Tratamiento t = gson.fromJson(tratamientoJson, Tratamiento.class);

        TratamientoController tc = new TratamientoController();
        tc.update(t);

        return Response.ok("{\"msg\":\"tratamiento actualizado\"}").build();
    }

    // =============================================================
    //                           DELETE
    // =============================================================
    @Path("delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {

        TratamientoController tc = new TratamientoController();
        tc.delete(id);

        return Response.ok("{\"msg\":\"tratamiento eliminado\"}").build();
    }
}
