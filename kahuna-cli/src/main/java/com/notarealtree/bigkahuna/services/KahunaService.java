package com.notarealtree.bigkahuna.services;

import com.notarealtree.bigkahuna.model.NoteId;
import feign.Body;
import feign.Headers;
import feign.Param;
import feign.RequestLine;

import java.util.Set;

public interface KahunaService {
    @RequestLine("GET /kahuna/note")
    @Headers("Content-Type: application/json")
    @Body("{text}")
    NoteId addNote(String text);

    @RequestLine("POST /kahuna/note/{id}")
    @Headers("Content-Type: application/json")
    @Body("\"{text}\"")
    void updateNote(@Param("id") String id, String text);

    @RequestLine("GET /kahuna/note/preview")
    Set<String> getNotes();

    @RequestLine("GET /kahuna/note/{id}")
    String getNote(@Param("id") String id);
}