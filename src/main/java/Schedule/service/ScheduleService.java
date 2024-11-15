package Schedule.service;

import Schedule.dto.ScheduleResponseDto;
import Schedule.dto.ScheduleWithUsernameResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import Schedule.repository.ScheduleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final UserRepository userRepository;
    private final ScheduleRepository scheduleRepository;

    //일정 생성
    public ScheduleResponseDto save(String title, String contents, String username) {

        //유저 조회 가능
        User findUser = userRepository.findMemberByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title, contents);
        schedule.setUser(findUser);//멤버를 조회해서 참조

        //Schedule 일정 저장하기
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTitle(), savedSchedule.getContents());
    }//save

    //일정 전체 조회
    public List<ScheduleResponseDto> findAllSchedule() {
        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }//findAllSchedule

    //일정 ID로 특정 일정 조회
    public ScheduleWithUsernameResponseDto findScheduleById(Long id) {
        Schedule findSchedule = scheduleRepository.findScheduleByIdOrElseThrow(id);
        User writer = findSchedule.getUser();

        return new ScheduleWithUsernameResponseDto(findSchedule.getTitle(), findSchedule.getContents(), writer.getUsername());
    }//findScheduleById

    //일정 ID로 특정 일정 삭제
    public void deleteSchedule(Long id) {
        Schedule findSchedule = scheduleRepository.findScheduleByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }//deleteSchedule
}//end class