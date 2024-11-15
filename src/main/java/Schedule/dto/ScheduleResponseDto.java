package Schedule.dto;


import lombok.Getter;

@Getter
public class ScheduleResponseDto {
    private final Long id;//일정 id
    private final String title;//일정 제목
    private final String contents;//일정 내용

    //일정 생성
    public ScheduleResponseDto(Long id, String title, String contents) {
        this.id = id;
        this.title = title;
        this.contents = contents;
    }//ScheduleResponseDto

    //일정 전체 조회
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTitle(), schedule.getContents());
    }//ScheduleResponseDto


}//end class