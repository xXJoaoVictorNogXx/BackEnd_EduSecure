package backedusecure.demo.service;

import backedusecure.demo.dto.request.ProvaRequestDTO;
import backedusecure.demo.dto.response.ProvaResponseDTO;
import backedusecure.demo.mappers.ProvaMapper;
import backedusecure.demo.model.Prova;
import backedusecure.demo.repository.ProvaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor //O lombok, por meio desta anotação, vai gerar automaticamente o construtor das variáveis abaixo
public class ProvaService {


    private final ProvaRepository repository;


    private final ProvaMapper mapper;

    public ProvaResponseDTO criarProva(ProvaRequestDTO request) {
        // 1. Mapper cuida da conversão de entrada
        Prova novaProva = mapper.toEntity(request);

        // 2. Service executa função principal
        Prova provaSalva = repository.save(novaProva);

        // 3. Mapper cuida da conversão de saída
        return mapper.toResponseDTO(provaSalva);
    }
}
