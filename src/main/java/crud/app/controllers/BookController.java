package crud.app.controllers;

import crud.app.dao.BookDAO;
import crud.app.dao.MemberDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/library")
public class BookController {

    private final BookDAO bookDAO;
//    private final PersonValidator personValidator;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("bookList", bookDAO.index());
        return "library/libraryPage";
    }



}
