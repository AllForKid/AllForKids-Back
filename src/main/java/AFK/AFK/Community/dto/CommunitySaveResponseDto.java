package AFK.AFK.Community.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class CommunitySaveResponseDto {
    @JsonProperty("isSuccess")
    private boolean isSuccess;
    private int code;
    private String message;
    private List<CommunitySaveDto> result;
}