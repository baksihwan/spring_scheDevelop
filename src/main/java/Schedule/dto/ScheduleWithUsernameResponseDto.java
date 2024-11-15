package Schedule.dto;

import lombok.Getter;
//응답에 유저 이름 포함
@Getter
public class ScheduleWithUsernameResponseDto {
    private final String title;
    private final String contents;
    private final String username;

    public ScheduleWithUsernameResponseDto(String title, String contents, String username) {
        this.title = title;
        this.contents = contents;
        this.username = username;
    }//ScheduleWithUsernameResponseDto
}
