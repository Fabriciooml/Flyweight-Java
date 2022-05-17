import java.util.HashMap;
import java.util.Map;

public class CandidatoFactory {

    private static CandidatoFactory instance = new CandidatoFactory();

    private Map<Integer, Candidato> candidatos;


    private CandidatoFactory() {
        candidatos = new HashMap<>();
    };

    public static CandidatoFactory getInstance() {
        return instance;
    }


    public Candidato getCandidato(Integer numero, String nome) {
        Candidato candidato = candidatos.get(numero);
        if (candidato == null) {
            candidato = new Candidato(nome, numero);
            candidatos.put(numero, candidato);
        }
        return candidato;
    }

    public Integer getTotalCandidatos() {
        return candidatos.size();
    }

    public void zerarLista() {
        candidatos.clear();
    }
}
