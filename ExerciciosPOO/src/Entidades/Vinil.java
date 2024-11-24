package Entidades;
//Classe Vinil que herda da classe abstrata Disco
public class Vinil extends Disco {
	// Atributo específico do Vinil que armazena o diâmetro
	private double diametro;

	public Vinil(String titulo, String artista, int anoLancamento, double diametro) {
		 // Chama o construtor da classe pai (Disco)
		super(titulo, artista, anoLancamento);
		this.diametro = diametro;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}
	// Chama o método toString da classe pai e adiciona o diâmetro
	@Override
	public String toString() {
		return super.toString() + ", Diâmetro: " + diametro + " polegadas";
	}
}
