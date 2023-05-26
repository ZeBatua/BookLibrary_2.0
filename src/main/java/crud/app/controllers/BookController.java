package crud.app.controllers;

import crud.app.dao.BookDAO;
import crud.app.models.Book;
import crud.app.models.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/books")
public class BookController {

    private final BookDAO bookDAO;
//    private final PersonValidator personValidator;

    public BookController(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    @GetMapping()
    public String bookList(Model model) {
        model.addAttribute("bookList", bookDAO.listBook());
        return "library/book/list";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookDAO.info(id));
        return "library/book/info";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookDAO.info(id));
        return "library/book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") int id) {
        bookDAO.update(id, book);
        return "redirect:/library/members";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "library/book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") Book book) {
        bookDAO.create(book);
        return "redirect:/library/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookDAO.delete(id);
        return "redirect:/library/books";
    }

}
