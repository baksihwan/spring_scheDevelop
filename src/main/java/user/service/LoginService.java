package user.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    //로그인
    public void login(String email, String password) {
        // 입력받은 email & 비밀번호와 일치하는 Database 조회
        User user = userRepository.findByEmailOrElseThrow(email);

        //password 일치하지 않으면 true
        if(!user.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");
        }//if
    }//login


}//end class