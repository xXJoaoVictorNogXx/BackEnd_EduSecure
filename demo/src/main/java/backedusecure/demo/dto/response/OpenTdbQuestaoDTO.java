package backedusecure.demo.dto.response;


import java.util.List;
import java.util.UUID;

public record OpenTdbQuestaoDTO(UUID idQuestao, String type, String difficulty, String category, String question, String correct_answer, List<String> incorrect_answers) {
}
