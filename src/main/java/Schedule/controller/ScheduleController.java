package Schedule.controller;

import Schedule.dto.CreateScheduleRequestDto;
import dto.ScheduleResponseDto;
import Schedule.dto.ScheduleWithUsernameResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import Schedule.service.ScheduleService;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    //일정 등록(저장)
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> save(@RequestBody CreateScheduleRequestDto requestDto){
        ScheduleResponseDto scheduleResponseDto =
                scheduleService.save(
                        requestDto.getTitle(),
                        requestDto.getContents(),
                        requestDto.getUsername()
                );
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    //일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedule(){
        List<scheduleResponseDto> scheduleResponseDtoList = scheduleService.findAllSchedule();

        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);

    }

    //일정 ID로 특정 일정 조회
    @GetMapping("/{id}")
    public ResponsEntity<ScheduleWithUsernameResponseDto> findScheduleById(@PathVariable Long id){
        ScheduleWithUsernameResponseDto scheduleWithUsernameResponseDto = scheduleService.findScheduleById(id);
        return new ResponseEntity<>(scheduleWithUsernameResponseDto, HttpStatus.OK);
    }

    //일정 ID로 특정 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        ScheduleService.deleteSchedule(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
