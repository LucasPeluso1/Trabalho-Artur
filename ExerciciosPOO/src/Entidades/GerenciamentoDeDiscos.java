package Entidades;

import java.util.List;

public interface GerenciamentoDeDiscos {
	  void adicionarDisco(Disco disco);
	    void alterarDisco(String titulo, Disco disco);
	    void removerDisco(String titulo);
	    Disco buscarDisco(String titulo);
	    List<Disco> listarDiscos();
	    List<Disco> listarDiscosOrdenadosPorTitulo();

}
