package crud.app.controllers;

import crud.app.models.Book;
import crud.app.models.Member;
import crud.app.repositories.BookRepository;
import crud.app.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/books")
public class BookController {

    private final BookService bookService;
    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping()
    public String bookList(Model model) {
        model.addAttribute("bookList", bookService.findAll());
        return "library/book/list";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model, @ModelAttribute("member") Member member) {
        model.addAttribute("book", bookService.findById(id));

        Member bookOwner = bookService.getBookOwner(id);

        if (bookOwner != null)
            model.addAttribute("owner", bookOwner);
        else
            model.addAttribute("memberList", bookService.findAll());

        return "library/book/info";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", bookService.findById(id));
        return "library/book/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") @Valid Book book, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        book.setId(id);

        if (bindingResult.hasErrors())
            return "/library/book/edit";

        bookService.save(book);
        return "redirect:/library/books";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") Book book) {
        return "library/book/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") @Valid Book book,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "/library/book/new";

        bookService.save(book);
        return "redirect:/library/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        bookService.delete(id);
        return "redirect:/library/books";
    }

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int id) {
        bookService.release(id);
        return "redirect:/library/books/" + id;
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("member") Member selectedMember) {
        bookService.assign(id, selectedMember);
        return "redirect:/library/books/" + id;
    }

}
