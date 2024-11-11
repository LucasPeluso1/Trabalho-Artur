package Entidades;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Loja implements GerenciamentoDeDiscos {
	 private List<Disco> discos = new ArrayList<>();

	    public void LojaDeDiscos() {
	        discos = new ArrayList<>();
	    }

	    @Override
	    public void adicionarDisco(Disco disco) {
	        discos.add(disco);
	    }

	    @Override
	    public void alterarDisco(String titulo, Disco disco) {
	        for (int i = 0; i < discos.size(); i++) {
	            if (discos.get(i).getTitulo().equals(titulo)) {
	                discos.set(i, disco);
	                return;
	            }
	        }
	    }

	    @Override
	    public void removerDisco(String titulo) {
	        discos.removeIf(disco -> disco.getTitulo().equals(titulo));
	    }

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

	    @Override
	    public List<Disco> listarDiscosOrdenadosPorTitulo() {
	        List<Disco> discosOrdenados = new ArrayList<>(discos);
	        discosOrdenados.sort(Comparator.comparing(Disco::getTitulo));
	        return discosOrdenados;
	    }
	}



