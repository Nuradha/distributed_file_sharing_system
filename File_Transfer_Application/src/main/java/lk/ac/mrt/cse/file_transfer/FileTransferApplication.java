package lk.ac.mrt.cse.file_transfer;

import lk.ac.mrt.cse.file_transfer.property.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
		FileStorageProperties.class
})
public class FileTransferApplication {

	public static void main(String[] args) {
		SpringApplication.run(FileTransferApplication.class, args);
	}

}
