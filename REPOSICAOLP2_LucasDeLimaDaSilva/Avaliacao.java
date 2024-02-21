public class Avaliacao {
    private int nota;
    private String comentario;

    public Avaliacao(int nota, String comentario) {
        this.nota = nota;
        this.comentario = comentario;
    }

    public String getComentario() {
        return comentario;
    }
    
    public int getNota() {
        return nota;
    }
}
