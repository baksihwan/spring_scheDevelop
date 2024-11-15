package user.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import user.dto.SignUpRequestDto;
import user.dto.SignUpResponseDto;
import user.dto.UserResponseDto;
import user.service.UserService;

@RestController
@RequestMapping("/users")//url 설정
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //사용자 생성(회원가입)
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto requestDto) {

        SignUpResponseDto signUpResponseDto =
                userService.signUp(
                        requestDto.getUsername(),
                        requestDto.getPassword(),
                        requestDto.getEmail()
                );

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);//성공하면 CREATED
    }//signUp

    //사용자 조회
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id) {

        UserResponseDto memberResponseDto = userService.findById(id);

        return new ResponseEntity<>(memberResponseDto, HttpStatus.OK);
    }//findById

}//end class