package api.com.medhead;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
public class MsLocalizeApplication
{
    public static void main(String[] args) {

        SpringApplication.run(MsLocalizeApplication.class, args);
    }
}
