package gerencia;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


import Entidades.Disco;

public class Loja implements GerenciamentoDeDiscos {
	
	 private List<Disco> discos = new ArrayList<>();

	    public void LojaDeDiscos() {
	        discos = new ArrayList<>();
	    }
	    
	    //Método para adiconar um disco a lista 
	    @Override
	    public void adicionarDisco(Disco disco) {
	        discos.add(disco);
	    }
	    //Metodo alterarDisco que muda o disco selecionado pelo usuário 
	    @Override
	    public void alterarDisco(String titulo, Disco disco) {
	        for (int i = 0; i < discos.size(); i++) {
	        	//"If" que testa se o título passado pelo "for" é igual ao título selecionado pela pessoa, 
	            if (discos.get(i).getTitulo().equals(titulo)) {
	                discos.set(i, disco);
	                return;
	            }
	        }
	    }
	    //Método que chama "removeif", metodo da classe List para que possa remover o disco baseado no título
	    //digitado pelo usuário
	    @Override
	    public void removerDisco(String titulo) {
	        discos.removeIf(disco -> disco.getTitulo().equals(titulo));
	    }
	    //Método que usa um for each para percorrer os discos na lista, utilizando o if para filtrar aquele
	    //com o título digitado pelo usuário 
	    @Override
	    public Disco buscarDisco(String titulo) {
	        for (Disco disco : discos) {
	            if (disco.getTitulo().equals(titulo)) {
	                return disco;
	            }
	        }
	        return null;
	    }

	    @Override
	    public List<Disco> listarDiscos() {
	        return new ArrayList<>(discos);
	    }
	    
	    //Método para ordenar a lista dos discos de acordo com o título
	    @Override
	    public List<Disco> listarDiscosOrdenadosPorTitulo() {
	        List<Disco> discosOrdenados = new ArrayList<>(discos);
	        discosOrdenados.sort(Comparator.comparing(Disco::getTitulo));
	        return discosOrdenados;
	    }
	}



