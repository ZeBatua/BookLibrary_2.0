package crud.app.services;

import crud.app.models.Member;
import crud.app.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;


@Service
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Member findOne(int id) {
        Optional<Member> foundMember = memberRepository.findById(id);
        return foundMember.orElse(null);
    }

    public Member findByEmail(String email) {
        Optional<Member> foundMember = memberRepository.findByEmail(email);
        return foundMember.orElse(null);
    }

    @Transactional
    public void save(Member person) {
        memberRepository.save(person);
    }

    @Transactional
    public void update(int id, Member updatedMember) {
        updatedMember.setId(id);
        memberRepository.save(updatedMember);
    }

    @Transactional
    public void delete(int id) {
        memberRepository.deleteById(id);
    }


}

//        memberRepository.setCreatedAt(new Date());
//        memberRepository.setStatus(Status.Working);