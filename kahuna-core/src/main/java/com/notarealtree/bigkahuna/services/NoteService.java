package com.notarealtree.bigkahuna.services;

import com.notarealtree.bigkahuna.model.NoteId;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.Set;

@Path("/kahuna/note")
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
