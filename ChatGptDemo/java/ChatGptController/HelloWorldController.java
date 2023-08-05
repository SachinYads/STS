package ChatGptController;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @GetMapping("/get_zone")
    public ResponseEntity<List<String>> zoneList() throws IOException {
        ClassPathResource resource = new ClassPathResource("data/Zone_data.csv");
        List<String> zoneList = Files.readAllLines(resource.getFile().toPath());
        return ResponseEntity.ok(zoneList);
    }
}
