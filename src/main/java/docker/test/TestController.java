package docker.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

    @Value("${server.env}")
    private String env;
    @Value("${server.port}")
    private String serverPort;
    @Value("${server.serverAddress}")
    private String serverAddress;
    @GetMapping("/test")
    public String test(){
        return "hello docker cicd!!";
    }
    @GetMapping("/hc")
    public ResponseEntity<?> healthCheck(){
        Map<String, String> responseData = new HashMap<>();
        responseData.put("env", env);
        responseData.put("serverPort", serverPort);
        responseData.put("serverAddress", serverAddress);
        return ResponseEntity.ok(responseData);
    }
    @GetMapping("/env")
    public ResponseEntity<?> getEnv(){
        Map<String, String> responseData = new HashMap<>();
        return ResponseEntity.ok(env);
    }
}


