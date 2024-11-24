package sevicoAluguel;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class ServicoAluguel {
	private double precodisco;
	private LocalDate data;
	private double valor;
	private Aluguel disco;
	
	//Lista responsável por armazernar os resgitros dos alugueis 
	private ArrayList<Aluguel> aluguel = new ArrayList<>();
	
	//Método responsável por calcular o valor que o cliente pagará por atrasar o aluguel
	//Cobrando 2% de juros a quem atrasar 
	public double calculojuros(Aluguel aluguel, double valor) {
		
			//Utilização do método ChronoUnit para definir quantos dias se passaram desde a data definida para a devolução
			double dias = ChronoUnit.DAYS.between(aluguel.getDataAlugado().plusDays(5), aluguel.getDataDevolucao());
			double juros = valor + valor * 0.02* dias;
			
			return juros; 		  
   }	 
	public double getPrecodisco() {
		return precodisco;
	}

	public void setPrecodisco(double precodisco) {
		this.precodisco = precodisco;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
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
