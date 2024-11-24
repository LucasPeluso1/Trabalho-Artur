package sevicoAluguel;

import java.time.LocalDate;
//Classe Aluguel que representa o aluguel de um disco
public class Aluguel {
	private LocalDate dataDevolucao;
	private LocalDate dataAlugado;
	
	public Aluguel(LocalDate dataDevolucao, LocalDate dataAlugado) {
		super();
		this.dataDevolucao = dataDevolucao;
		this.dataAlugado = dataAlugado;
		
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public LocalDate getDataAlugado() {
		return dataAlugado;
	}

	public void setDataAlugado(LocalDate dataAlugado) {
		this.dataAlugado = dataAlugado;
	}
	
	
	
}
	
