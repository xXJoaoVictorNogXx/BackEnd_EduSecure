package backedusecure.demo.mappers;

import backedusecure.demo.dto.request.QuestaoRequestDTO;
import backedusecure.demo.dto.response.QuestaoFrontEndDTO;
import backedusecure.demo.model.Questao;
import org.springframework.stereotype.Component;

@Component // O Spring gerencia essa classe para você poder injetar no Service
public class QuestaoMapper {

    public Questao toEntity(QuestaoRequestDTO dto) {
        if (dto == null) return null;

        Questao questao = new Questao();
        questao.setEnunciado(dto.enunciado());
        questao.setDificuldade(dto.enunciado());


        return questao;
    }

    public QuestaoFrontEndDTO toResponseDTO(Questao entity) {
        if (entity == null) return null;

        return new QuestaoFrontEndDTO(
                entity.getIdQuestao().toString(),
                entity.getCategoria(),
                entity.getDificuldade(),
                entity.getEnunciado(),
                entity.getAlternativas().stream()
                        .map(alternativa -> alternativa.getTexto())
                        .toList()
        );


    }
}
