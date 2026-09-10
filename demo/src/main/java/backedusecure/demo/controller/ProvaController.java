package backedusecure.demo.controller;


import backedusecure.demo.dto.request.ProvaRequestDTO;
import backedusecure.demo.dto.response.ProvaResponseDTO;
import backedusecure.demo.service.ProvaService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController //Diz ao Spring que as respostas dos métodos devem ser enviadas diretamente no corpo da resposta HTTP
@RequestMapping("/api/provas") //Define o caminho (rota) principal. Qualquer requisição para esta classe começará com "/api/provas"
@RequiredArgsConstructor
public class ProvaController {

    private final ProvaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProvaResponseDTO create(@RequestBody ProvaRequestDTO request){
        return service.criarProva(request);
    }
}
