package backedusecure.demo.service;

import backedusecure.demo.dto.ProvaRequestDTO;
import backedusecure.demo.dto.ProvaResponseDTO;
import backedusecure.demo.model.Prova;
import backedusecure.demo.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository repository;


    public ProvaResponseDTO criarProva(ProvaRequestDTO request) {
        // 1. Converte DTO para Entidade
        Prova novaprova = new Prova();
        novaprova.setTitulo(request.titulo());
        novaprova.setDisciplina(request.disciplina());
        novaprova.setDataCriacao(request.dataCriacao());

        // 2. Salva no banco (Repository)
        Prova provaSalva = repository.save(novaprova);

        // 3. Converte Entidade salva para DTO de Resposta
        return new ProvaResponseDTO(
                provaSalva.getId(),
                provaSalva.getTitulo(),
                provaSalva.getDisciplina(),
                provaSalva.getDataCriacao()
        );
    }
}
