package uz.universes.spring_boot_3_modul.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {
    private Integer id;
    private String name;
    private String author;

}
