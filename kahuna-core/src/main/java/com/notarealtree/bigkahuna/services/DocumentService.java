package com.notarealtree.bigkahuna.services;

import com.notarealtree.bigkahuna.model.DocumentId;

import com.notarealtree.bigkahuna.model.PartialDocument;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/kahuna/document")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface DocumentService {
    @POST
    @Path("/")
    DocumentId addDocument(PartialDocument partialDocument);

    @POST
    @Path("/{id}")
    void updateDocument(@PathParam("id") String id, String text);
}
