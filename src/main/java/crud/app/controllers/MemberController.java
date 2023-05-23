package crud.app.controllers;

import crud.app.dao.MemberDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberDAO memberDAO;
//    private final PersonValidator personValidator;

    public MemberController(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @GetMapping
    public String index(Model model) {
        model.addAttribute("memberList", memberDAO.index());
        return "library/memberPage";
    }

    @GetMapping("/{id}")
    public String memberInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("member", memberDAO.show(id));
        return "library/memberInfo";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        memberDAO.delete(id);
        return "redirect:/members";
    }



}
