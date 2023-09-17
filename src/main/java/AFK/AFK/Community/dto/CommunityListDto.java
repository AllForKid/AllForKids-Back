package AFK.AFK.Community.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommunityListDto {
    private String writer;
    private String title;
    private String content;
    private String imageUrl;
    private LocalDate createdAt;
}
