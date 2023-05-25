package crud.app.controllers;

import crud.app.dao.MemberDAO;
import crud.app.models.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/library/members")
public class MemberController {

    private final MemberDAO memberDAO;
//    private final PersonValidator personValidator;

    public MemberController(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @GetMapping()
    public String listMember(Model model) {
        model.addAttribute("memberList", memberDAO.listMember());
        return "library/member/list";
    }

    @GetMapping("/{id}")
    public String info(@PathVariable("id") int id, Model model) {
        model.addAttribute("member", memberDAO.info(id));
        return "library/member/info";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("member", memberDAO.info(id));
        return "library/member/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("member") Member member, @PathVariable("id") int id) {
        memberDAO.update(id, member);
        return "redirect:/library/members";
    }

    @GetMapping("/new")
    public String newMember(@ModelAttribute("member") Member member) {
        return "library/member/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("member") Member member) {
        memberDAO.create(member);
        return "redirect:/library/members";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        memberDAO.delete(id);
        return "redirect:/library/members";
    }

}
