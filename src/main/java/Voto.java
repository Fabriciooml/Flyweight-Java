public class Voto {

    private String eleitor;
    private Candidato candidato;

    public Voto(String eleitor, Candidato candidato) {
        this.eleitor = eleitor;
        this.candidato = candidato;
    }

    @Override
    public String toString() {
        return "Voto{" +
                "eleitor='" + eleitor + '\'' +
                ", candidato='" + candidato.getNome() + '\'' +
                ", numero_candidato=" + candidato.getNumero() +
                '}';
    }
}
