package chmielecki.a.library.controllers;


import chmielecki.a.library.domain.Book;
import chmielecki.a.library.domain.Pending;
import chmielecki.a.library.domain.User;
import chmielecki.a.library.repositories.BookRepository;
import chmielecki.a.library.repositories.PendingRepository;
import chmielecki.a.library.repositories.UserRepository;
import chmielecki.a.library.services.BookService;
import chmielecki.a.library.services.PendingService;
import chmielecki.a.library.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;

@org.springframework.stereotype.Controller
public class Controller {

    private final BookRepository bookRepository;
    private final PendingRepository pendingRepository;
    private final UserRepository userRepository;

    @Autowired
    private final BookService bookService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final PendingService pendingService;


    public Controller(BookRepository bookRepository, PendingRepository pendingRepository, UserRepository userRepository, BookService bookService, UserService userService, PendingService pendingService) {
        this.bookRepository = bookRepository;
        this.pendingRepository = pendingRepository;
        this.userRepository = userRepository;
        this.bookService = bookService;
        this.userService = userService;
        this.pendingService = pendingService;
    }

    @RequestMapping({"/",""})
    public String mainPage(Model model){

        return "main";
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookRepository.findAll());
        return "booksList";
    }
    @RequestMapping("/users")
    public String getUsers(Model model){

        model.addAttribute("users", userRepository.findAll());
        return "usersList";
    }
    @RequestMapping("/pendings")
    public String getPendings(Model model){

        model.addAttribute("pendings", pendingRepository.findAll());
        return "pendingsList";
    }

    @PostMapping(
            value = "/createBook", consumes = "application/json", produces = "application/json")
    public String createBook(@RequestBody Book book) {
        bookService.saveUpdateBook(book);
        return "main";
    }

    @PostMapping(
            value = "/updateBook", consumes = "application/json", produces = "application/json")
    public String updateBook(@RequestBody Book book, HttpServletResponse response) {
        //response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath().path("/findBook/" + book.getId()).toUriString());

        bookService.saveUpdateBook(book);
        return "main";
    }

    @PostMapping(
            value = "/createUser", consumes = "application/json", produces = "application/json")
    public String createUser(@RequestBody User user) {
        userService.saveUpdateUser(user);
        return "main";
    }

    @PostMapping(
            value = "/updateUser", consumes = "application/json", produces = "application/json")
    public String updateUser(@RequestBody User user) {

        userService.saveUpdateUser(user);
        return "main";
    }

    @PostMapping(
            value = "/createPending", consumes = "application/json", produces = "application/json")
    public String createPending(@RequestBody Pending pending) {
        pendingService.saveUpdatePending(pending);
        return "main";
    }

    @PostMapping(
            value = "/updatePending", consumes = "application/json", produces = "application/json")
    public String updatePending(@RequestBody Pending pending) {

        pendingService.saveUpdatePending(pending);
        return "main";
    }
}
