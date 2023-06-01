package crud.app.controllers;

import crud.app.dao.MemberDAO;
import crud.app.models.Member;
import crud.app.util.MemberValidator;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/members")
public class MemberController {

    private final MemberDAO memberDAO;
    private final MemberValidator memberValidator;

    public MemberController(MemberDAO memberDAO, MemberValidator memberValidator) {
        this.memberDAO = memberDAO;
        this.memberValidator = memberValidator;
    }

    @GetMapping()
    public String memberList(Model model) {
        model.addAttribute("memberList", memberDAO.listMember());
        return "library/member/list";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model) {
        model.addAttribute("member", memberDAO.info(id));
        model.addAttribute("books", memberDAO.getBooksByPersonId(id));
        return "library/member/info";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable("id") int id, Model model) {
        model.addAttribute("member", memberDAO.info(id));
        return "library/member/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("member") @Valid Member member, BindingResult bindingResult,
                         @PathVariable("id") int id) {
        member.setMember_id(id);

        if (bindingResult.hasErrors())
            return "/library/member/edit";

        memberDAO.update(id, member);
        return "redirect:/library/members";
    }

    @GetMapping("/new")
    public String newMember(@ModelAttribute("member") Member member) {
        return "library/member/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("member") @Valid Member member,
                         BindingResult bindingResult) {
        memberValidator.validate(member, bindingResult);

        if (bindingResult.hasErrors())
            return "library/member/new";

        memberDAO.create(member);
        return "redirect:/library/members";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        memberDAO.delete(id);
        return "redirect:/library/members";
    }

}
