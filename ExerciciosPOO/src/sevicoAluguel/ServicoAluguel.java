package sevicoAluguel;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
//Classe ServicoAluguel que gerencia os serviços de aluguel de discos
public class ServicoAluguel {
	private double precodisco;
	private Aluguel disco;

	// Lista responsável por armazernar os resgitros dos alugueis
	private ArrayList<Aluguel> aluguel = new ArrayList<>();

	// Método responsável por calcular o valor que o cliente pagará por atrasar o 
	//aluguel
	// Cobrando 2% de juros a quem atrasar
	public double calculojuros(Aluguel aluguel) {

		// Utilização do método ChronoUnit para definir quantos dias se passaram desde a
		// data definida para a devolução
		double dias = ChronoUnit.DAYS.between(aluguel.getDataAlugado().plusDays(5), aluguel.getDataDevolucao());
		 // Calcula o valor dos juros com base nos dias de atraso
		double juros = 40 + 40 * 0.02 * dias;
		 // Retorna o valor com juros
		return juros;
	}

	public double getPrecodisco() {
		return precodisco;
	}

	public void setPrecodisco(double precodisco) {
		this.precodisco = precodisco;
	}

	public Aluguel getDisco() {
		return disco;
	}

	public void setDisco(Aluguel disco) {
		this.disco = disco;
	}

	public ArrayList<Aluguel> getAluguel() {
		return aluguel;
	}

	public void setAluguel(ArrayList<Aluguel> aluguel) {
		this.aluguel = aluguel;
	}

}
