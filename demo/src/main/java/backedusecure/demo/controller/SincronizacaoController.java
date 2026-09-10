package backedusecure.demo.controller;

import backedusecure.demo.dto.request.SincronizacaoRequestDTO;
import backedusecure.demo.service.SincronizacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sincronizacao")
@RequiredArgsConstructor
public class SincronizacaoController {

    private final SincronizacaoService sincronizacaoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SincronizacaoRequestDTO request) {
        sincronizacaoService.processarSincronizacao(request);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRegrasDeNegocio(RuntimeException ex) {
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
}
