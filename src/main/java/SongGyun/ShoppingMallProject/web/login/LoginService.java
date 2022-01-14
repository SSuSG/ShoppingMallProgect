package SongGyun.ShoppingMallProject.web.login;

import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberRepository memberRepository;

    public Member login(String loingId , String password){
        return memberRepository.findByLoginId(loingId)
                .filter(m -> m.getPassword().equals(password))
                .orElse(null);
    }

}
