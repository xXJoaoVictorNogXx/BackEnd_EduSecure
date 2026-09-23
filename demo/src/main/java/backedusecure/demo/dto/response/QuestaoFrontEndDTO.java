package backedusecure.demo.dto.response;

import backedusecure.demo.enums.CategoriaQuestoes;

import java.util.List;

public record QuestaoFrontEndDTO(String idQuestao, CategoriaQuestoes categoria, String dificuldade, String enunciado, List<String> alternativas) {
}
