package team34.tarot.service;

import java.time.LocalDate;
import org.springframework.stereotype.Service;

@Service
public class PromptService {


	//사람 입력 프롬프트 함수 (스트링 반환)
	public String systemChatUserInputPromptStr(String nickname, String gender, int age) {
		return String.format(
						"You will act as an expert Tarot Card reader. A tarot customer is a person with name: %s, gender: %s, and age range: %d. As a tarot reader, you need to understand the personality of your tarot customer and answer them to the best of your ability. \nFinally, all questions are written in PlainTEXT only. Don't use any markdown syntax.",
						nickname, gender, age);
	}

	public String systemDiaryCarefulInputPromptStr(LocalDate date, String nickname) {
		return String.format(
						"Today is %s. In tarot readings and diaries, the date is an important element. Always check it.\n\nWhen you incorporate your [diary] into a tarot reading, you should do so in date order. The further away from today, the lower the percentage in tarot reading.\n\nWhen interpreting tarot readings based on a [diary] that yields similar results, it is important not to overlook the events experienced by %s.",
						date.toString(), nickname);

	}

	public String systemDiaryInputPromtStr(String nickname, String content, String gender, LocalDate date) {
		return String.format(
						"The following is a [diary] written on %s by %s. Analyze the contents of the [diary] to remember how %s was feeling and what %s was going through, which you must then incorporate into your tarot reading. [diary] = \"%s\"",
						date.toString(), nickname, nickname, gender, content);
	}

	public String userTomorrowFortuneInputPromptStr(String nickname, String cardName, String description) {
		return String.format("Interpret tomorrow's fortune card in the following order\n" +
										"1. Based on the [card name] and [description] below, interpret tomorrow's horoscope, taking into account the personality of %s as you know it from the [diaries] you've received so far.\n2. Write about overall interpretation in depth and with care.\n"
										+ "[card name] = \"%s\"\n[description] = \"%s\"",
						nickname, cardName, description);
	}


	public String userSummaryInputPromptStr(String username) {
		return String.format(
						"Reduce your interpretation to 500 characters, focusing on %s's personal experiences and personality.",
						username);
	}

	public String userAnswerForQuestion(String nickname, String question, String cardName1, String description1,
					String cardName2, String description2, String cardName3, String description3) {
		return String.format("Interpret tarot cards in the following order\n"
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
