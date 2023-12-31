package AFK.AFK.Community.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class CommunityDto {
    private Long userId;
    private Long postId;
    private LocalDateTime createdAt;
    private String writer;
    private String title;
    private String content;
    private String imageUrl;
}