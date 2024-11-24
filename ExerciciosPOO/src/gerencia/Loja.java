package gerencia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import Entidades.Disco;

public class Loja {

	// Lista que armazena os discos
	private List<Disco> discos = new ArrayList<>();

	// Método para adicionar um disco à lista
	public void adicionarDisco(Disco disco) {
		discos.add(disco);
	}

	// Metodo alterarDisco que muda o disco selecionado pelo usuário
	public void alterarDisco(String titulo, Disco disco) {
		for (int i = 0; i < discos.size(); i++) {
			// Verifica se o título do disco atual é igual ao título fornecido
			
			if (discos.get(i).getTitulo().equals(titulo)) {
				// Substitui o disco na posição atual pelo novo disco
				discos.set(i, disco);
				return;
			}
		}
	}

	 // Método para remover um disco da lista com base no título
	public void removerDisco(String titulo) {
		   // Remove o disco cujo título é igual ao título fornecido
		discos.removeIf(disco -> disco.getTitulo().equals(titulo));
	}

	// Método para buscar um disco na lista com base no título
	public Disco buscarDisco(String titulo) {
		// Percorre a lista de discos
		for (Disco disco : discos) {
			// Verifica se o título do disco atual é igual ao título fornecido
			if (disco.getTitulo().equals(titulo)) {
				   // Retorna o disco encontrado
				return disco;
			}
		}
		return null;
	}
	// Método para listar todos os discos
	public List<Disco> listarDiscos() {
		return new ArrayList<>(discos);
	}

	// Método para ordenar a lista dos discos de acordo com o título
	public List<Disco> listarDiscosOrdenadosPorTitulo() {
		List<Disco> discosOrdenados = new ArrayList<>(discos);
		discosOrdenados.sort(Comparator.comparing(Disco::getTitulo));
		 // Ordena a cópia da lista de discos pelo título
		return discosOrdenados;
	}
}
