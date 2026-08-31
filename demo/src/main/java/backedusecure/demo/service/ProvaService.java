package backedusecure.demo.service;

import backedusecure.demo.dto.RequestDTO.ProvaRequestDTO;
import backedusecure.demo.dto.ResponseDTO.ProvaResponseDTO;
import backedusecure.demo.mappers.ProvaMapper;
import backedusecure.demo.model.Prova;
import backedusecure.demo.repository.ProvaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository repository;

    @Autowired
    private ProvaMapper mapper;

    public ProvaResponseDTO criarProva(ProvaRequestDTO request) {
        // 1. Mapper cuida da conversão de entrada
        Prova novaProva = mapper.toEntity(request);

        // 2. Service executa função principal
        Prova provaSalva = repository.save(novaProva);

        // 3. Mapper cuida da conversão de saída
        return mapper.toResponseDTO(provaSalva);
    }
}
