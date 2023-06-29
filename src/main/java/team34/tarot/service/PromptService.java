package team34.tarot.service;

import com.theokanning.openai.completion.chat.ChatCompletionResult;
import org.springframework.stereotype.Service;
import team34.tarot.dto.request.DiaryInputPromptRequest;
import team34.tarot.dto.request.UserInputPromptRequest;

import java.time.LocalDateTime;

@Service
public class PromptService {


    //사람 입력 프롬프트 함수 (스트링 반환)
    public String systemChatUserInputPromptStr(String nickname, String gender, int age) {
        return String.format("You will act as an expert Tarot Card reader. A tarot customer is a person with name: %s, gender: %s, and age range: %d. As a tarot reader, you need to understand the personality of your tarot customer and answer them to the best of your ability. \nFinally, all questions are written in PlainTEXT only. Don't use any markdown syntax.",
                nickname, gender, age);
    }

    public String systemDiaryInputPromtStr(String nickname, String content, String gender, LocalDateTime date) {
        return String.format("The following is a [diary] written on %s by %s. Analyze the contents of the [diary] to remember how %s was feeling and what %s was going through, which you must then incorporate into your tarot reading. [diary] = %s",
                date, nickname, nickname, gender);
    }

    public String userTomorrowFortuneInputPromptStr(String nickname, String cardName, String description) {
        return String.format("Interpret tomorrow's fortune card in the following order\n" +
                "1. Based on the [card name] and [description] below, interpret tomorrow's horoscope, taking into account the personality of %s as you know it from the [diaries] you've received so far.\n2. Write about overall interpretation in depth and with care.\n[card name] = %s\n[description] = %s",
                nickname, cardName, description);
    }

    public String userSummaryInputPromptStr(String username) {
        return String.format("Reduce your interpretation to 500 characters, focusing on %s's personal experiences and personality.",
                username);
    }
}
