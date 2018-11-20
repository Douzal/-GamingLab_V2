package fr.gaminglab.utilitaire;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class UploadJeu {

    private Logger log = LoggerFactory.getLogger(this.getClass().getName());
    private static Path rootLocation = Paths.get("jeux");

    public UploadJeu() {
    }

    public static void store(MultipartFile file, boolean estUnZip) {
        try {
            if (estUnZip){
                unZip(file);
            } else {
                Files.copy(file.getInputStream(), UploadJeu.rootLocation.resolve(file.getOriginalFilename()));
            }
        } catch (Exception e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public static Resource loadFile(String filename) {
        try {
            Path file = rootLocation.resolve(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("FAIL!");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("FAIL!");
        }
    }

    public static void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    public static void init() {
        try {
            Files.createDirectory(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage!");
        }
    }

    public static void unZip(MultipartFile file) throws IOException {

        File zip = File.createTempFile(UUID.randomUUID().toString(), "temp");

        FileOutputStream o = new FileOutputStream(zip);
        IOUtils.copy(file.getInputStream(), o);
        o.close();
        String destination = rootLocation.toString();
        System.out.println(destination);
        //String destination = path;
        try {
            ZipFile zipFile = new ZipFile(zip);
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            e.printStackTrace();
        } finally {
            zip.delete();
        }
    }

    public static Path getRootLocation() {
        return rootLocation;
    }

    public static void setRootLocation(Path rootLocation) {
        UploadJeu.rootLocation = rootLocation;
    }


}
