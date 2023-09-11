package AFK.AFK.Settings.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@Data
public class Ask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;                // 데이터 증가에 따른 자동적 id 배정 수 증가를 위해 'AUTO_INCREMENT'(AI) 체크 필수
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Boolean is_checked;     // Boolean 값은 0 or 1로 받아올 것

//    @Builder
//    public Ask (String title, String content, String email, Boolean is_checked) {
//        this.title = title;
//        this.content = content;
//        this.email = email;
//        this.is_checked = is_checked;       // 기존에 정한 'check' 변수는 예약어로 원래 사용 불가(mysql db 내 대문자 처리도 불가)
//    }

}
