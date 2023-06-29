package team34.tarot.service;

import com.theokanning.openai.completion.chat.ChatCompletionResult;
import org.springframework.stereotype.Service;
import team34.tarot.dto.request.DiaryInputPromptRequest;
import team34.tarot.dto.request.UserInputPromptRequest;

@Service
public class PromptService {


    //사람 입력 프롬프트 함수 (스트링 반환)
    public String systemChatUserInput(UserInputPromptRequest request) {
        String s = "+, gender: " + request.getGender() + ", and age range: " + request.getAge() + ". As a tarot reader, you need to understand the personality of your tarot customer and answer them to the best of your ability.Finally, all questions are written in PlainTEXT only. Don't use any markdown syntax.";
        return s;
    }

    public String systemDiaryInput(DiaryInputPromptRequest request) {
        String str = "The following is a [diary] written on "+request.getCreatedAt()+" by "+request.getNickname()+". Analyze the contents of the [diary] to remember how "+request.getNickname() +"was feeling and what "+request.getGender() +"was going through, which you must then incorporate into your tarot reading.\n" +
                "[diary] = "+request.getContent();
    }

}
