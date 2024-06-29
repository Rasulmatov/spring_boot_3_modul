package uz.universes.spring_boot_3_modul.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uz.universes.spring_boot_3_modul.dto.BookDto;
import uz.universes.spring_boot_3_modul.model.Book;
import uz.universes.spring_boot_3_modul.model.MailModel;

import java.util.List;

@org.springframework.stereotype.Controller
@RequiredArgsConstructor
public class Controller {
    private final MailModel model2;
    private final JdbcTemplate jdbcTemplate;

    @Value("${welcome.message}")
    private String message;

    @GetMapping("/")
    public String homePage(Model model){
        model.addAttribute("message",message);
        String query="select * from book";
        List<Book> query1 = jdbcTemplate.query(query, BeanPropertyRowMapper.newInstance(Book.class));
        if (!query1.isEmpty()) {
            model.addAttribute("books", query1);
            return "home";
        }
        return "index";
    }

    @GetMapping("/book/create")
    public String bookCreatePage(){
        return "book_create";
    }

     @GetMapping("/not")
    public String notFound(){
        return "index";
    }

    @PostMapping("/book/create")
    public String bookCreate(@ModelAttribute BookDto bookDto){
        String sql="insert into book (name, author) values (?,?)";
        jdbcTemplate.update(sql,bookDto.getName(),bookDto.getAuthor());
        return "book_create";
    }
}
