package uz.universes.spring_boot_3_modul.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ToString
@ConfigurationProperties(prefix = "mailmodel")
public class MailModel {
    private String server;
    private String user;
    private String password;
    private Boolean enabled;
}
