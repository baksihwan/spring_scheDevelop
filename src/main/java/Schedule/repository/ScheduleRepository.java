package Schedule.repository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.server.ResponseStatusException;
@Repository
public interface ScheduleRepository extends Repository<Schedule,Long> {

    //조회
    //일정 id가 없을 경우 예외처리
    default Schedule findScheduleByIdOrElseThrow(Long id) {
        return findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 일정이 없습니다." + id));
    }
}//findScheduleByIdOrElseThrow
