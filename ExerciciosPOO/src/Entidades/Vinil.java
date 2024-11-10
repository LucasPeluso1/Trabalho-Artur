package Entidades;

public class Vinil extends Disco {
	private double diametro;

	public Vinil(String titulo, String artista, int anoLancamento, double diametro ) {
		super(titulo,artista,anoLancamento);
		this.diametro = diametro;
	}

	public double getDiametro() {
		return diametro;
	}

	public void setDiametro(double diametro) {
		this.diametro = diametro;
	}

	@Override
	public String toString() {
		return super.toString() + ", Diâmetro: " + diametro + " polegadas";
	}
}
