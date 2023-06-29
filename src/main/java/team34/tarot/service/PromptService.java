package team34.tarot.service;

import org.springframework.stereotype.Service;
import team34.tarot.dto.request.DiaryInputPromptRequest;
import team34.tarot.dto.request.UserInputPromptRequest;

@Service
public class PromptService {


	//사람 입력 프롬프트 함수 (스트링 반환)
	public String systemChatUserInput(UserInputPromptRequest request) {
		String s = "+, gender: " + request.getGender() + ", and age range: " + request.getAge()
						+ ". As a tarot reader, you need to understand the personality of your tarot customer and answer them to the best of your ability.Finally, all questions are written in PlainTEXT only. Don't use any markdown syntax.";
		return s;
	}

	public String systemDiaryInput(DiaryInputPromptRequest request) {
		String str = "The following is a [diary] written on " + request.getCreatedAt() + " by " + request.getNickname()
						+ ". Analyze the contents of the [diary] to remember how " + request.getNickname() + "was feeling and what "
						+ request.getGender() + "was going through, which you must then incorporate into your tarot reading.\n" +
						"[diary] = " + request.getContent();
		return str;
	}

	public String userAnswerForQuestion(String nickname, String question, String cardName1, String description1,
					String cardName2, String description2, String cardName3, String description3) {
		return String.format("Interpret tomorrow's fortune card in the following order\n"
						+ "1. Understand the [question] at the bottom\n"
						+ "2. Based on the [card names] and [descriptions] below, interpret the cards you chose according to the question in order, considering the nature of the %s you know from the [diaries] you have received so far.\n"
						+ "3. Write about overall interpretation in depth and with care.\n"
						+ "\n"
						+ "[question] = \n"
						+ "\"\n"
						+ "%s\"\n"
						+ "\n"
						+ "[card names] : { card1 = \"%s\", card2 = \"%s\", card3 = \"%s\"}\n"
						+ "[descriptions] = {\n"
						+ "card1 = \n"
						+ "\"\n"
						+ "%s\n"
						+ "\",\n"
						+ "card2 =\n"
						+ "\" \n"
						+ "%s\n"
						+ "\",\n"
						+ "card3=\n"
						+ "\"\n"
						+ "%s\n"
						+ "\"\n"
						+ "}", nickname, question, cardName1, cardName2, cardName3, description1, description2, description3);
	}

	public String userGetOverAll() {
		return "Print only the overall interpretation.";
	}

	public String userTranslation() {
		return "Similar in length, please do your best to translate into Korean without changing the original meaning.\n"
						+ "\n"
						+ "Make the translation result natural.";
	}
}
