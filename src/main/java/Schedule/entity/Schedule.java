package Schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.apache.catalina.User;

@Getter
@Entity
@Table(name = "schedule")
public class Schedule extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //일정 id

    @Column(length = 50, nullable = false)
    private String title; //일정 제목

    @Column(length = 200)
    private String contents;

    //연관관계 N:1
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    //생성자
    public Schedule(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }//Schedule
    public Schedule() {

    }
    //작성자 추가 메서드
    public void SetUser(User user) {
        this.user = user;
    }
}
