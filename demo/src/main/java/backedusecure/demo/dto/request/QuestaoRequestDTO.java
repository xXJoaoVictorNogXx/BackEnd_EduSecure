package backedusecure.demo.dto.request;


import java.util.List;

public record QuestaoRequestDTO(
        String idQuestao,      // O ID que veio do OpenTDB (se existir)
        String categoria,
        String dificuldade,
        String enunciado,
        List<String> alternativas
) {}
