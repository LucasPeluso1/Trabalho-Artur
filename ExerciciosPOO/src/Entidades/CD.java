package Entidades;

//Classe CD que herda da classe abstrata Disco
public class CD extends Disco {
	private int numeroFaixas;

	public CD(String titulo, String artista, int anoLancamento, int numeroFaixas) {
		 // Chama o construtor da classe pai (Disco)
		super(titulo, artista, anoLancamento);
		this.numeroFaixas = numeroFaixas;
	}

	public int getNumeroFaixas() {
		return numeroFaixas;
	}

	public void setNumeroFaixas(int numeroFaixas) {
		this.numeroFaixas = numeroFaixas;
	}
	 // Método toString que retorna uma representação em string do CD
	@Override
	public String toString() {
		// Chama o método toString da classe pai e adiciona o número de faixas
		return super.toString() + ", Número de Faixas: " + numeroFaixas;
	}
}
