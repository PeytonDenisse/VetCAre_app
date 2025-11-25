package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

import org.vetcare.controller.FacturacionController;
import org.vetcare.model.Facturacion;

@Path("facturacion")
public class RestFacturacion {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();
        try {
            FacturacionController fc = new FacturacionController();
            List<Facturacion> list = fc.getAll();
            out = gson.toJson(list);
        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }
        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("facturacion") String facturacionJson) {
        Gson gson = new Gson();
        Facturacion f = gson.fromJson(facturacionJson, Facturacion.class);

        FacturacionController fc = new FacturacionController();
        fc.save(f);

        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }

    // =============================================================
    //                       UPDATE (PUT)
    // =============================================================
    @Path("update")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@FormParam("facturacion") String facturacionJson) {
        Gson gson = new Gson();
        Facturacion f = gson.fromJson(facturacionJson, Facturacion.class);

        FacturacionController fc = new FacturacionController();
        fc.update(f);

        return Response.ok("{\"msg\":\"factura actualizada\"}").build();
    }

    // =============================================================
    //                       DELETE (DELETE)
    // =============================================================
    @Path("delete/{id}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") int id) {
        FacturacionController fc = new FacturacionController();
        fc.delete(id);

        return Response.ok("{\"msg\":\"factura eliminada\"}").build();
    }
}
