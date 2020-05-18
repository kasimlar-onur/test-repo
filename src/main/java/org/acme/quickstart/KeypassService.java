package org.acme.quickstart;

import de.slackspace.openkeepass.KeePassDatabase;
import de.slackspace.openkeepass.domain.Attachment;
import de.slackspace.openkeepass.domain.Entry;
import de.slackspace.openkeepass.domain.KeePassFile;

import javax.enterprise.context.ApplicationScoped;
import java.io.*;
import java.util.Base64;
import java.util.List;

@ApplicationScoped
public class KeypassService {

    public void checkKeyPassService() throws FileNotFoundException {

        KeypassService.class.getClassLoader().getResource("").getPath();

        // 1. Open a KeePass database file through a plain text password
        KeePassFile database = KeePassDatabase
                .getInstance("/Users/okasimlar/Documents/zls-test-secret.kdbx")
                .openDatabase("James6Hunt");

        // 2. Retrieve all entries
        List<Entry> entries = database.getEntries();

        // 3. Print every entry
        File file = new File("/Users/okasimlar/Downloads/output.jks");
        for (Entry entry : entries) {
            List<Attachment> attachments = entry.getAttachments();
            for (Attachment attachment : attachments) {
                OutputStream
                        os
                        = new FileOutputStream(file);
                try {
                    os.write(attachment.getData());
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                System.out.println(Base64.getEncoder().encodeToString(attachment.getData()));
            }
            System.out.println("    * Credential: " + entry.getTitle());
            System.out.println("        Username: " + entry.getUsername());
            System.out.println("        Password: " + entry.getPassword());
        }

    }

}
