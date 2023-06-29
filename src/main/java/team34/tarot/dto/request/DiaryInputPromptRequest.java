package team34.tarot.dto.request;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DiaryInputPromptRequest {
    String content;
    LocalDateTime createdAt;
    String nickname;
    String gender;
}
