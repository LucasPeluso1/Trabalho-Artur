package Entidades;

public class CD extends Disco {
	 private int numeroFaixas;

	    public CD(String titulo, String artista, int anoLancamento, int numeroFaixas) {
	        super(titulo, artista, anoLancamento);
	        this.numeroFaixas = numeroFaixas;
	    }

	    public int getNumeroFaixas() {
	        return numeroFaixas;
	    }

	    public void setNumeroFaixas(int numeroFaixas) {
	        this.numeroFaixas = numeroFaixas;
	    }

	    @Override
	    public String toString() {
	        return super.toString() + ", Número de Faixas: " + numeroFaixas;
	    }
	}
