package Schedule.dto;

import lombok.Getter;
//게시글 생성
@Getter
public class CreateScheduleRequestDto {
    private String title; //일정 제목
    private String content; //일정 내용
    private String usernname; // 사용자 이름

    //생성자
    public CreateScheduleRequestDto(String title, String content, String usernname) {
        this.title = title;
        this.content = content;
        this.usernname = usernname;
    }
}
