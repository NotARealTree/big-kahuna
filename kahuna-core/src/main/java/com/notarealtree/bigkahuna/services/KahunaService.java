package com.notarealtree.bigkahuna.services;

import com.notarealtree.bigkahuna.model.NoteId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/kahuna")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface KahunaService {

    @POST
    @Path("/note")
    NoteId addNote(String text);

    @POST
    @Path("/note/{id}")
    void updateNote(@PathParam("id") String id, String text);

    @GET
    @Path("/note/preview")
    Set<String> getNotes();

    @GET
    @Path("/note/{id}")
    String getNote(@PathParam("id") String id);
}
