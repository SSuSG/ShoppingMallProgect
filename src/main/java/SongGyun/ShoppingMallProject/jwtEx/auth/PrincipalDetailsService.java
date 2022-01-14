package SongGyun.ShoppingMallProject.jwtEx.auth;
/*
import SongGyun.ShoppingMallProject.domain.Member;
import SongGyun.ShoppingMallProject.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PrincipalDetailsService implements UserDetailsService{

	private final MemberRepository memberRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("PrincipalDetailsService : 진입");
		System.out.println("username = " + username);
		Member member = memberRepository.findByUsername(username).get();

		System.out.println("PrincipalDetailsService = " + member);

		// session.setAttribute("loginUser", user);
		return new SongGyun.ShoppingMallProject.jwtEx.auth.PrincipalDetails(member);
	}
}

 */