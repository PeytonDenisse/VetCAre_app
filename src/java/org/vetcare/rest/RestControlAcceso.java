package org.vetcare.rest;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.ws.rs.*;
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
    public Response save(@FormParam("controlAcceso") String json) {
        Gson gson = new Gson();
        ControlAcceso u = gson.fromJson(json, ControlAcceso.class);

        ControlAccessoController c = new ControlAccessoController();
        c.save(u);

        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }

    // =============================================================
    //                        UPDATE (PUT)
    // =============================================================
    @Path("update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("controlAcceso") String json) {
        Gson gson = new Gson();
        ControlAcceso u = gson.fromJson(json, ControlAcceso.class);

        ControlAccessoController c = new ControlAccessoController();
        c.update(u);

        return Response.ok("{\"msg\":\"usuario actualizado\"}").build();
    }

    // =============================================================
    //                       DELETE (DELETE)
    // =============================================================
    @Path("delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        ControlAccessoController c = new ControlAccessoController();
        c.delete(id);

        return Response.ok("{\"msg\":\"usuario eliminado\"}").build();
    }

    // =============================================================
    //                   LOGIN CON GOOGLE (POST)
    // =============================================================
    @Path("login-google")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginGoogle(String body) {
        Gson gson = new Gson();
        String out;

        try {
            JsonObject json = gson.fromJson(body, JsonObject.class);
            String email = json.get("email").getAsString();

            ControlAccessoController c = new ControlAccessoController();
            ControlAcceso user = c.findByEmail(email);

            // Si no existe, lo creamos con rol por defecto
            if (user == null) {
                user = new ControlAcceso();
                user.setNombreUsuario(email);   // puedes luego cambiarlo por displayName
                user.setPassword("");
                user.setRol("veterinario");     // rol default
                user.setEmail(email);
                user.setEsGoogle(true);

                c.save(user);

                // Vuelve a consultarlo para obtener id
                user = c.findByEmail(email);
            }

            out = gson.toJson(user);
            return Response.ok(out).build();

        } catch (Exception e) {
            e.printStackTrace();
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(out).build();
        }
    }
}
