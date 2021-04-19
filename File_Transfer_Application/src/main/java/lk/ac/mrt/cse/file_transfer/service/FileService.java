package lk.ac.mrt.cse.file_transfer.service;

import lk.ac.mrt.cse.file_transfer.exception.FileStorageException;
import lk.ac.mrt.cse.file_transfer.exception.MyFileNotFoundException;
import lk.ac.mrt.cse.file_transfer.property.FileStorageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Objects;

@Service
public class FileService {

    private final Path filePath;

    @Autowired
    public FileService(FileStorageProperties fileStorageProperties) {
        this.filePath = Paths.get(fileStorageProperties.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.filePath);
        } catch (Exception e) {
            throw new FileStorageException("Can't create upload files directory", e);
        }
    }

    public String storeFile(MultipartFile file) {
        String name = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        try {
            if(name.contains("..")) throw new FileStorageException("Invalid path " + name);
            Path targetLocation = this.filePath.resolve(name);
            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            return name;
        } catch (IOException e) {
            throw new FileStorageException("Can't file " + name, e);
        }
    }

    public Resource loadFile(String fileName) {
        try {
            Path filePath = this.filePath.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) return resource;
            else throw new MyFileNotFoundException(fileName + " File not found");
        } catch (MalformedURLException e) {
            throw new MyFileNotFoundException(fileName+ " File not found", e);
        }
    }
}
