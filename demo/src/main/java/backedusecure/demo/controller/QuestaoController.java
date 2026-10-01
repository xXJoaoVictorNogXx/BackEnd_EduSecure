package backedusecure.demo.controller;

import backedusecure.demo.dto.response.QuestaoFrontEndDTO;
import backedusecure.demo.model.Questao;
import backedusecure.demo.service.QuestaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/questao")
@CrossOrigin(origins = "http://localhost:3000/") //Libera acesso para teste local
@RequiredArgsConstructor
public class QuestaoController {

    private final QuestaoService questaoService;

    @GetMapping("/questoes")
    public ResponseEntity<List<QuestaoFrontEndDTO>> listarQuestoesParaOPainel() {
        List<QuestaoFrontEndDTO> listaQuestoes = questaoService.buscarEFormatarQuestoes(10);
        return ResponseEntity.ok(listaQuestoes);
    };
}
