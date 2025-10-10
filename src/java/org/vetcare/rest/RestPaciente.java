package org.vetcare.rest;

import com.google.gson.Gson;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

import org.vetcare.controller.PacienteController;
import org.vetcare.model.Paciente;

@Path("pacientes")
public class RestPaciente {

    @Path("getAll")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        String out;
        Gson gson = new Gson();
        try {
            PacienteController pc = new PacienteController();
            List<Paciente> list = pc.getAll();
            out = gson.toJson(list);
        } catch (Exception e) {
            out = String.format("{\"error\":\"%s\"}", e.getMessage());
        }
        return Response.ok(out).build();
    }

    @Path("save")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response save(@FormParam("paciente") String pacienteJson) {
        Gson gson = new Gson();
        Paciente p = gson.fromJson(pacienteJson, Paciente.class);
        PacienteController pc = new PacienteController();
        pc.save(p);
        return Response.ok("{\"msg\":\"registro exitoso\"}").build();
    }
}
