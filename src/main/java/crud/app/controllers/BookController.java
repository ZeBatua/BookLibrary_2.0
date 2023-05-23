package crud.app.controllers;

import crud.app.dao.BookDAO;
import crud.app.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String bookInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.show(id));
        return "library/bookInfo";
    }

    @PatchMapping("/{id}")
    public String editBook(@ModelAttribute("book") Book book, @PathVariable("/{id}}") int id) {
        bookDAO.update(id, book);
        return "redirect:/library";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/library";
    }

}
