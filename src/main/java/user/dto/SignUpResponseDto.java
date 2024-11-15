package user.dto;

import lombok.Getter;

//회원가입 api
//Response 요청
@Getter
public class SignUpResponseDto {
    private final Long id;//사용자 id
    private final String username;//사용자 이름
    private final String email;//사용자 이메일

    //생성자
    public SignUpResponseDto(Long id, String username, String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }//SignUpResponseDto
}//end class