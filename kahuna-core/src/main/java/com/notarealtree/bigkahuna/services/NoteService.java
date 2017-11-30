package com.notarealtree.bigkahuna.services;

import com.notarealtree.bigkahuna.model.NoteId;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Set;

@Path("/kahuna/note")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface NoteService {
    @POST
    @Path("/")
    NoteId addNote(String text);

    @POST
    @Path("/{id}")
    void updateNote(@PathParam("id") String id, String text);

    @GET
    @Path("/preview")
    Set<NoteId> getNotes();

    @GET
    @Path("/{id}")
    String getNote(@PathParam("id") NoteId id);
}
