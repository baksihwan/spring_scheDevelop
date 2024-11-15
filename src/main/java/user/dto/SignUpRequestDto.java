package user.dto;

import lombok.Getter;

//회원가입 api
//Request 요청
@Getter
public class SignUpRequestDto {
    private final String username;//사용자 이름
    private final String password;//사용자 비밀번호
    private final String email;//사용자 이메일

    //생성자
    public SignUpRequestDto(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }//SignUpRequestDto
}//end class