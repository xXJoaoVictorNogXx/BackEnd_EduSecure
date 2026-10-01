package backedusecure.demo.dto.request;

import org.hibernate.query.SelectionQuery;
import org.w3c.dom.stylesheets.LinkStyle;

import java.time.LocalDateTime;
import java.util.List;

public record ProvaRequestDTO(String titulo, String disciplina, List<QuestaoRequestDTO> questoes, LocalDateTime dataCriacao) {


}
