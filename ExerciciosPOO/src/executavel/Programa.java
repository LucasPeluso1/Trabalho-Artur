package executavel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

import Entidades.Disco;
import Entidades.CD;
import Entidades.Vinil;
import gerencia.Loja;
import sevicoAluguel.Aluguel;
import sevicoAluguel.ServicoAluguel;

public class Programa {

	public static void main(String[] args) {
		//cria uma nova instância da classe Loja
		Loja loja = new Loja();

		Scanner scanner = new Scanner(System.in);
		int opcao = 0;
		// Adiciona discos ao programa
		loja.adicionarDisco(new CD("The Dark Side Of The Moon", "Pink Floyd", 1973, 10));
		loja.adicionarDisco(new CD("Love Yourself", "BTS", 2018, 26));
		loja.adicionarDisco(new CD("Dangerously In Love", "Beyonce", 2003, 16));
		loja.adicionarDisco(new Vinil("B-Day", "Beyonce", 2006, 11));
		loja.adicionarDisco(new Vinil("Fine Line", "Harry Styles", 2019, 12));
		loja.adicionarDisco(new Vinil("Sobrevivendo No Inferno", "Racionais MC'S", 1997, 12));
		loja.adicionarDisco(new CD("Gal Tropical", "Gal Costa", 1979, 12));

		// Loop do menu principal
		do {
			// Try chamado para caso ocorra alguma exceção do tipo imputmismatch
			try {
				System.out.println("\n-------------Bem Vindo a Vinyl Paradise!-------------");
				System.out.println("Menu:");
				System.out.println("1. Incluir Disco");
				System.out.println("2. Alterar Disco");
				System.out.println("3. Excluir Disco");
				System.out.println("4. Listar Discos");
				System.out.println("5. Buscar Disco");
				System.out.println("6. Listar Discos Ordenados por Título");
				System.out.println("7. Para registrar o aluguel de algum disco");
				System.out.println("8. Sair");
				System.out.print("Escolha uma opção: ");
				opcao = scanner.nextInt();
				//limpando buffer
				scanner.nextLine();

				switch (opcao) {

				case 1:
					 // Incluir Disco
					System.out.print("Título: ");
					String titulo = scanner.nextLine();
					
					//Impede que um disco ja cadastrado seja inserido novamente
					if (loja.buscarDisco(titulo) != null) {
						System.out.println("Erro: Já existe um disco com esse título na loja.");
						break;
					}

					System.out.print("Artista: ");
					String artista = scanner.nextLine();
					System.out.print("Ano de Lançamento: ");
					int anoLancamento = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Tipo de Disco (1 para CD, 2 para Vinil): ");
					int tipo = scanner.nextInt();
					scanner.nextLine();
					
					 // Verifica se eh um CD ou um vinil adiciona à loja
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
						//Erro caso seja digitado algo diferente de 1 ou 2
						System.out.println("Tipo de disco inválido!");
					}
					break;

				case 2:
					 // Alterar Disco
					System.out.print("Título do Disco a ser alterado: ");
					String tituloAlterar = scanner.nextLine();
					// Verifica se o disco existe
					if (loja.buscarDisco(tituloAlterar) == null) {
						System.out.println("Erro: Disco não encontrado. Certifique-se de que o título está correto.");
						break;
					}

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
					// Pede pra fazer a insercao do numero de faixas caso se trate de um disco
					if (novoTipo == 1) {
						System.out.print("Novo Número de Faixas: ");
						int novoNumeroFaixas = scanner.nextInt();
						scanner.nextLine();
						loja.alterarDisco(tituloAlterar,
								new CD(novoTitulo, novoArtista, novoAnoLancamento, novoNumeroFaixas));

					} else if (novoTipo == 2) {
						// Pede pra fazer a insercao do diametro do vinil
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
					 // Excluir Disco
					System.out.print("Título do Disco a ser excluído: ");
					String tituloExcluir = scanner.nextLine();
					//Verifica se o disco existe para permitir a exclusao
					if (loja.buscarDisco(tituloExcluir) != null) {
						loja.removerDisco(tituloExcluir);
						System.out.println("Disco removido com sucesso!");
					} else {
						System.out.println("Disco não encontrado!");
					}
					break;

				case 4:
					// Listar Discos
					System.out.println("Listando todos os discos:");
					for (Disco disco : loja.listarDiscos()) {
						System.out.println(disco);
					}
					break;

				case 5:
					 // Buscar Disco
					System.out.print("Título do Disco a ser buscado: ");
					String tituloBuscar = scanner.nextLine();
					Disco disco = loja.buscarDisco(tituloBuscar);
					//Verifica se o disco esta realmente registrado
					if (disco != null) {
						System.out.println("Disco encontrado: " + disco);
					} else {
						System.out.println("Disco não encontrado!");
					}
					break;

				case 6:
					 // Listar Discos Ordenados por Título
					System.out.println("Listando todos os discos ordenados por título:");
					for (Disco discoOrdenado : loja.listarDiscosOrdenadosPorTitulo()) {
						System.out.println(discoOrdenado);
					}
					break;

				case 7:
					 // Registrar Aluguel de Disco

					System.out.println("\n     Lista dos discos atualizada    \n");

					for (Disco discoOrdenado : loja.listarDiscosOrdenadosPorTitulo())
						//exibe os discos por titulo
						System.out.println(discoOrdenado);
					
					System.out.print("\nQual dos discos serão alugados(Prazo de devolução: 5 dias)");
					tituloBuscar = scanner.nextLine();
				    if (loja.buscarDisco(tituloBuscar) == null) {
				        System.out.println("Erro: O disco informado não está cadastrado. Aluguel não pode ser registrado.");
				        break; // Interrompe o processo de aluguel
				    }
					disco = loja.buscarDisco(tituloBuscar);
					System.out.print("\nDigite aqui a data em que foi alugado(dd/MM/yyyy): ");
					
					//Formatar a data para o padrao brasileiro
					DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate dataAlugado = LocalDate.parse(scanner.next(), fmt);
					System.out.print("\nDigite a data em que foi devolvido o disco(dd/MM/yyyy):");
					LocalDate dataDevolucao = LocalDate.parse(scanner.next(), fmt);
					//cria uma nova instância da classe Aluguel
					Aluguel aluguel = new Aluguel(dataDevolucao, dataAlugado);
					
					//verifica se o disco foi devolvido no prazo estipulado e calcula o juros pelo atraso da devolucao
					if (dataDevolucao.isAfter(dataAlugado.plusDays(5))) {
						ServicoAluguel servicoaluguel = new ServicoAluguel();
						System.out.print("\nO valor do alguel de " + tituloBuscar + " é de : "
								+ String.format("R$:" +"%.2f", servicoaluguel.calculojuros(aluguel)) + "\n");
					} else {
						System.out.println("\nO valor do aluguel de " + tituloBuscar + ", foi de R$: 40");
					}

					break;

				case 8:
					 // Sair

					System.out.println("Saindo...");

					break;

				default:
					System.out.println("Opção inválida!");
					System.out.println("Por favor digite uma opção válida");

				}

			} catch (InputMismatchException e) {
				 // Captura exceção de entrada inválida
				System.out.print("\nErro: Entrada inválida. por favor insira apenas um dos números acima\n");
				scanner.nextLine();

			}

		} while (opcao != 7);
	     // Registrar Aluguel de Disco

		System.out.println("\n----------------Lista de discos atualizada----------------\n ");

		for (Disco discoOrdenado : loja.listarDiscosOrdenadosPorTitulo()) {
			System.out.println(discoOrdenado);
		}

		scanner.close();
	}
}
