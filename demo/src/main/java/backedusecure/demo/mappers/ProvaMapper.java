package backedusecure.demo.mappers;

import backedusecure.demo.dto.request.ProvaRequestDTO;
import backedusecure.demo.dto.response.ProvaResponseDTO;
import backedusecure.demo.model.Prova;
import org.springframework.stereotype.Component;

@Component //Transforma a classe em um componente Spring
public class ProvaMapper {
    // 1. Converte DTO para Entidade
    public Prova toEntity(ProvaRequestDTO request) {
    Prova prova = new Prova();
        prova.setTitulo(request.titulo());
        prova.setDisciplina(request.disciplina());
        prova.setDataCriacao(request.dataCriacao());
        return prova;
    }

    // 3. Converte Entidade salva para DTO de Resposta
       public ProvaResponseDTO toResponseDTO(Prova prova) {
           if(prova == null) return null;

           return new ProvaResponseDTO(
                    prova.getIdProva(),
                    prova.getTitulo(),
                    prova.getDisciplina(),
                    prova.getDataCriacao()
           );
       }
}
