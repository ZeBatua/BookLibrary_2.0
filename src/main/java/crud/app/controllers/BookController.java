package crud.app.controllers;

import crud.app.dao.BookDAO;
import crud.app.dao.MemberDAO;
import crud.app.models.Book;
import crud.app.models.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/library/books")
public class BookController {

    private final BookDAO bookDAO;
    private final MemberDAO memberDAO;
//    private final PersonValidator personValidator;


    public BookController(BookDAO bookDAO, MemberDAO memberDAO) {
        this.bookDAO = bookDAO;
        this.memberDAO = memberDAO;
    }

    @GetMapping()
    public String bookList(Model model) {
        model.addAttribute("bookList", bookDAO.listBook());
        return "library/book/list";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model, @ModelAttribute("member") Member member) {
        model.addAttribute("book", bookDAO.info(id));

        Optional<Member> bookOwner = bookDAO.getBookOwner(id);

        if (bookOwner.isPresent())
            model.addAttribute("owner", bookOwner.get());
        else
            model.addAttribute("memberList", memberDAO.listMember());

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
        return "redirect:/library/books";
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

    @PatchMapping("/{id}/release")
    public String release(@PathVariable("id") int book_id) {
        bookDAO.release(book_id);
        return "redirect:/library/books/" + book_id;
    }

    @PatchMapping("/{id}/assign")
    public String assign(@PathVariable("id") int id, @ModelAttribute("member") Member selectedMember) {
        bookDAO.assign(id, selectedMember);
        return "redirect:/library/books/" + id;
    }

}
