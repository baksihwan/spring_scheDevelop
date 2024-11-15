package user.dto;

import lombok.Getter;

//사용자 조회
@Getter
public class UserResponseDto {
    private final String username;//사용자 이름
    private final String email;//사용자 이메일

    //생성자
    public UserResponseDto(String username, String email) {
        this.username = username;
        this.email = email;
    }//MemberResponseDto
}//end class