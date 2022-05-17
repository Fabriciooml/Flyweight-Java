import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UrnaTest {

    @BeforeEach
    void setUp() {
        CandidatoFactory.getInstance().zerarLista();
    }

    @Test
    void deveRetornarListaVazia() {

        Urna urna = new Urna();
        List<String> saida = new ArrayList<>();

        assertEquals(saida, urna.obterVotos());
    }

    @Test
    void deveRetornarListaUmItem() {

        Urna urna = new Urna();
        urna.votar("Joao", "Jose", 10);

        List<String> saida = Arrays.asList(
                "Voto{eleitor='Joao', candidato='Jose', numero_candidato=10}"
        );

        assertEquals(saida, urna.obterVotos());
    }

    @Test
    void deveRetornarVotos() {

        Urna urna = new Urna();
        urna.votar("Joao", "Jose", 10);
        urna.votar("Julio", "Jorge", 50);
        urna.votar("Joana", "Jose", 10);
        urna.votar("Júlia", "Jose", 10);

        List<String> saida = Arrays.asList(
                "Voto{eleitor='Joao', candidato='Jose', numero_candidato=10}",
                "Voto{eleitor='Julio', candidato='Jorge', numero_candidato=50}",
                "Voto{eleitor='Joana', candidato='Jose', numero_candidato=10}",
                "Voto{eleitor='Júlia', candidato='Jose', numero_candidato=10}"
        );

        assertEquals(saida, urna.obterVotos());
    }

    @Test
    void deveRetornarNenhumVoto() {
        Urna urna = new Urna();

        assertEquals(0, CandidatoFactory.getInstance().getTotalCandidatos());
    }

    @Test
    void deveRetornarUmVoto() {
        Urna urna = new Urna();
        urna.votar("Joao", "Jose", 10);
        urna.votar("Joana", "Jose", 10);
        urna.votar("Júlia", "Jose", 10);

        assertEquals(1, CandidatoFactory.getInstance().getTotalCandidatos());
    }

    @Test
    void deveRetornarTotalVotos() {
        Urna urna = new Urna();
        urna.votar("Joao", "Jose", 10);
        urna.votar("Julio", "Jorge", 50);
        urna.votar("Joana", "Jose", 10);
        urna.votar("Júlia", "Jose", 10);
        urna.votar("Joane", "Jorge", 50);
        urna.votar("Marlon", "Marcos", 100);

        assertEquals(3, CandidatoFactory.getInstance().getTotalCandidatos());
    }
}
