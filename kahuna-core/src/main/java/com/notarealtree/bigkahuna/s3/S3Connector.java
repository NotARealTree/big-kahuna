package com.notarealtree.bigkahuna.s3;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.notarealtree.bigkahuna.dagger.annotations.S3BucketName;
import com.notarealtree.bigkahuna.model.NoteId;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.*;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Singleton
public class S3Connector {
    private final String bucketName;
    private final AmazonS3 s3;

    @Inject
    public S3Connector(@S3BucketName String bucketName, AmazonS3 s3) {
        this.bucketName = bucketName;
        this.s3 = s3;
    }

    public String addNote(String text) {
        String noteId = "note-" + UUID.randomUUID().toString();
        try {
            File file = createTempFileWithContent(text);
            s3.putObject(bucketName, noteId, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return noteId;
    }

    public Set<String> previewNotes() {
        return s3.listObjects(bucketName, "note").getObjectSummaries().stream()
                .map(summary -> String.format("%s\t\t%s\t\t%sB", summary.getKey(), summary.getLastModified(), summary.getSize()))
                .collect(Collectors.toSet());
    }

    public String getNote(NoteId id) {
        return s3.getObjectAsString(bucketName, id.id());
    }

    public void putNote(String id, String text) {
        try {
            File file = createTempFileWithContent(text);
            s3.putObject(bucketName, id, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private File createTempFileWithContent(String text) throws IOException {
        File file = File.createTempFile("note-", ".txt");
        file.deleteOnExit();
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write(text);
        writer.close();
        return file;
    }
}
