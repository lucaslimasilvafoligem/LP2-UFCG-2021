public class CardapioVirtual {
    private PedeNaUni[] comidas;
    private int qtdComidas;

    public void CardapioVirtua() {
        qtdComidas = 5;
        comidas = new PedeNaUni[qtdComidas];
    }

    public void adicionaAlimento(String alimento, int calorias, String link) {
        PedeNaUni oAlimento = new PedeNaUni(alimento, calorias, link);
        for (int i = 0; i < comidas.length; i++) {
            if(comidas[i] == null) {
                comidas[i] = oAlimento;;
                return;
            }
        }
    }

    public void adicionaAlimento(String alimento, int calorias) {
        PedeNaUni oAlimento = new PedeNaUni(alimento, calorias);
        for (int i = 0; i < comidas.length; i++) {
            if(this.comidas[i] == null) {
                this.comidas[i] = oAlimento;;
                return;
            }
        }
    }

    public String listaCardapio() {
        String cardapio = "\n";
        for (int i = 0; i < this.comidas.length; i++) {
            if(this.comidas[i] != null) {
                cardapio += this.comidas[i].toString() + "\n";
            }
        }
        return cardapio;
    }

    public int calculaCalorias(String nomes[], int porcao) {
        int calorias = 0;
        for (int i = 0; i < nomes.length; i++) {
            if(nomes[i] != "") {
                for (int j = 0; j < this.comidas.length; j++) {
                    if(this.comidas[i] != null) {
                        if(nomes[i].equals(comidas[j].getNome())) {
                            calorias += this.comidas[j].getCalorias() * porcao;
                        }
                    }
                }
            }
        }
        return calorias;
    }

    public String recomendar(int nota) {
        String comidasRecomendadas = "";
        if(nota < 1 || nota > 5) {
            return "nota invalida";
        }
        for (int i = 0; i < this.comidas.length; i++) {
            if(this.comidas[i].calculaMedia() >= nota) {
                comidasRecomendadas += this.comidas[i].toString() + "\n";
            }
        }
        return comidasRecomendadas;
    }
}
