public class PedeNaUni {
    private String nome;
    private int calorias;
    private String link;
    private Avaliacao[] avaliacoes;
    private int qtdAvaliacoes;

    public PedeNaUni(String nome, int calorias, String link) {
        this.nome = nome;
        this.calorias = calorias;
        this.link = link;
        this.qtdAvaliacoes = 5;
        avaliacoes = new Avaliacao[qtdAvaliacoes];

    }

    public PedeNaUni(String alimento, int calorias) {
        this.nome = alimento;
        this.calorias = calorias;
        this.link = "https://";
    }

    @Override
    public String toString() {
        String refeicao = this.nome + " - " + this.calorias + "calorias/porção - " + this.link;
        return refeicao;
    }

    public void avaliacao(int nota, String comentario) {
        Avaliacao avaliacao = new Avaliacao(nota, comentario);
        insereAvaliacao(avaliacao);
    }

    private void insereAvaliacao(Avaliacao avaliacao) {
        for (int i = 0; i < this.avaliacoes.length; i++) {
            if(this.avaliacoes[i] == null) {
                this.avaliacoes[i] = avaliacao;
                return;
            }
        }
        for (int w = avaliacoes.length -1; w < this.avaliacoes.length;) {
            this.avaliacoes[w + 1] = this.avaliacoes[w];
            if(w == 1) {
                this.avaliacoes[1] = avaliacao;
                return;
            }
            w -= 1;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public int getCalorias() {
        return this.calorias;
    }

    public int calculaMedia() {
        int media = 0;
        for (int i = 0; i < this.avaliacoes.length; i++) {
            if(this.avaliacoes[i] != null) {
                media += this.avaliacoes[i].getNota();
            }
        }
        return media/qtdAvaliacoes;
    }


}