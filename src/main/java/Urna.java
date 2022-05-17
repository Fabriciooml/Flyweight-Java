import java.util.ArrayList;
import java.util.List;

public class Urna {
    private List<Voto> votos = new ArrayList<>();

    public void votar(String nomeEleitor, String nomeCandidato, Integer numeroCandidato) {
        Candidato candidato = CandidatoFactory.getInstance().getCandidato(numeroCandidato, nomeCandidato);
        Voto voto = new Voto(nomeEleitor, candidato);
        votos.add(voto);
    }

    public List<String> obterVotos() {
        List<String> votosToString = new ArrayList<String>();
        for (Voto voto: votos) {
            votosToString.add(voto.toString());
        }
        return votosToString;
    }
}
