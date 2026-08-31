package backedusecure.demo.controller;


import backedusecure.demo.dto.ProvaRequestDTO;
import backedusecure.demo.dto.ProvaResponseDTO;
import backedusecure.demo.service.ProvaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController //Diz ao Spring que as respostas dos métodos devem ser enviadas diretamente no corpo da resposta HTTP
@RequestMapping("/api/provas") //Define o caminho (rota) principal. Qualquer requisição para esta classe começará com "/api/provas"
public class ProvaController {

    @Autowired
    private ProvaService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProvaResponseDTO create(@RequestBody ProvaRequestDTO request){
        return service.criarProva(request);
    }
}
