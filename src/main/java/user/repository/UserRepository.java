package user.repository;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    //조회
    Optional<User> findUserByUsername(String username);
    //username 없을 경우 예외처리
    default User findMemberByUsernameOrElseThrow(String username) {
        return findUserByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자가 존재하지 않습니다." + username));
    }//findMemberByUsernameOrElseThrow

    //로그인
    Optional<User> findByEmail(String email);
    //email 일치하지 않을 경우 예외처리
    default User findByEmailOrElseThrow(String email){
        return findByEmail(email).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "이메일이 일치하지 않습니다."));
    }//findByEmailOrElseThrow
}//end interface