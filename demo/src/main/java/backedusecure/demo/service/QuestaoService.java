package backedusecure.demo.service;

import backedusecure.demo.dto.response.OpenTdbQuestaoDTO;
import backedusecure.demo.dto.response.OpenTdbResponseWrapper;
import backedusecure.demo.dto.response.QuestaoFrontEndDTO;
import backedusecure.demo.enums.CategoriaQuestoes;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.*;

@Service
@RequiredArgsConstructor
public class QuestaoService {

    private final RestClient restClient;

    @Transactional
    public List<QuestaoFrontEndDTO> buscarEFormatarQuestoes(int quantidade) {

        OpenTdbResponseWrapper respostaApi = restClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("amount", quantidade)
                        .queryParam("encode", "base64")
                        .build())
                .retrieve()
                .body(OpenTdbResponseWrapper.class);

        List<OpenTdbQuestaoDTO> listaOriginal = respostaApi.results();

        List<QuestaoFrontEndDTO> listaRetorno = new ArrayList<>();
        Base64.Decoder decoder = Base64.getDecoder();

        for(OpenTdbQuestaoDTO dto : listaOriginal) {
            String enunciadoLimpo = new String(decoder.decode(dto.question()));
            String dificuldadeLimpa = new String(decoder.decode(dto.difficulty()));

            String respostaCerta = new String(decoder.decode(dto.correct_answer()));

            String tipoDecodificado = new String(decoder.decode(dto.type()));

            CategoriaQuestoes tipoEnum = CategoriaQuestoes.fromString(tipoDecodificado);

            List<String> alternativas = new ArrayList<>();
            alternativas.add(respostaCerta);

            for(String erradaBase64 : dto.incorrect_answers()){
                String erradaLimpa = new String(decoder.decode(erradaBase64));
                alternativas.add(erradaLimpa);
            }

            Collections.shuffle(alternativas);

            String idGerado = UUID.randomUUID().toString();

            QuestaoFrontEndDTO questaoPronta = new QuestaoFrontEndDTO(
                    idGerado,
                    tipoEnum,
                    dificuldadeLimpa,
                    enunciadoLimpo,
                    alternativas
            );

            listaRetorno.add(questaoPronta);
        }
        return listaRetorno;
    }

}
