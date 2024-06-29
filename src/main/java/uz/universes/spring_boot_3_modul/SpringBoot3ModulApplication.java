package uz.universes.spring_boot_3_modul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import uz.universes.spring_boot_3_modul.model.MailModel;

@SpringBootApplication
@EnableConfigurationProperties(MailModel.class)
public class SpringBoot3ModulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot3ModulApplication.class, args);
    }

}
