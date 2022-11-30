package kr.snack.study.assignment.service.member;

import kr.snack.study.assignment.controller.form.LoginForm;
import kr.snack.study.assignment.controller.form.RegisterForm;
import kr.snack.study.assignment.domain.entity.Member;
import kr.snack.study.assignment.exception.MemberNotFoundException;
import kr.snack.study.assignment.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(RegisterForm registerForm) {
        if (!memberRepository.existsById(registerForm.getId())) {
            Member member = Member.builder()
                    .id(registerForm.getId())
                    .name(registerForm.getName())
                    .password(passwordEncoder.encode(registerForm.getPassword()))
                    .build();

            memberRepository.save(member);
        } else {
            throw MemberNotFoundException.EXCEPTION;
        }
    }

    @Override
    public void login(LoginForm loginForm) {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getId(), loginForm.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}
