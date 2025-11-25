package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

import org.vetcare.controller.CitaController;
import org.vetcare.model.Cita;

@Path("citas")
public class RestCita {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();
        try {
            CitaController cc = new CitaController();
            List<Cita> list = cc.getAll();
            out = gson.toJson(list);
        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }
        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("cita") String citaJson) {
        Gson gson = new Gson();
        Cita c = gson.fromJson(citaJson, Cita.class);
        CitaController cc = new CitaController();
        cc.save(c);
        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }
    
    @Path("update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("cita") String citaJson) {
        Gson gson = new Gson();
        Cita c = gson.fromJson(citaJson, Cita.class);
        CitaController cc = new CitaController();
        cc.update(c);
        return Response.ok("{\"msg\":\"cita actualizada\"}").build();
    }
    @Path("delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        CitaController cc = new CitaController();
        cc.delete(id);
        return Response.ok("{\"msg\":\"cita eliminada\"}").build();
}


}
