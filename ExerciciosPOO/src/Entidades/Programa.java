package Entidades;

import java.util.List;
import java.util.Scanner;

public class Programa {

	public static void main(String[] args) {
		GerenciamentoDeDiscos loja = new GerenciamentoDeDiscos() {

			@Override
			public void removerDisco(String titulo) {
				// TODO Auto-generated method stub

			}

			@Override
			public List<Disco> listarDiscosOrdenadosPorTitulo() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public List<Disco> listarDiscos() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Disco buscarDisco(String titulo) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void alterarDisco(String titulo, Disco disco) {
				// TODO Auto-generated method stub

			}

			@Override
			public void adicionarDisco(Disco disco) {
				// TODO Auto-generated method stub

			}
		};
		Scanner scanner = new Scanner(System.in);

		// Adicionar discos automaticamente
		loja.adicionarDisco(new CD("The Dark Side Of The Moon", "Pink Floyd", 2001, 10));
		loja.adicionarDisco(new CD("Album2", "Artista2", 2002, 12));
		loja.adicionarDisco(new CD("Album3", "Artista3", 2003, 14));
		loja.adicionarDisco(new Vinil("Album4", "Artista4", 2004, 12.0));
		loja.adicionarDisco(new Vinil("Album5", "Artista5", 2005, 10.0));
		loja.adicionarDisco(new Vinil("Album6", "Artista6", 2006, 14.0));
		loja.adicionarDisco(new CD("Album7", "Artista7", 2007, 16));

		int opcao;
		do {
			System.out.println("Menu:");
			System.out.println("1. Incluir Disco");
			System.out.println("2. Alterar Disco");
			System.out.println("3. Excluir Disco");
			System.out.println("4. Listar Discos");
			System.out.println("5. Buscar Disco");
			System.out.println("6. Listar Discos Ordenados por Título");
			System.out.println("7. Sair");
			System.out.print("Escolha uma opção: ");
			opcao = scanner.nextInt();
			scanner.nextLine(); // Consumir nova linha

			switch (opcao) {
			case 1:
				System.out.print("Título: ");
				String titulo = scanner.nextLine();
				System.out.print("Artista: ");
				String artista = scanner.nextLine();
				System.out.print("Ano de Lançamento: ");
				int anoLancamento = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Tipo de Disco (1 para CD, 2 para Vinil): ");
				int tipo = scanner.nextInt();
				scanner.nextLine();
				if (tipo == 1) {
					System.out.print("Número de Faixas: ");
					int numeroFaixas = scanner.nextInt();
					scanner.nextLine();
					loja.adicionarDisco(new CD(titulo, artista, anoLancamento, numeroFaixas));
				} else if (tipo == 2) {
					System.out.print("Diâmetro do Vinil (em polegadas): ");
					double diametro = scanner.nextDouble();
					scanner.nextLine();
					loja.adicionarDisco(new Vinil(titulo, artista, anoLancamento, diametro));
				} else {
					System.out.println("Tipo de disco inválido!");
				}
				break;
			case 2:
				System.out.print("Título do Disco a ser alterado: ");
				String tituloAlterar = scanner.nextLine();
				System.out.print("Novo Título: ");
				String novoTitulo = scanner.nextLine();
				System.out.print("Novo Artista: ");
				String novoArtista = scanner.nextLine();
				System.out.print("Novo Ano de Lançamento: ");
				int novoAnoLancamento = scanner.nextInt();
				scanner.nextLine();
				System.out.print("Novo Tipo de Disco (1 para CD, 2 para Vinil): ");
				int novoTipo = scanner.nextInt();
				scanner.nextLine();
				if (novoTipo == 1) {
					System.out.print("Novo Número de Faixas: ");
					int novoNumeroFaixas = scanner.nextInt();
					scanner.nextLine();
					loja.alterarDisco(tituloAlterar,
							new CD(novoTitulo, novoArtista, novoAnoLancamento, novoNumeroFaixas));
				} else if (novoTipo == 2) {
					System.out.print("Novo Diâmetro do Vinil (em polegadas): ");
					double novoDiametro = scanner.nextDouble();
					scanner.nextLine();
					loja.alterarDisco(tituloAlterar,
							new Vinil(novoTitulo, novoArtista, novoAnoLancamento, novoDiametro));
				} else {
					System.out.println("Tipo de disco inválido!");
				}
				break;
			case 3:
				System.out.print("Título do Disco a ser excluído: ");
				String tituloExcluir = scanner.nextLine();
				loja.removerDisco(tituloExcluir);
				break;
			case 4:
				System.out.println("Listando todos os discos:");
				for (Disco disco : loja.listarDiscos()) {
					System.out.println(disco);
				}
				break;
			case 5:
				System.out.print("Título do Disco a ser buscado: ");
				String tituloBuscar = scanner.nextLine();
				Disco disco = loja.buscarDisco(tituloBuscar);
				if (disco != null) {
					System.out.println("Disco encontrado: " + disco);
				} else {
					System.out.println("Disco não encontrado!");
				}
				break;
			case 6:
				System.out.println("Listando todos os discos ordenados por título:");
				for (Disco discoOrdenado : loja.listarDiscosOrdenadosPorTitulo()) {
					System.out.println(discoOrdenado);
				}
				break;
			case 7:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção inválida!");
			}
		} while (opcao != 7);
		scanner.close();
	}
}
