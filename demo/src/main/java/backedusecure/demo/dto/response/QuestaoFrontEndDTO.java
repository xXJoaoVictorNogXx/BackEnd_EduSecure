package backedusecure.demo.dto.response;

import backedusecure.demo.enums.CategoriaQuestoes;
import backedusecure.demo.model.Alternativa;

import java.util.List;
import java.util.UUID;

public record QuestaoFrontEndDTO(String idQuestao, CategoriaQuestoes categoria, String dificuldade, String enunciado, List<String> alternativas) {



}
