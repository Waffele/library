package chmielecki.a.library.controllers;


import chmielecki.a.library.repositories.BookRepository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
public class Controller {

    private final BookRepository bookRepository;


    public Controller(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping({"/",""})
    public String mainPage(Model model){

        return "main";
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());
        return "list";
    }
}
